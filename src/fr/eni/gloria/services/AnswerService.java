/**
 * @author oreade
 * @date 7 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.ArrayList;
import java.util.List;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.dao.AnswerDAO;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author oreade
 * @date 7 août 2017
 * @version GloriaProject V1.0
 */
public class AnswerService implements IService<Answer>{

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#add(java.lang.Object)
	 */
	@Override
	public void add(Answer data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#modify(java.lang.Object)
	 */
	@Override
	public void modify(Answer data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#remove(java.lang.Object)
	 */
	@Override
	public void remove(Answer data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#getAll()
	 */
	@Override
	public List<Answer> getAll() throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.services.IService#getById(int)
	 */
	@Override
	public Answer getById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Answer> getRightAnswers(Question question) throws GloriaException {
		List<Answer> result = new AnswerDAO().getRightAnswersByQuestionId(question.getId());		
		return result;
	}
}
