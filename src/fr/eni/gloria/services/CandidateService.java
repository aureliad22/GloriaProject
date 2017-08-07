/**
 * @author adelaune2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.dao.CandidateDAO;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author adelaune2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
public class CandidateService implements IService<Candidate> {
	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#add(java.lang.Object)
	 */

	@Override
	public void add(Candidate data) throws GloriaException {
		CandidateDAO daoC = new CandidateDAO();
		daoC.insert(data);
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#modify(java.lang.Object)
	 */
	@Override
	public void modify(Candidate data) throws GloriaException {
		CandidateDAO daoC = new CandidateDAO();
		daoC.update(data);
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#remove(java.lang.Object)
	 */
	@Override
	public void remove(Candidate data) throws GloriaException {
		CandidateDAO daoC = new CandidateDAO();
		daoC.delete(data);
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#getAll()
	 */
	@Override
	public List<Candidate> getAll() throws GloriaException {
		CandidateDAO daoC = new CandidateDAO();
		return daoC.selectAll();
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#getById(int)
	 */
	@Override
	public Candidate getById(int id) throws GloriaException {
		CandidateDAO daoC = new CandidateDAO();
		return daoC.selectById(id);
	}

	/**
	 * Méthode en charge d'authentifier un candidat 
	 * avec son identifiant (email ou login) et son mot de passe 
	 * @param login
	 * @param password
	 * @return
	 * @throws GloriaException 
	 */
	public Candidate authenticate(String login, String password) throws GloriaException {
		return new CandidateDAO().authenticate(login, password);
	}
}
