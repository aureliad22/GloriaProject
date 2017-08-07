
/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.utils.AccessBase;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class AnswerDAO implements ICrud<Answer>{
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	private final static String LIST_RIGHT_ANSWERS = "SELECT * "
													+ "FROM reponses_donnees rd "
													+ "JOIN reponses r ON r.id = rd.idReponse "
													+ "JOIN questions_selectionnees qs ON qs.idQuestion = rd.idQuestion "
													+ "WHERE rd.idQuestion = ?"
													+ "AND rd.idReponse IN (SELECT id FROM reponses WHERE r.estBonne = 1);";
	
	
	private static final String LIST_GIVEN_ANSWERS = "SELECT * FROM reponses_donnees "
													+ "WHERE idStagiaire = ? "
													+ "AND idTest = ? "
													+ "AND idSection =? " 
													+ "AND idQuestion = ?";
	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#insert(java.lang.Object)
	 */
	@Override
	public boolean insert(Answer data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#update(java.lang.Object)
	 */
	@Override
	public boolean update(Answer data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Answer data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#selectById(int)
	 */
	@Override
	public Answer selectById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#selectAll()
	 */
	@Override
	public List<Answer> selectAll() throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#itemBuilder(java.sql.ResultSet)
	 */
	@Override
	public Answer itemBuilder(ResultSet rs) throws GloriaException {
		Answer result = new Answer();
		try {
			result.setId(rs.getInt("id"));
			result.setAnswer(rs.getString("enonce"));
			result.setCorrect(rs.getBoolean("estBonne"));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#itemBuilder : "+e.getMessage());
			throw new GloriaException("Erreur lors de la construction de la réponse.");
		}
		
		return result;
	}

	/**
	 * Méthode en charge de fournir la liste des réponses possibles pour
	 * la question dont l'identifiant est passé en paramètre.
	 * @param id de la question
	 * @return liste des reponses possibles
	 * @throws GloriaException 
	 */
	public List<Answer> getAllByQuestionId(int id) throws GloriaException {
		List<Answer> result = new ArrayList<Answer>();
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL LIST_ANSWERS_QUESTION(?)}");
			rqt.setInt(1, id);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()){
				result.add(itemBuilder(rs));
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#getAllByQuestionId : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de la liste des réponses possibles.");
		} 
		return result;
	}
 
	/**
	 * 
	 * Méthode en charge de retourner la liste des réponses correctes pour 
	 * la question dont l'identifiant est passé en parametre.
	 * @param id de la question
	 * @return liste des réponses correctes.
	 * @throws GloriaException
	 */
	public List<Answer> getRightAnswersByQuestionId(int id) throws GloriaException {
		List<Answer> result = new ArrayList<Answer>();
		try(Connection cnx = AccessBase.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement(LIST_RIGHT_ANSWERS);
			rqt.setInt(1, id);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()){
				result.add(itemBuilder(rs));
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#getRightAnswersByQuestionId : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de la liste des réponses correctes.");
		} 
		return result;
	}	

	/**
	 * Méthode en charge de retourner la liste des réponses fournies par le candidat
	 * pour la question dont l'identifiant (idStagiaire, idTest, idSection, idQuestion) est donné en parametre
	 * @param idStagiaire
	 * @param idTest
	 * @param idSection
	 * @param idQuestion
	 * @return liste des réponses fournies par le candidat
	 * @throws GloriaException 
	 */
	public List<Answer> getGivenAnswers(int idStagiaire, int idTest, int idSection, int idQuestion) throws GloriaException {
		List<Answer> result = new ArrayList<>();
		try (Connection cnx = AccessBase.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement(LIST_GIVEN_ANSWERS);
			rqt.setInt(1, idStagiaire);
			rqt.setInt(2, idTest);
			rqt.setInt(3, idSection);
			rqt.setInt(4, idQuestion);
			
			ResultSet rs=rqt.executeQuery();
			
			while (rs.next()){
				result.add(itemBuilder(rs));				
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#getGivenAnswers : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération des réponses fournies par le candidat.");
		} 
		return result;
	}

}

