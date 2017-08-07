package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import fr.eni.gloria.services.AnswerService;
import fr.eni.gloria.services.ResultService;
import fr.eni.gloria.services.TestService;
import fr.eni.gloria.utils.GloriaException;

/**
 * Servlet implementation class CandidateResultServlet
 */
public class CandidateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandidateResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération des parametres de session (stagiaire, test)
		HttpSession session = request.getSession();
		Test test = (Test) session.getAttribute("requestedTest");
		Candidate stagiaire = ((Candidate) session.getAttribute("user"));

		// 1. Récupération du total attendu pour le test courant:
		int total = TestService.getTotal(stagiaire, test);

		// 2. Calcul du résultat obtenu
		int resultatCandidat = 0;	
			// 2.1. Parcours des questions
			for (Section section : test.getSections()) {
				for (Question question : section.getQuestions()) {
					try {
						List<Answer> rightAnswers = AnswerService.getRightAnswers(question);
						List<Answer> givenAnswers = ResultService.getGivenAnswers(stagiaire, test, section, question);
	
						if (givenAnswers != null) {
			// 2.2. Comparaison des tailles des listes de réponses attendues et obtenues
							if (rightAnswers.size() == givenAnswers.size()) {
			// 2.3. TODO Comparaison des id des réponses des 2 listes
								if (true) {
									resultatCandidat += question.getWeight();
								}
							}
						}
					} catch (GloriaException e) {
						request.setAttribute("error", e.getMessage());
					}
				}
			}
		
		// 3. Calcul du pourcentage de réussite:
		int score = (resultatCandidat/total)*100;
		
		// 4. Comparaison du score avec les seuils du test:
		if(score <= test.getSuccessTreshold()){
			System.out.println("test acquis");
		} else if(score<= test.getSemiSuccessTreshold()){
			System.out.println("test en cours d'acquisition");
		} else {
			System.out.println("test non acquis");
		}
		
	}

}
