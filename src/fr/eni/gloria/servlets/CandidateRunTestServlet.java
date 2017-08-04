package fr.eni.gloria.servlets;

import java.io.IOException;

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
		 
		
		//Si test non commencé :
		if (session.getAttribute("testBegun")==null) {
			//Initialisation des variables d'itération : 
			session.setAttribute("testBegun", true);
			session.setAttribute("currentSectionIndex", 0);
			session.setAttribute("currentQuestionIndex", 0);
			session.setAttribute("currentTestDone", false);
			
			//Récupération de la première question du test
			Question nextQuestion = ((Test)session.getAttribute("currentTest")).getSections().get(0).getQuestions().get(0);
			request.setAttribute("currentQuestion", nextQuestion);
			request.getRequestDispatcher("/WEB-INF/jsp/candidate/runTest.jsp");
			
		//Si le test est déja commencé mais non terminé :	
		}else if (!(boolean)session.getAttribute("currentTestDone")){
			//Si on arrive à la fin de la liste de question de la section courante :
			if (Integer.parseInt((String)session.getAttribute("currentQuestionIndex"))== ((Test)session.getAttribute("currentTest")).getSections().get(Integer.parseInt((String)session.getAttribute("currentSectionIndex"))).getQuestions().size()-1){			
				//si la section courante est la dernière section du test courant mais que le candidat n'a pas cloturé le test :
				if (Integer.parseInt((String)session.getAttribute("currentSectionIndex")) == ((Test)session.getAttribute("currentTest")).getSections().size()-1) {
					//affichage du récap du test
					
					
				}else{
					//TODO Incrément de 1 de currentSectionIndex
					session.setAttribute("currentSectionIndex", Integer.parseInt((String)session.getAttribute("currentSectionIndex")+1));
					//TODO Reset de currentQuestionIndex
					session.setAttribute("currentQuestionIndex", 0);
				}			
			}	
		//Si le test est terminé et cloturé : 	
		}else{
			//Afficher récapitulatif
		}
	}

}
