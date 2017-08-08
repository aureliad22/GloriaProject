/**
 * @author lvanhove2017
 * @date 7 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import fr.eni.gloria.utils.AccessBase;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * @author lvanhove2017
 * @date 7 août 2017
 * @version GloriaProject V1.0
 */
public class ResultDAO {
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	/**
	 * Méthode en charge de supprimer les réponses données par un 
	 * stagiaire à un test donné afin de mettre à jour les données.
	 * 
	 * @param idStagiaire Identifiant du stagiaire passant le test.
	 * @param idTest Identifiant du test passé
	 * @param idSection Identifiant de la section concernée du test 
	 * @param idQuestion Identifiant de la question concernée
	 * @throws GloriaException 
	 */
	public void cleanGivenAnswers(int idcandidate, int idTest, int idSection, int idQuestion) throws GloriaException {
		try (Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL DELETE_GIVEN_ANSWERS(?,?,?,?)}");
			rqt.setInt(1, idcandidate);
			rqt.setInt(2, idTest);
			rqt.setInt(3, idSection);
			rqt.setInt(4, idQuestion);
			rqt.executeUpdate();
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#cleanGivenAnswers : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'écrasement des réponses.");
		} 	
		
	}

	/**
	 * Méthode en charge de faire l'insertion d'un réponse donnée à un test.
	 * 
	 * @param idStagiaire Identifiant du stagiaire passant le test
	 * @param idTest Identifiant du test passé. 
	 * @param idSection Identifiant de la section du test
	 * @param idQuestion Identifiant de la question
	 * @param idReponse Identifiant de la réponse donnée.
	 * @throws GloriaException 
	 */
	public void addGivenAnswer(int idcandidate, int idTest, int idSection, int idQuestion, int idReponse) throws GloriaException {
		try (Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL ADD_GIVEN_ANSWER(?,?,?,?,?)}");
			rqt.setInt(1, idcandidate);
			rqt.setInt(2, idTest);
			rqt.setInt(3, idSection);
			rqt.setInt(4, idQuestion);
			rqt.setInt(5, idReponse);
			rqt.executeUpdate();
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#addGivenAnswer : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'enregistrement des réponses.");
		} 
	}
	
	/**
	 * 
	 * Méthode en charge d'insérer dans la base de onnées le résultat obtenu par 
	 * un stagiaire à un test
	 * @param idCandidate
	 * @param idTest
	 * @param score
	 * @return True si l'insertion s'est bien effectuée
	 * @throws GloriaException
	 */
	public boolean addResultCandidate(int score, int idCandidate, int idTest) throws GloriaException{
		boolean result = false;
		try (Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL REGISTER_SCORE_CANDIDATE(?,?,?)}");
			rqt.setInt(1, score);
			rqt.setInt(2, idCandidate);
			rqt.setInt(3, idTest);
			result = rqt.executeUpdate() == 1;
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#addResultCandidate : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'insertion du résultat du candidat dans la base de données");
		} 
		return result;
	}
}
