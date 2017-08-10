/**
 * @author Administrateur
 * @date 8 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;

import fr.eni.gloria.beans.ThemeQuestion;
import fr.eni.gloria.dao.Theme_QuestionDAO;
import fr.eni.gloria.utils.GloriaException;

 /**
 * @author Administrateur
 * @date 8 août 2017
 * @version GloriaProject V1.0
 */
public class ThemeQuestionService implements IService<ThemeQuestion> {
	Theme_QuestionDAO dao = new Theme_QuestionDAO();

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#add(java.lang.Object)
	 */
	@Override
	public void add(ThemeQuestion data) throws GloriaException {
		dao.insert(data);
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#modify(java.lang.Object)
	 */
	@Override
	public void modify(ThemeQuestion data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#remove(java.lang.Object)
	 */
	@Override
	public void remove(ThemeQuestion data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getAll()
	 */
	@Override
	public List<ThemeQuestion> getAll() throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getById(int)
	 */
	@Override
	public ThemeQuestion getById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

}
