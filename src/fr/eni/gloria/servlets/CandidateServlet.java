package fr.eni.gloria.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.services.CandidateService;


/**
 * Servlet implementation class CandidateServlet
 */
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidateService candidateService;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		listerCandidats(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("supprimer")!=null)
		{
			supprimerCandidat(request,response);
		}
		else if(request.getParameter("modifier")!=null)
		{
			afficherModificationCandidat(request,response);
		}
		else if(request.getParameter("validerModification")!=null)
		{
			validerModificationCandidat(request,response);
		}
	}
	
	/**
	 * Méthode en charge de 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listerCandidats(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Candidate> liste = candidateService.lister();
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
	
	/**
	 * Méthode en charge de 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void supprimerCandidat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int identifiant = Integer.parseInt(request.getParameter("id"));
		try {
			candidateService.supprimer(identifiant);
			request.setAttribute("message", "La suppression s'est déroulée avec succès.");
		} catch (Exception e) {
			request.setAttribute("erreur", "La suppression a échoué.");
			e.printStackTrace();
		}
		listerCandidats(request, response);
		
	}
	
	/**
	 * Méthode en charge de 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void afficherModificationCandidat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int identifiant = Integer.parseInt(request.getParameter("id"));
		try {
			Candidate candidatAModifier = candidateService.selectionner(identifiant);
			request.setAttribute("candidatAModifier", candidatAModifier);
		} catch (Exception e) {
			request.setAttribute("erreur", "La demande de modification a échoué.");
			e.printStackTrace();
		}
		listerCandidats(request, response);
	}
	
	/**
	 * Méthode en charge de 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void validerModificationCandidat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String nom =  request.getParameter("firstName");
			String prenom =  request.getParameter("lastName");
			String email =  request.getParameter("email");
			String login =  request.getParameter("login");
			String password =  request.getParameter("password");
			int idPromotion = Integer.parseInt(request.getParameter("idPromotion"));
			
			
			
			candidateService.modifier(nom, prenom, email, login, password, idPromotion);
			request.setAttribute("message", "La modification s'est déroulée avec succès.");
			
		} 
		catch (ParseException e1) {
			request.setAttribute("erreur", "veuillez vérifier vos saisies avant de valider de nouveau");
			e1.printStackTrace();
		}
		catch (Exception e) {
			request.setAttribute("erreur", "La modification a échoué.");
			e.printStackTrace();
		}
		listerCandidats(request, response);
	}

}
