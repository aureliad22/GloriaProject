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

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Test;
import fr.eni.gloria.services.TestService;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * Servlet implementation class ResultatsServlet
 */
public class CandidateResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateResultsServlet() {
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
		Candidate candidate = (Candidate)session.getAttribute("user");
		session.setAttribute("candidate", candidate);
		
		List<Test> resultats = new ArrayList<Test>();
		List<String> statusTest = new ArrayList<>();
		try {
			//Récupérer la liste des tests complétés
			resultats = new TestService().getResultTests(candidate);
			for (Test test : resultats) {
				int totalTestCandidat = test.getResult();
				String bilan;
				
				if(totalTestCandidat >= test.getSuccessTreshold()){
					bilan = "Acquis";
				} else if(totalTestCandidat>= test.getSemiSuccessTreshold()){
					bilan = "En cours d'acquisition";
				} else {
					bilan = "Non acquis";
				}
				statusTest.add(bilan);
			}			
		} catch (GloriaException e) {
			request.setAttribute("error", e.getMessage());
		}
		//Envoi de la liste à la jsp en charge de les afficher
		session.setAttribute("resultats", resultats);
		session.setAttribute("statusTest", statusTest);

		request.getRequestDispatcher("/WEB-INF/jsp/candidate/resultats.jsp").forward(request, response);
		logger.exiting(this.getClass().getName(), "doPost");
	}
}
