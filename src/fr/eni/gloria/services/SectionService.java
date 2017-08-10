
/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.beans.Section;
import fr.eni.gloria.beans.Test;
import fr.eni.gloria.dao.QuestionDAO;
import fr.eni.gloria.dao.SectionDAO;
import fr.eni.gloria.dao.TestDAO;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
public  class SectionService {
	public static Section getSelectedQuestions(Section section, int idTest, int idStagiaire) throws GloriaException{
		//Appel de la PL qui récupère les questions selectionnées pour 
		List<Question> questionList = null ;
		questionList = new QuestionDAO().getSelectedQuestions(idTest, idStagiaire, section.getId());
		section.setQuestions(questionList);
		return section;
	}
	
	/**
	 * Méthode en charge de calculer le résultat attendu pour une section
	 * @param stagiaire
	 * @param test
	 * @param section
	 * @return
	 * @throws GloriaException 
	 */
	public static int getTotalSection(Candidate candidate, Test test, Section section) throws GloriaException {
		return new SectionDAO().getTotalSection(candidate.getId(), test.getId(), section.getId());
	}
}

