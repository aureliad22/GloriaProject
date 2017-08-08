///**
// * @author adelaune2017
// * @date 2 août 2017
// * @version GloriaProject V1.0
// */
//package tests.fr.eni.gloria;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import fr.eni.gloria.beans.Candidate;
//import fr.eni.gloria.dao.CandidateDAO;
//import fr.eni.gloria.utils.GloriaException;
//
///**
// * @author adelaune2017
// * @date 2 août 2017
// * @version GloriaProject V1.0
// */
//public class CandidateDaoTest {
//
//	/**
//	 * Méthode en charge de 
//	 * @throws java.lang.Exception
//	 */
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	/**
//	 * Méthode en charge de 
//	 * @throws java.lang.Exception
//	 */
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	/**
//	 * Méthode en charge de 
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	/**
//	 * Méthode en charge de 
//	 * @throws java.lang.Exception
//	 */
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void testAuthenticate() throws GloriaException {
//		CandidateDAO daoC = new CandidateDAO();		
//		Candidate expected = daoC.authenticate("aurelia.delaune", "password");
//
//		assertEquals(expected.getFirstName().trim(), "Aurélia");
//	}
//	
//	@Test
//	public void testSelectAll() throws GloriaException {
//		CandidateDAO daoC = new CandidateDAO();
//		List<Candidate> listCandidates = null;
//		listCandidates = daoC.selectAll();
//		
//		int expected = 5;
//		int actual = listCandidates.size();
//		
//		assertEquals(expected, actual);
//	}	
//	
//	@Test
//	public void testSelectById() throws GloriaException{
//		CandidateDAO daoC = new CandidateDAO();
//		Candidate expected = daoC.selectById(1);
//		
//		assertEquals(expected.getLastName().trim(), "Delauné");
//		assertEquals(expected.getPassword().trim(), "password");
//
//	}
//	
//	@Test
//	public void testInsert() throws GloriaException {
//		CandidateDAO daoC = new CandidateDAO();
//		Candidate expected = new Candidate();
//		expected.setLastName("Wololo");
//		expected.setFirstName("Toto");
//		expected.setLogin("wololo");
//		expected.setEmail("wololo@sonmail.fr");
//		expected.setPassword("password");
//		daoC.insert(expected);
//				
//		Candidate actual = daoC.selectById(expected.getId());
//		assertEquals(expected.getLastName().trim(), actual.getLastName().trim());
//		assertEquals(expected.getFirstName().trim(), actual.getFirstName().trim());
//	}
//
//
//
/////**
//// * @author adelaune2017
//// * @date 2 août 2017
//// * @version GloriaProject V1.0
//// */
////package fr.eni.gloria.dao;
////
////import static org.junit.Assert.*;
////
////import java.util.List;
////
////import org.junit.After;
////import org.junit.Before;
////import org.junit.Test;
////
////import fr.eni.gloria.beans.Candidate;
////import fr.eni.gloria.utils.GloriaException;
////
/////**
//// * @author adelaune2017
//// * @date 2 août 2017
//// * @version GloriaProject V1.0
//// */
////public class CandidateDaoTest {
////	Candidate expectedCandidate;
////	
////	/**
////	 * Méthode en charge d'instancier le expectedCandidate avant chaque test
////	 * Le testInsert a été testé avant de factoriser dans le beforeTest
////	 * @throws GloriaException 
////	 */
////	@Before
////	public void setUp() throws GloriaException {
////		expectedCandidate = new Candidate();
////		CopyPromotionDAO daoP = new CopyPromotionDAO();
////		
////		expectedCandidate.setLastName("Wololo");
////		expectedCandidate.setFirstName("Toto");
////		expectedCandidate.setLogin("wololo");
////		expectedCandidate.setEmail("wololo@sonmail.fr");
////		expectedCandidate.setPassword("password");
////		expectedCandidate.setPromotion(daoP.selectById(1));	
////	}
////	
////	/**
////	 * Méthode en charge de supprimer le expectedCandidate après chaque test
////	 * Le testDelete a été testé avant de factoriser dans le afterTest
////	 * @throws GloriaException 
////	 */
////	@After
////	public void tearDown() throws GloriaException{
////		new CopyCandidateDAO().delete(expectedCandidate);		
////	}
////	
////	@Test
////	public void testAuthenticate() throws GloriaException {
////		CopyCandidateDAO daoC = new CopyCandidateDAO();		
////		Candidate expected = daoC.authenticate("aurelia.delaune", "password");
////
////		assertEquals(expected.getFirstName().trim(), "Aurélia");
////	}
////	
////	@Test
////	public void testSelectAll() throws GloriaException {
////		CopyCandidateDAO daoC = new CopyCandidateDAO();
////		List<Candidate> listCandidates = null;
////		listCandidates = daoC.selectAll();
////		
////		int expected = 5;
////		int actual = listCandidates.size();
////		
////		assertEquals(expected, actual);
////	}	
////	
////	@Test
////	public void testSelectById() throws GloriaException{
////		CopyCandidateDAO daoC = new CopyCandidateDAO();
////		Candidate expected = daoC.selectById(1);
////		
////		assertEquals(expected.getLastName().trim(), "Delauné");
////		assertEquals(expected.getLogin().trim(), "aurelia.delaune");
////		assertEquals(expected.getPassword().trim(), "password");
////	}
////	
////	@Test
////	public void testInsert() throws GloriaException {
////		CopyCandidateDAO daoC = new CopyCandidateDAO();
////		
////		assertTrue(daoC.insert(expectedCandidate));	
////		
////		Candidate actual = daoC.selectById(expectedCandidate.getId());
////		assertEquals(expectedCandidate.getLastName().trim(), actual.getLastName().trim());
////		assertEquals(expectedCandidate.getFirstName().trim(), actual.getFirstName().trim());
////	}
////
////	
////	@Test
////	public void testUpdate() throws GloriaException{
////		CopyCandidateDAO daoC = new CopyCandidateDAO();
////		
////		// Création du candidat à modifier:
////		daoC.insert(expectedCandidate);
////		
////		// Test de la Dao Update
////		expectedCandidate.setEmail("toto@sonmail.fr");
////		expectedCandidate.setPromotion(new CopyPromotionDAO().selectById(2));
////		daoC.update(expectedCandidate);
////
////		Candidate actual = daoC.selectById(expectedCandidate.getId());
////		assertEquals("toto@sonmail.fr", actual.getEmail());
////		assertEquals("DL", actual.getPromotion().getTitle());
////	}
////	
////	@Test
////	public void testDelete() throws GloriaException{
////		CopyCandidateDAO daoC = new CopyCandidateDAO();
////
////		daoC.insert(expectedCandidate);
////		
////		// Test de la dao Delete
////		Candidate toDelete = daoC.selectById(expectedCandidate.getId());
////		assertTrue(daoC.delete(toDelete));
////	}
////}
//>>>>>>> master
