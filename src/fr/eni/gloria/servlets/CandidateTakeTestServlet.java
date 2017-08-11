package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Test;
import fr.eni.gloria.services.TestService;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * Servlet implementation class CandidateTakeTestServlet
 */
public class CandidateTakeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateTakeTestServlet() {
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
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Test> tests = (List<Test>)session.getAttribute("tests");
		Test requestedTest = getTestFromListById(tests, Integer.parseInt(request.getParameter("idTest")));
		try {
			requestedTest = TestService.fillTest(requestedTest, (Candidate)session.getAttribute("user"));
		} catch (GloriaException e) {
			request.setAttribute("error", e.getMessage());
		}
		session.setAttribute("requestedTest", requestedTest);
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/takeTest.jsp").forward(request, response);
		
		logger.exiting(this.getClass().getName(), "doPost");
	}

	/**
	 * Méthode en charge de trouver le test ayant l'id passé
	 * en paramètre dans la liste de tests du candidat, stockée 
	 * dans la session.
	 * 
	 * @param tests Liste des tests du candidat
	 * @param id Identifiant du test à retourner.
	 * @return Le test ayant l'identifiant id
	 */
	private Test getTestFromListById(List<Test> tests, int id) {
		Test result = null ;
		for (Test test : tests) {
			if (test.getId() == id) {
				result = test;
			}
		}
		return result ;		
	}
}
