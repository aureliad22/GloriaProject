/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Question;
import fr.eni.gloria.utils.AccessBase;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class QuestionDAO implements ICrud<Question>{
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());

	/**
	 *  Méthode permettant d'insérer une nouvelle question dans la BdD.
	 * L'id de la question sera mis à jour avec l'id autogénéré par la BdD.
	 * 
	 * @param Question à insérer
	 * @return Vrai si l'insertion s'est correctement effectuée.
	 */
	@Override
	public boolean insert(Question data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{?=CALL ADD_QUESTION(?,?,?)}");			
			rqt.registerOutParameter(1, Types.INTEGER);
			rqt.setString(2, data.getQuestion());
			rqt.setString(3, data.getImageURI());
			// TODO gestion liste de reponses et des nullables
			result = rqt.executeUpdate()==1;
			data.setId(rqt.getInt(1));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#insert : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'insertion de la question dans la base de données.");
		}
		return result;
	}

	/**
	 * Méthode permettant de mettre à jour une question dans la BdD
	 * @param Question à mettre à jour
	 * @return Vrai si la mise à jour a fonctionné.
	 */
	@Override
	public boolean update(Question data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL MODIFY_QUESTION(?,?,?,?)}");			
			rqt.setInt(1, data.getId());
			rqt.setString(2, data.getQuestion());
			rqt.setString(3, data.getImageURI());
			// TODO gestion liste de reponses et des nullables
			result = rqt.executeUpdate()==1;
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#update : "+e.getMessage());
			throw new GloriaException("Erreur lors de la modification de la question dans la base de données.");
		}
		return result;
	}

	/**
	 * Méthode permettant de supprimer de la base de données la 
	 * question donnée en paramètre.
	 * 
	 * @param Question à supprimer.
	 * @return Vrai si la suppression a réussi, faux sinon.
	 */
	@Override
	public boolean delete(Question data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL DELETE_QUESTION(?)}");			
			rqt.setInt(1, data.getId());

			result = rqt.executeUpdate()==1;
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#delete : "+e.getMessage());
			throw new GloriaException("Erreur lors de la suppression de la question dans la base de données.");
		}
		return result;
	}

	/**
	 * Méthode permettant de retourner une question d'après son identifiant
	 * 
	 * @param id Identifiant de la question
	 * @return Question ayant l'identifiant id
	 */
	@Override
	public Question selectById(int id) throws GloriaException {
		Question result = null ;
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL FIND_BY_ID_QUESTION(?)}");
			rqt.setInt(1, id);
			ResultSet rs=rqt.executeQuery();
			if (rs.next()){
				result = itemBuilder(rs);
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#findById : "+e.getMessage());
			throw new GloriaException("Erreur lors de la recherche de la question dans la base de données.");
		}
			
		return result;
	}

	/**
	 * Méthode en charge de construire la liste des questions 
	 * depuis la base de données.
	 * 
	 * @return Liste des questions existentielles.
	 */
	@Override
	public List<Question> selectAll() throws GloriaException {
		List<Question> result = new ArrayList<Question>();
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("LIST_QUESTIONS");
			ResultSet rs = rqt.executeQuery();
			
			while (rs.next()){
				result.add(itemBuilder(rs));				
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#selectAll : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de la liste des questions.");
		} 		
		return result;
	}

	/**
	 * Méthode en charge de construire un object Question 
	 * depuis la ligne courante du ResultSet donné en paramètre.
	 * @param rs ResultSet à lire
	 * @return result Question construit à partir de rs.
	 */
	@Override
	public Question itemBuilder(ResultSet rs) throws GloriaException {
		Question result = new Question();
		try {
			result.setId(rs.getInt("id"));
			result.setQuestion(rs.getString("enonce"));
			result.setImageURI(rs.getString("imageUri"));
			result.setAnswers(new AnswerDAO().getAllByQuestionId(result.getId()));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#itemBuilder : "+e.getMessage());
			throw new GloriaException("Erreur lors de la construction de la question depuis la base de données.");
		}
		
		return result;
	}

	/**
	 * Méthode en charge de fournir la liste des questions qui ont 
	 * été selectionnée pour le candidat, le test et la section donnés en paramètres
	 * 
	 * @param idTest Ientifiant du test à passer
	 * @param idStagiaire Identifiant du stagiaire passant le test
	 * @param idSection Identifiant de la section du test.
	 * 
	 * @return La liste des question selectionnées pour cette section, de ce test, pour ce candidat.
	 * 
	 * @throws GloriaException 
	 */
	public List<Question> getSelectedQuestions(int idTest, int idStagiaire,	int idSection) throws GloriaException {
		List<Question> result = new ArrayList<Question>();
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL LIST_QUESTIONS_BY_CANDIDATEandTESTandSECTION(?,?,?)}");
			rqt.setInt(1, idStagiaire);
			rqt.setInt(2, idTest);
			rqt.setInt(3, idSection);
			ResultSet rs = rqt.executeQuery();
			while(rs.next()){
				result.add(itemBuilder(rs));
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#getSelectedQuestions : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de la liste de questions pour le candidat depuis la base de données.");
		}
		
		return result;
	}

	/**
	 * Méthode en charge de marquer la question correspondant aux paramètre fournis.
	 *  
	 * @param idStagiaire Identifiant du Stagiaire
	 * @param idTest Identifiant du test
	 * @param idSection Identifiant de la section
	 * @param idQuestion Identifiant de la section.
	 * @throws GloriaException
	 */
	public void markQuestion(int idStagiaire, int idTest, int idSection, int idQuestion) throws GloriaException{
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL MARK_QUESTION(?,?,?,?)}");
			rqt.setInt(1, idStagiaire);
			rqt.setInt(2, idTest);
			rqt.setInt(3, idSection);
			rqt.setInt(4, idQuestion);
			rqt.executeUpdate();
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#getSelectedQuestions : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de la liste de questions pour le candidat depuis la base de données.");
		}
	}

}
