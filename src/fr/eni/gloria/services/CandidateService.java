/**
 * @author adelaune2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.dao.CandidateDao;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * @author adelaune2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
public class CandidateService implements IService<Candidate> {
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	CandidateDao dao = new CandidateDao();

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#add(java.lang.Object)
	 */

	@Override
	public void add(Candidate data) throws GloriaException {
		dao.insert(data);
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#modify(java.lang.Object)
	 */
	@Override
	public void modify(Candidate data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#remove(java.lang.Object)
	 */
	@Override
	public void remove(Candidate data) throws GloriaException {
		// TODO Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#getAll()
	 */
	@Override
	public List<Candidate> getAll() throws GloriaException {
		// TODO Auto-generated method stub
		return new CandidateDao().selectAll();
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#getById(int)
	 */
	@Override
	public Candidate getById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}



}
