/**
 * @author adelaune2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package tests.fr.eni.gloria;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.dao.CandidateDao;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author adelaune2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class CandidateDaoTest {

	/**
	 * Méthode en charge de 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Méthode en charge de 
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Méthode en charge de 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Méthode en charge de 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuthenticate() {
		
	}
	
	@Test
	public void testInsert() throws GloriaException {
		CandidateDao daoC = new CandidateDao();
		Candidate expected = new Candidate();
		expected.setLastName("Wololo");
		expected.setFirstName("Toto");
		expected.setLogin("wololo");
		expected.setEmail("wololo@sonmail.fr");
		expected.setPassword("password");
		daoC.insert(expected);
		
		Candidate actual = daoC.selectById(expected.getId());
		
		assertEquals(expected.getLastName().trim(), actual.getLastName());
		assertEquals(expected.getFirstName().trim(), actual.getFirstName());
	}
}
