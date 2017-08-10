/**
 * @author lvanhove2017
 * @date 7 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.beans.Section;
import fr.eni.gloria.beans.Test;
import fr.eni.gloria.dao.AnswerDAO;
import fr.eni.gloria.dao.ResultDAO;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * @author lvanhove2017
 * @date 7 août 2017
 * @version GloriaProject V1.0
 */
public class ResultService {
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	
	/**
	 * Méthode en charge de récupérer les réponses fournies par le candidat et
	 * de les transmettre à la BdD via ResultatDAO
	 * 
	 * @param idStagiaire Identifiant du candidat
	 * @param idTest identifiant du test en cours
	 * @param idSection identifiant de la section en cours
	 * @param idQuestion identifiant de la question en cours
	 * @param tabReponses Tableau des réponses cochées pour la question en cours
	 * @throws GloriaException 
	 */
	public static void writeAnswer(Candidate candidate, Test test, Section section,	Question question, int[] tabReponses) throws GloriaException {
		new ResultDAO().cleanGivenAnswers(candidate.getId(), test.getId(), section.getId(), question.getId());
		
		for (int i = 0; i < tabReponses.length; i++) {
			new ResultDAO().addGivenAnswer(candidate.getId(), test.getId(), section.getId(), question.getId(), tabReponses[i]);
		}
	}

	/**
	 * 
	 * Méthode en charge de retourner la liste des réponses fournies par le candidat 
	 * pour une question spécifique (idTest, idSection, idQuestion) à partir de la BdD
	 * @param candidate
	 * @param test
	 * @param section
	 * @param question
	 * @return Liste des réponses données par le candidat
	 * @throws GloriaException
	 */
	public static List<Answer> getGivenAnswers(Candidate candidate, Test test, Section section,	Question question) throws GloriaException{
		List<Answer> result= new AnswerDAO().getGivenAnswers(candidate.getId(), test.getId(), section.getId(), question.getId());
		return result;
	}
	
	/**
	 * 
	 * Méthode en charge d'ajouter le résultat obtenu par un candidat à un test dans la BdD
	 * @param score
	 * @param candidate
	 * @param test
	 * @return Vrai si l'insertion a bien eu lieu
	 * @throws GloriaException
	 */
	public static boolean addResultCandidate(int score, Candidate candidate, Test test) throws GloriaException{
		boolean result = false;
		result = new ResultDAO().addResultCandidate(score, candidate.getId(), test.getId());
		
		return result;
	}
}
