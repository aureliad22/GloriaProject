package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.services.TestService;
import fr.eni.gloria.utils.GloriaException;
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
		HttpSession session = request.getSession(true);
		try {
			session.setAttribute("tests", new TestService().getTestHeads(((Candidate)session.getAttribute("user")).getId()));
		} catch (GloriaException e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/tests.jsp").forward(request, response);
		logger.exiting(this.getClass().getName(), "doPost");
	}

}
