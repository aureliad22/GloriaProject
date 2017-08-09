package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Question;
import fr.eni.gloria.beans.Test;

/**
 * Servlet implementation class CandidateRunTestServlet
 */
public class CandidateRunTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateRunTestServlet() {
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
		HttpSession session = request.getSession();
		Test currentTest = (Test)session.getAttribute("requestedTest"); 
		RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/jsp/candidate/runTest.jsp");
		int currentQuestionIndex = 0;
		int currentSectionIndex =0;
		int questionMaxIndex =0;
		int sectionMaxIndex =0;
		
		if (session.getAttribute("testBegun")==null) { 
			initParameters(session);
			currentQuestionIndex = (int) session.getAttribute("currentQuestionIndex");
			currentSectionIndex = (int) session.getAttribute("currentSectionIndex");
			getNextQuestion(session, currentTest, currentQuestionIndex, currentSectionIndex);
			
		//2. Si le test est déja commencé mais non terminé :	
		}else if (!(boolean)session.getAttribute("currentTestDone")){ 
			//Récupération des variables : 
			currentQuestionIndex = (int) session.getAttribute("currentQuestionIndex");
			currentSectionIndex = (int) session.getAttribute("currentSectionIndex");
			questionMaxIndex = currentTest.getSections().get(currentSectionIndex).getQuestions().size()-1 ;
			sectionMaxIndex = currentTest.getSections().size()-1;
			
			//2.1 Si on arrive à la fin de la liste de question de la section courante :
			if (currentQuestionIndex == questionMaxIndex){
				// 2.1.1 si la section courante est la dernière section du test courant mais que le candidat n'a pas cloturé le test :
				if (currentSectionIndex == sectionMaxIndex) {
					session.setAttribute("authorizeSummary", true); //Pour activer lun bouton qui permet d'arriver directement sur le recap du test
					rd=request.getRequestDispatcher("/Candidate/TestSummary");
				
				//2.1.2. Passage à la section suivante. 
				}else{
					currentQuestionIndex = 0 ;
					session.setAttribute("currentSectionIndex",++currentSectionIndex);
					session.setAttribute("currentQuestionIndex", currentQuestionIndex);
					getNextQuestion(session, currentTest, currentQuestionIndex,	currentSectionIndex);
				}
			//2.2 Passage à la prochaine question de la section courante	
			}else{
				//Incrément de l'index de question
				session.setAttribute("currentQuestionIndex", ++currentQuestionIndex);
				getNextQuestion(session, currentTest, currentQuestionIndex,	currentSectionIndex);
			}
		//3. Si le test est terminé et cloturé : 	
		}else{
			rd=request.getRequestDispatcher("/WEB-INF/jsp/candidate/testResult.jsp");
		}
		System.out.println("IndexSection  : "+currentSectionIndex  + " | SectionID  : "+currentTest.getSections().get(currentSectionIndex).getId());
		System.out.println("QuestionIndex : "+currentQuestionIndex + " | QuestionID : "+currentTest.getSections().get(currentSectionIndex).getQuestions().get(currentQuestionIndex).getId());
		System.out.println("_____________________________________");
		//Display next question
		rd.forward(request, response);
	}

	/**
	 * Méthode en charge de mettre à disposition dans la session la prochaine question à soumettre au candidat.
	 * @param session
	 * @param currentTest
	 * @param currentQuestionIndex
	 * @param currentSectionIndex
	 */
	private void getNextQuestion(HttpSession session, Test currentTest,	int currentQuestionIndex, int currentSectionIndex) {
		Question nextQuestion = currentTest.getSections().get(currentSectionIndex).getQuestions().get(currentQuestionIndex);
		session.setAttribute("nextQuestion", nextQuestion);
	}

	
	/**
	 * Méthode en charge d'initialiser les paramètre pour le parcours des questions du test
	 * @param session
	 */
	private void initParameters(HttpSession session) {
		session.setAttribute("testBegun", true);
		session.setAttribute("currentSectionIndex", 0);
		session.setAttribute("currentQuestionIndex", 0);
		session.setAttribute("currentTestDone", false);
		session.setAttribute("authorizeSummary", false);
	}
	
	

}
