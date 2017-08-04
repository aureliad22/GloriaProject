/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.ResultSet;
import java.util.List;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class AnswerDAO implements ICrud<Answer>{

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#insert(java.lang.Object)
	 */
	@Override
	public boolean insert(Answer data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#update(java.lang.Object)
	 */
	@Override
	public boolean update(Answer data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Answer data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#selectById(int)
	 */
	@Override
	public Answer selectById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#selectAll()
	 */
	@Override
	public List<Answer> selectAll() throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#itemBuilder(java.sql.ResultSet)
	 */
	@Override
	public Answer itemBuilder(ResultSet rs) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Méthode en charge de 
	 * @param id
	 * @return
	 */
	public List<Answer> getAllByQuestionId(int id) {
		// TODO Coder la récupération de la liste des réponses correspondant à une question
		return null;
	}

	

}
