package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.services.CandidateService;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * Servlet implementation class CandidateResearch
 */
public class CandidateResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	private CandidateService candidateService = new CandidateService(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateResearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			research(request, response);
		} catch (GloriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			research(request, response);
		} catch (GloriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * En charge de 
	 * @param request
	 * @param response
	 * @throws GloriaException 
	 */
	private void research(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,GloriaException {		
		List<Candidate> liste ; 
		liste = candidateService.getAll();

		if(liste!=null)
		{
			request.setAttribute("listeCandidats", liste);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/teacher/gestionCandidat.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("erreur", "Les candidats sont inaccessibles pour le moment");
		}
	}
}
