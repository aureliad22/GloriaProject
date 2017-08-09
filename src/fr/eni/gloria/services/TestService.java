
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
import fr.eni.gloria.dao.SectionDAO;
import fr.eni.gloria.dao.TestDAO;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
public class TestService implements IService<Test> {

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#add(java.lang.Object)
	 */
	@Override
	public void add(Test data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#modify(java.lang.Object)
	 */
	@Override
	public void modify(Test data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#remove(java.lang.Object)
	 */
	@Override
	public void remove(Test data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#getAll()
	 */
	@Override
	public List<Test> getAll() throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#getById(int)
	 */
	@Override
	public Test getById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Méthode en charge de fournir les entetes de test 
	 * pour le candidat identifié dans la session.
	 *  
	 * @param idCandidate Identifiant du candidat 
	 * @return Liste des entetes de tests.
	 * @throws GloriaException 
	 */
	public List<Test> getTestHeads(int idCandidate) throws GloriaException{
		return new TestDAO().selectTestsByCandidateId(idCandidate);
	}
	
	/**
	 * Méthode en charge de fournir la liste des tests 
	 * complétés par le candidat identifié dans la session.
	 *  
	 * @param idCandidate Identifiant du candidat 
	 * @return Liste des tests complétés.
	 * @throws GloriaException 
	 */
	public List<Test> getResultTests(Candidate candidate) throws GloriaException {
		return new TestDAO().selectResultTestsByCandidateId(candidate.getId());
	}
	/**
	 *  Méthode en charge d'injecter les dépendances dans l'objet Test 
	 *  fourni en paramètre
	 *   
	 * @param test a compléter avec les dépendances.
	 * @param candidate Candidat devant passer le test
	 * @return Le test complet, prêt à être passé par le candidat.
	 * @throws GloriaException
	 */
	public static Test fillTest(Test test, Candidate candidate) throws GloriaException{
		//TODO Appeler les méthodes de Service pour compléter l'objet test avec sections / questions / reponses spécifiques au candidat

		//Récupération des sections : 
		test = getTestSections(test);
		
		//Récupération des question des sections ; 
		for(Section section : test.getSections()){
			//Injection des questions dans la section
			section = SectionService.getSelectedQuestions(section, test.getId(), candidate.getId());
			
			//Injection des réponses dans chaque question
			for(Question question : section.getQuestions()){
				question = QuestionService.getAnswers(question);
			}
		}
		return test;
	}	
	
	/**
	 * Méthode en charge de récupérer la liste des sections qui 
	 * composent le test donné en paramètre.
	 *  
	 * @param test dont on doit récupérer les sections
	 * @return le test dont l'attribut sections a été initialisé.
	 * @throws GloriaException
	 */
	public static Test getTestSections(Test test) throws GloriaException{
		List<Section> sectionList = null ;
		sectionList = new SectionDAO().getSectionsByTestId(test.getId());
		test.setSections(sectionList);
		return test ;
	}

	/**
	 * Méthode en charge de retourner le total attendu à un test donné
	 * @param stagiaire
	 * @param test
	 * @return totalTest
	 * @throws GloriaException 
	 */
	public static int getTotal(Candidate candidate, Test test) throws GloriaException {
		return new TestDAO().getTotal(candidate.getId(), test.getId());
	}

}

