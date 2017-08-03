/**
 * @author adelaune2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.Date;
import java.util.List;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Promotion;
import fr.eni.gloria.dao.Teacher.CandidateDao;

/**
 * @author adelaune2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
public class CandidateService {
	/**
	 * Méthode en charge de 
	 * @return une liste de formations (vide ou pas) ou null si la base est inaccessible
	 */
	public static List<Candidate> lister() {
		List<Candidate> liste=null;
		try {
			liste = CandidateDao.lister();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}

	/**
	 * Méthode en charge de 
	 * @param identifiant
	 * @throws Exception 
	 */
	public static void supprimer(int identifiant) throws Exception {
		Candidate c = new Candidate();
		c.setId(identifiant);
		CandidateDao.supprimer(c);
		
	}

	/**
	 * Méthode en charge de 
	 * @param identifiant
	 * @return
	 * @throws Exception 
	 */
	public static Candidate selectionner(int identifiant) throws Exception {
		Candidate c = new Candidate();
		c.setId(identifiant);
		return CandidateDao.rechercher(c);
	}

	/**
	 * Méthode en charge de 
	 * @param identifiant
	 * @param libelle
	 * @param description
	 * @param debut
	 * @param fin
	 * @throws Exception 
	 */
	public static void modifier(String nom, String prenom,String email, String login, String password, int idPromotion
			) throws Exception {
		Candidate candidat = new Candidate();
		Promotion promotion = new Promotion();
		candidat.setFirstName(nom);
		candidat.setLastName(prenom);
		candidat.setEmail(email);
		candidat.setLastName(login);
		candidat.setLastName(password);
		promotion.setId(idPromotion);			
		CandidateDao.modifier(candidat);
		
	}

}
