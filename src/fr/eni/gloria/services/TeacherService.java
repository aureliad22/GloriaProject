/**
 * @author Administrateur
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.ArrayList;
import java.util.List;

import fr.eni.gloria.beans.Teacher;
import fr.eni.gloria.dao.Teacher.TeacherDao;
import fr.eni.gloria.utils.GloriaException;

 /**
 * @author Administrateur
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
public class TeacherService implements IService<Teacher> {

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#add(java.lang.Object)
	 */
	@Override
	public void add(Teacher data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#modify(java.lang.Object)
	 */
	@Override
	public void modify(Teacher data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#remove(java.lang.Object)
	 */
	@Override
	public void remove(Teacher data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getAll()
	 */
	@Override
	public List<Teacher> getAll() throws GloriaException {
		List<Teacher> result = new ArrayList<Teacher>();
		TeacherDao tdao = new TeacherDao();
		
		return result;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getById(int)
	 */
	@Override
	public Teacher getById(int id) throws GloriaException {
		Teacher result = new Teacher();
		TeacherDao tdao = new TeacherDao();
		return result;
	}
	
	public Teacher authenticate(String login, String password){
		Teacher result = null;
		TeacherDao tdao = new TeacherDao();
		try {
			result=tdao.authenticate(login, password);
		} catch (GloriaException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
