/**
 * @author Administrateur
 * @date 8 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;

import fr.eni.gloria.beans.Theme;
import fr.eni.gloria.dao.ThemeDAO;
import fr.eni.gloria.utils.GloriaException;

 /**
 * @author Administrateur
 * @date 8 août 2017
 * @version GloriaProject V1.0
 */
public class ThemeService implements IService<Theme> {
	
	
	ThemeDAO dao = new ThemeDAO();

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#add(java.lang.Object)
	 */
	@Override
	public void add(Theme data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#modify(java.lang.Object)
	 */
	@Override
	public void modify(Theme data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#remove(java.lang.Object)
	 */
	@Override
	public void remove(Theme data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getAll()
	 */
	@Override
	public List<Theme> getAll() throws GloriaException {
		List<Theme> liste=null;		
		liste = dao.selectAll();		
		return liste;
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getById(int)
	 */
	@Override
	public Theme getById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

}
