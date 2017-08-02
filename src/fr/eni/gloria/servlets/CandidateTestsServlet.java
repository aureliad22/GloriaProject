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
		//Récupérer la liste des tests disponibles pour ce candidate
		HttpSession session = request.getSession(true);
		//BOUCHON
		List<Test> tests = new ArrayList<>();
		Test test1 = new Test();

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
			q1.setQuestion("Qui est Gloria ?");
				a1.setAnswer("Le Grand Pope");
				a1.setCorrect(false);
				a2.setAnswer("La Réincarnation d'Athena");
				a2.setCorrect(true);
			q2.setQuestion("Que pensez-vous de Gloria ?");
				a3.setAnswer("Elle est nulle.");
				a3.setCorrect(false);
				a4.setAnswer("Elle est super !");
				a4.setCorrect(true);
			q3.setQuestion("Avez vous des choses à redire sur Gloria ?");
				a5.setAnswer("Non merci madame...");
				a5.setCorrect(true);
				a6.setAnswer("Et comment qu'il y a à redire !");
				a6.setCorrect(false);
			q4.setQuestion("Pensez-vous avoir les moyens de critiquer Gloria ?");
				a7.setAnswer("Oui, je suis le meilleur dev du monde.");
				a7.setCorrect(false);
				a8.setAnswer("Non, je ne conçoit pas qu'on puisse critiquer Gloria.");
				a8.setCorrect(true);
		
		tests.add(test1);		
		
		//Affichage de la liste dans la jsp tests.jsp
		session.setAttribute("tests", tests);
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/tests.jsp").forward(request, response);
	}

}
