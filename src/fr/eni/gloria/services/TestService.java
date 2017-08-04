/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.ArrayList;
import java.util.List;

import fr.eni.gloria.beans.Test;
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
	
	public List<Test> getTestHeads(int idCandidate){
		List<Test> result = new ArrayList<Test>();
		for (Test test : new TestDAO().selectTestByCandidate(idCandidate)) {
			
		}
		
		
		return result;
	}

}
