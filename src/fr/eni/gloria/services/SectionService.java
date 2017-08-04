/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;

import fr.eni.gloria.beans.Question;
import fr.eni.gloria.beans.Section;

/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
public  class SectionService {
	public static Section getSelectedQuestions(Section section, int idTest, int idStagiaire){
		//Appel de la PL qui récupère les questions selectionnées pour 
		List<Question> questionList = null ;
		
		section.setQuestions(questionList);
		return section;
	}
}
