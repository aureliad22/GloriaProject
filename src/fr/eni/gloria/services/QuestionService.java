/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.dao.AnswerDAO;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
public class QuestionService {

	/**
	 * Méthode en charge de retourner la liste des réponses proposées 
	 * pour une question donnée.
	 * 
	 * @param question dont on doit récupérer les réponses possibles.
	 * @return la question passée en paramètre dont l'attribut answers
	 * 			a été initialisé.
	 * @throws GloriaException 
	 */
	public static Question getAnswers(Question question) throws GloriaException {
		// TODO appel de la DAO Answer pour récupérer la liste d'après l'id de la question
		List<Answer> reponses = null ;
		reponses = new AnswerDAO().getAllByQuestionId(question.getId());
		question.setAnswers(reponses);
		return question;
	}

}
