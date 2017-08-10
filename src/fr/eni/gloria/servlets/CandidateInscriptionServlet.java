package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Test;
import fr.eni.gloria.services.TestService;
import fr.eni.gloria.utils.GloriaException;

/**
 * Servlet implementation class CandidateInscriptionServlet
 */
public class CandidateInscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateInscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListeTestsLibelle(request);		
		request.getRequestDispatcher("/WEB-INF/jsp/teacher/subscribeCandidat.jsp").forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {ListeTestsLibelle(request);
		
		request.getRequestDispatcher("/WEB-INF/jsp/teacher/subscribeCandidat.jsp").forward(request, response);
		
	}
		
	
	
	
	private void ListeTestsLibelle(HttpServletRequest request) {
		
		TestService ts = new TestService();
		List<Test> listeTests = new ArrayList<Test>();		
		 try {
			listeTests = ts.getAll();
			
		} catch (GloriaException e) {
			System.out.println("probleme de récupération servlet");
			e.printStackTrace();
		}
		 request.setAttribute("listeTests", listeTests);
	}
	

}
