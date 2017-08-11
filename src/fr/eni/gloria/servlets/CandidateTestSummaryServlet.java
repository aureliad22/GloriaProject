package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.beans.Section;
import fr.eni.gloria.beans.Test;
import fr.eni.gloria.services.ResultService;
import fr.eni.gloria.utils.GloriaException;

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
		HttpSession session = request.getSession();
		Map<Integer, Question> questions = new HashMap<Integer, Question>();
		
		Map<Integer, Boolean> hasGivenAnswers = new HashMap<Integer, Boolean>(); //relation entre le numero local de la question
		Test currentTest = (Test) session.getAttribute("requestedTest");
		Candidate user = (Candidate)session.getAttribute("user");
		List<Section> sections = currentTest.getSections();
		
		int numQuestion = 1 ;
		for (Section section : sections) {
			for (Question question : section.getQuestions()) {
				questions.put(numQuestion, question);
				List<Answer> givenAnswers;
				try {
					givenAnswers = ResultService.getGivenAnswers(user, currentTest, section, question);
					if (givenAnswers.size()==0) {
						hasGivenAnswers.put(numQuestion, false);
					}else{
						hasGivenAnswers.put(numQuestion, true);
					}
				} catch (GloriaException e) {
					request.setAttribute("error", e.getMessage());
					e.printStackTrace();
				}
				numQuestion++;
			}			
		}
		session.setAttribute("questionList", questions);
		session.setAttribute("givenAnswers", hasGivenAnswers);
		
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/testSummary.jsp").forward(request, response);
	}
}
