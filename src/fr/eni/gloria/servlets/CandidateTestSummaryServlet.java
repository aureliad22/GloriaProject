package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.services.QuestionService;

/**
 * Servlet implementation class CandidateTestSummaryServlet
 */
public class CandidateTestSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateTestSummaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Récupérer la liste des questions 
		
		//Stocker la lsite dans la session
		
		
		
		//request.getSession().setAttribute("questionList", questionList);
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/testSummary.jsp").forward(request, response);
	}

}
