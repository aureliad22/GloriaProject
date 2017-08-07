/**
 * @author lvanhove2017
 * @date 7 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.logging.Logger;

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
	public static void writeAnswer(int idStagiaire, int idTest, int idSection,	int idQuestion, int[] tabReponses) throws GloriaException {
		new ResultDAO().cleanGivenAnswers(idStagiaire, idTest, idSection, idQuestion);
		
		for (int i = 0; i < tabReponses.length; i++) {
			new ResultDAO().addGivenAnswer(idStagiaire, idTest, idSection, idQuestion, tabReponses[i]);
		}
	}

}
