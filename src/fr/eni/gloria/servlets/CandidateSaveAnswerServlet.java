package fr.eni.gloria.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
import fr.eni.gloria.services.QuestionService;
import fr.eni.gloria.services.ResultService;
import fr.eni.gloria.utils.GloriaException;

/**
 * Servlet implementation class CandidateSaveAnswerServlet
 */
public class CandidateSaveAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateSaveAnswerServlet() {
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
		//Récupération des paramètres : 
		HttpSession session = request.getSession();
		RequestDispatcher rd = null ;
		Test test = (Test)session.getAttribute("requestedTest");
		Candidate stagiaire = ((Candidate)session.getAttribute("user"));
		Section section = test.getSections().get((int)session.getAttribute("currentSectionIndex"));
		Question question= section.getQuestions().get((int) session.getAttribute("currentQuestionIndex"));
		//Récupére les réponses données pour faire un setGiven(true)
	
		
		String[] reponses = request.getParameterValues("answer");
		String isMarked = request.getParameter("marquer");
		
		
		int[] tabIdReponsesDonnees = null;
		if (reponses != null) {
			question.setHasGivenAnswers(true);
			tabIdReponsesDonnees = new int[reponses.length];
			for (int i = 0; i < reponses.length; i++) {
				tabIdReponsesDonnees[i] = Integer.parseInt(reponses[i]);
			}
		}else{
			question.setHasGivenAnswers(false);
			tabIdReponsesDonnees = new int[0];
			for (Answer a : question.getAnswers()){
				a.setGiven(false);
			}
		}
		
		//iInitialise le paramètre Given de la réponse
		for (Answer answer : question.getAnswers()) {
			for (int answerId : tabIdReponsesDonnees) {
				if (answer.getId()==answerId) {
					answer.setGiven(true);
				}
			}
			
		}
		
		try {
			ResultService.writeAnswer(stagiaire, test, section, question, tabIdReponsesDonnees);
		} catch (GloriaException e) {
			request.setAttribute("error", e.getMessage());
		}
		
		//Gestion du marque de la question
		if (isMarked != null) {
			System.out.println("Question marquée");
			test.getSections().get((int)session.getAttribute("currentSectionIndex")).getQuestions().get((int) session.getAttribute("currentQuestionIndex")).setMarked(true);
		}else{
			test.getSections().get((int)session.getAttribute("currentSectionIndex")).getQuestions().get((int) session.getAttribute("currentQuestionIndex")).setMarked(false);
		}
		
		try {
			System.out.println("Ecriture du marquage dans la bdd");
			QuestionService.markQuestion(stagiaire, test, section, question);
		} catch (GloriaException e) {
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		
		//Routage en fonction du bouton cliqué
		if (request.getParameter("nextQuestion") != null) {
			rd = request.getRequestDispatcher("/Candidate/RunTest");
		}else{
			rd = request.getRequestDispatcher("/Candidate/TestSummary");
		}
		rd.forward(request, response);
	}

}
