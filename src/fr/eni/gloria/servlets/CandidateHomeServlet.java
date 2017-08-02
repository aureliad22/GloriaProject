package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gloria.utils.GloriaLogger;

/**
 * Servlet implementation class CandidateHomeServlet
 */
public class CandidateHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.entering(this.getClass().getName(), "process");
		boolean testEnCours = false ;
		
		//Check si un test est en cours avec l'attribut tempsRestant de la table inscriptions
		if (testEnCours) {
			//recharger le test avec les question et les réponses données et le temps restant.
			//TODO Coder vérification de test en cours.
		}else{
			request.getRequestDispatcher("/WEB-INF/jsp/candidate/home.jsp").forward(request, response);
		}
		
		logger.exiting(this.getClass().getName(), "process");
	}



}
