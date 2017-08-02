package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gloria.utils.GloriaLogger;

/**
 * Servlet implementation class ResultatsServlet
 */
public class ResultatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultatsServlet() {
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
		//Récupérer la liste des tests complétés
		
		//BOUCHON
		List<String> resultats = new ArrayList<String>();
		resultats.add("resultats test 1");
		resultats.add("resultats test 2");
		
		//Envoi de la liste à la jsp en charge de les afficher
		request.setAttribute("resultats", resultats);
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/resultats.jsp").forward(request, response);
	}

}
