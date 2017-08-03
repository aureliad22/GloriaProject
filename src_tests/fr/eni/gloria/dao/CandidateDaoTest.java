/**
 * @author adelaune2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author adelaune2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class CandidateDaoTest {

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
		//CopyPromotionDAO daoP = new CopyPromotionDAO();
		
		Candidate expected = new Candidate();
		expected.setLastName("Wololo");
		expected.setFirstName("Toto");
		expected.setLogin("wololo");
		expected.setEmail("wololo@sonmail.fr");
		expected.setPassword("password");
		//expected.setPromotion(daoP.selectById(1));
		daoC.insert(expected);
				
		Candidate actual = daoC.selectById(expected.getId());
		assertEquals(expected.getLastName().trim(), actual.getLastName().trim());
		assertEquals(expected.getFirstName().trim(), actual.getFirstName().trim());
	}

	@Test
	public void testUpdate(){
		fail("not yet implemented");
	}
	
	@Test
	public void testDelete() throws GloriaException{
		CopyCandidateDao daoC = new CopyCandidateDao();
		
		// Création du candidat à supprimer:
		CopyPromotionDAO daoP = new CopyPromotionDAO();
		Candidate expected = new Candidate();
		expected.setLastName("Wololo");
		expected.setFirstName("Toto");
		expected.setLogin("wololo");
		expected.setEmail("wololo@sonmail.fr");
		expected.setPassword("password");
		expected.setPromotion(daoP.selectById(1));
		daoC.insert(expected);
				
		Candidate toDelete = daoC.selectById(expected.getId());
		assertFalse(daoC.delete(toDelete));
	}
}
