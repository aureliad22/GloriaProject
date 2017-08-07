package fr.eni.gloria.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Test;
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
		Test test = (Test)session.getAttribute("requestedTest");
		int idTest = test.getId();
		int idStagiaire = ((Candidate)session.getAttribute("user")).getId();
		int idSection = test.getSections().get((int)session.getAttribute("currentSectionIndex")).getId();
		int idQuestion = Integer.parseInt(request.getParameter("idQuestion"));
		String[] reponses = request.getParameterValues("answer");
		int[] tabReponses = new int[reponses.length];
		for (int i = 0; i < reponses.length; i++) {
			tabReponses[i] = Integer.parseInt(reponses[i]);
		}
		
		//Suppression de la réponse donnée à cette question (cas de changement de réponse)
		try {
			ResultService.writeAnswer(idStagiaire, idTest, idSection, idQuestion, tabReponses);
		} catch (GloriaException e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/Candidate/RunTest").forward(request, response);
	}

}
