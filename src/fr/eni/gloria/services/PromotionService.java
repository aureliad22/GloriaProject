/**
 * @author Administrateur
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Promotion;
import fr.eni.gloria.dao.PromotionDAO;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

 /**
 * @author Administrateur
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
public class PromotionService implements IService<Promotion> {
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	PromotionDAO dao = new PromotionDAO();
	
	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#add(java.lang.Object)
	 */
	@Override
	public void add(Promotion data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#modify(java.lang.Object)
	 */
	@Override
	public void modify(Promotion data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#remove(java.lang.Object)
	 */
	@Override
	public void remove(Promotion data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getAll()
	 */
	@Override
	public List<Promotion> getAll() throws GloriaException {
		List<Promotion> liste = new ArrayList<Promotion>();
		liste=dao.selectAll();		
		return liste;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getById(int)
	 */
	@Override
	public Promotion getById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

}
