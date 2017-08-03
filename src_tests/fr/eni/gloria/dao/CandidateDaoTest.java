/**
 * @author adelaune2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author adelaune2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class CandidateDaoTest {
	Candidate expectedCandidate;
	
	/**
	 * Méthode en charge d'instancier le expectedCandidate avant chaque test
	 * Le testInsert a été testé avant de factoriser dans le beforeTest
	 * @throws GloriaException 
	 */
	@Before
	public void setUp() throws GloriaException {
		expectedCandidate = new Candidate();
		CopyPromotionDAO daoP = new CopyPromotionDAO();
		
		expectedCandidate.setLastName("Wololo");
		expectedCandidate.setFirstName("Toto");
		expectedCandidate.setLogin("wololo");
		expectedCandidate.setEmail("wololo@sonmail.fr");
		expectedCandidate.setPassword("password");
		expectedCandidate.setPromotion(daoP.selectById(1));	
	}
	
	/**
	 * Méthode en charge de supprimer le expectedCandidate après chaque test
	 * Le testDelete a été testé avant de factoriser dans le afterTest
	 * @throws GloriaException 
	 */
	@After
	public void tearDown() throws GloriaException{
		new CopyCandidateDao().delete(expectedCandidate);		
	}
	
	@Test
	public void testAuthenticate() throws GloriaException {
		CopyCandidateDao daoC = new CopyCandidateDao();		
		Candidate expected = daoC.authenticate("aurelia.delaune", "password");

		assertEquals(expected.getFirstName().trim(), "Aurélia");
	}
	
	@Test
	public void testSelectAll() throws GloriaException {
		CopyCandidateDao daoC = new CopyCandidateDao();
		List<Candidate> listCandidates = null;
		listCandidates = daoC.selectAll();
		
		int expected = 5;
		int actual = listCandidates.size();
		
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testSelectById() throws GloriaException{
		CopyCandidateDao daoC = new CopyCandidateDao();
		Candidate expected = daoC.selectById(1);
		
		assertEquals(expected.getLastName().trim(), "Delauné");
		assertEquals(expected.getLogin().trim(), "aurelia.delaune");
		assertEquals(expected.getPassword().trim(), "password");
	}
	
	@Test
	public void testInsert() throws GloriaException {
		CopyCandidateDao daoC = new CopyCandidateDao();
		
		assertTrue(daoC.insert(expectedCandidate));	
		
		Candidate actual = daoC.selectById(expectedCandidate.getId());
		assertEquals(expectedCandidate.getLastName().trim(), actual.getLastName().trim());
		assertEquals(expectedCandidate.getFirstName().trim(), actual.getFirstName().trim());
	}

	
	@Test
	public void testUpdate() throws GloriaException{
		CopyCandidateDao daoC = new CopyCandidateDao();
		
		// Création du candidat à modifier:
		daoC.insert(expectedCandidate);
		
		// Test de la Dao Update
		expectedCandidate.setEmail("toto@sonmail.fr");
		expectedCandidate.setPromotion(new CopyPromotionDAO().selectById(2));
		daoC.update(expectedCandidate);

		Candidate actual = daoC.selectById(expectedCandidate.getId());
		assertEquals("toto@sonmail.fr", actual.getEmail());
		assertEquals("DL", actual.getPromotion().getTitle());
	}
	
	@Test
	public void testDelete() throws GloriaException{
		CopyCandidateDao daoC = new CopyCandidateDao();

		daoC.insert(expectedCandidate);
		
		// Test de la dao Delete
		Candidate toDelete = daoC.selectById(expectedCandidate.getId());
		assertTrue(daoC.delete(toDelete));
	}
}
