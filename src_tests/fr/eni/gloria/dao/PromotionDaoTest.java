/**
 * @author adelaune2017
 * @date 3 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.eni.gloria.beans.Promotion;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author adelaune2017
 * @date 3 août 2017
 * @version GloriaProject V1.0
 */
public class PromotionDaoTest {

	@Test
	public void testSelectById() throws GloriaException {
		CopyPromotionDAO daoP = new CopyPromotionDAO();
		
		Promotion expected = daoP.selectById(1);		
		assertEquals(expected.getTitle(), "CDI");
		
		expected = daoP.selectById(2);		
		assertEquals(expected.getTitle(), "DL");
	}

}
