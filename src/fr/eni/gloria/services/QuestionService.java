
/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;
import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.dao.AnswerDAO;
import fr.eni.gloria.dao.QuestionDAO;
import fr.eni.gloria.utils.GloriaException;

/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
public class QuestionService implements IService<Question> {
	QuestionDAO dao = new QuestionDAO();

	/**
	 * Méthode en charge de retourner la liste des réponses proposées 
	 * pour une question donnée.
	 * 
	 * @param question dont on doit récupérer les réponses possibles.
	 * @return la question passée en paramètre dont l'attribut answers
	 * 			a été initialisé.
	 * @throws GloriaException 
	 */
	public static Question getAnswers(Question question) throws GloriaException {
		// TODO appel de la DAO Answer pour récupérer la liste d'après l'id de la question
		List<Answer> reponses = null ;
		reponses = new AnswerDAO().getAllByQuestionId(question.getId());
		question.setAnswers(reponses);
		return question;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#add(java.lang.Object)
	 */
	@Override
	public void add(Question data) throws GloriaException {
		
		dao.insert(data);
		for (Answer reponse : data.getAnswers()) {
		new AnswerDAO().insert(data.getId(),reponse.getAnswer()	,reponse.isCorrect());
		}
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#modify(java.lang.Object)
	 */
	@Override
	public void modify(Question data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#remove(java.lang.Object)
	 */
	@Override
	public void remove(Question data) throws GloriaException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getAll()
	 */
	@Override
	public List<Question> getAll() throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.services.IService#getById(int)
	 */
	@Override
	public Question getById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * Méthode en charge de marquer une question. 
	 * @param idStagiaire
	 * @param idTest
	 * @param idSection
	 * @param idQuestion
	 * @throws GloriaException
	 */
	public static void markQuestion(int idStagiaire, int idTest, int idSection, int idQuestion) throws GloriaException{
		new QuestionDAO().markQuestion(idStagiaire, idTest, idSection, idQuestion); 
	}
}

