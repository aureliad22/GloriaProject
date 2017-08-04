/**
 * @author Administrateur
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao.Teacher;

import java.sql.ResultSet;
import java.util.List;

import fr.eni.gloria.beans.Teacher;
import fr.eni.gloria.dao.ICrud;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author Administrateur
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class TeacherDao implements ICrud<Teacher>{

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#insert(java.lang.Object)
	 */
	@Override
	public boolean insert(Teacher data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#update(java.lang.Object)
	 */
	@Override
	public boolean update(Teacher data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Teacher data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#selectById(int)
	 */
	@Override
	public Teacher selectById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#selectAll()
	 */
	@Override
	public List<Teacher> selectAll() throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#itemBuilder(java.sql.ResultSet)
	 */
	@Override
	public Teacher itemBuilder(ResultSet rs) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

}
