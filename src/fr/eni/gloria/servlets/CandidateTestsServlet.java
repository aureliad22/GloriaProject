package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.beans.Test;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * Servlet implementation class TestsServlet
 */
public class CandidateTestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateTestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.entering(this.getClass().getName(), "doPost");
		//Récupérer la liste des tests disponibles pour ce candidate
		HttpSession session = request.getSession(true);
		//TODO Supprimer BOUCHON
		List<Test> tests = new ArrayList<>();
		Test test1 = new Test();
		Test test2 = new Test();
		test2.setId(2);
		test2.setTitle("POO - Débutant");
		test2.setDuration(50);
		Question q1 = new Question();
		Question q2 = new Question();
		Question q3 = new Question();
		Question q4 = new Question();

		Answer a1 = new Answer();
		Answer a2 = new Answer();
		Answer a3 = new Answer();
		Answer a4 = new Answer();
		Answer a5 = new Answer();
		Answer a6 = new Answer();
		Answer a7 = new Answer();
		Answer a8 = new Answer();
	
		
		test1.setTitle("Enquête sur Gloria");
		test1.setId(1);
		test1.setDuration(30);
		test1.setSemiSuccessTreshold(40);
			q1.setQuestion("Qui est Gloria ?");
			q1.setId(1);
				a1.setAnswer("Le Grand Pope");
				a1.setCorrect(false);
				a2.setAnswer("La Réincarnation d'Athena");
				a2.setCorrect(true);
			q2.setQuestion("Que pensez-vous de Gloria ?");
			q2.setId(2);
				a3.setAnswer("Elle est nulle.");
				a3.setCorrect(false);
				a4.setAnswer("Elle est super !");
				a4.setCorrect(true);
			q3.setQuestion("Avez vous des choses à redire sur Gloria ?");
			q3.setId(3);
				a5.setAnswer("Non merci madame...");
				a5.setCorrect(true);
				a6.setAnswer("Et comment qu'il y a à redire !");
				a6.setCorrect(false);
			q4.setQuestion("Pensez-vous avoir les moyens de critiquer Gloria ?");
			q4.setId(4);
				a7.setAnswer("Oui, je suis le meilleur dev du monde.");
				a7.setCorrect(false);
				a8.setAnswer("Non, je ne conçoit pas qu'on puisse critiquer Gloria.");
				a8.setCorrect(true);
		List<Answer> rq1 = new ArrayList<Answer>();
		rq1.add(a1);
		rq1.add(a2);
		
		List<Answer> rq2 = new ArrayList<Answer>();
		rq2.add(a3);
		rq2.add(a4);
		
		List<Answer> rq3 = new ArrayList<Answer>();
		rq3.add(a5);
		rq3.add(a6);
		
		List<Answer> rq4 = new ArrayList<Answer>();
		rq4.add(a7);
		rq4.add(a8);
		
		q1.setAnswers(rq1);
		q2.setAnswers(rq2);
		q3.setAnswers(rq3);
		q4.setAnswers(rq4);
		List<Question> questions = new ArrayList<Question>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		test1.setQuestions(questions);
		tests.add(test1);
		tests.add(test2);
		
		//Affichage de la liste dans la jsp tests.jsp
		session.setAttribute("tests", tests);
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/tests.jsp").forward(request, response);
		logger.exiting(this.getClass().getName(), "doPost");
	}

}
