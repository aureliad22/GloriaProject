package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Test;
import fr.eni.gloria.dao.PromotionDAO;
import fr.eni.gloria.services.CandidateService;
import fr.eni.gloria.services.TestService;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * Servlet ayant pour but de fournir les options de CRUD standard pour les
 * objets Candidate. Cette fonctionnalité est reservée aux formateurs.
 */
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	private CandidateService candidateService = new CandidateService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandidateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		try {
			listCandidates(request, response);
		} catch (GloriaException e) {
			request.setAttribute("error", e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		if (request.getParameter("supprimer") != null) {
			try {
				supprimerCandidat(request, response);
			} catch (GloriaException e) {
				request.setAttribute("error", e.getMessage());
			}
		} else if (request.getParameter("inscrire") != null) {

			int idcandidat = Integer.parseInt(request.getParameter("candidat"));
			// Candidate candidat = (Candidate)request.getParameter("candidat");

			Candidate c = new Candidate();
			CandidateService cs = new CandidateService();
			TestService ts = new TestService();
			List<Test> listeTest = new ArrayList<Test>();
			try {

				c = cs.getById(idcandidat);
				listeTest = ts.getTestByIdCandidate(c.getId());

			} catch (GloriaException e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());

			}

			session.setAttribute("candidat", c);
			request.setAttribute("listeTestsInscrits", listeTest);

			request.getRequestDispatcher("/Teacher/CandidateInscription")
					.forward(request, response);

		}

		else if (request.getParameter("modifier") != null) {
			try {
				afficherModificationCandidat(request, response);
			} catch (GloriaException e) {
				request.setAttribute("error", e.getMessage());
			}
		} else if (request.getParameter("validerModification") != null) {
			try {
				validerModificationCandidat(request, response);
			} catch (GloriaException e) {
				request.setAttribute("error", e.getMessage());
			}
		}
	}

	/**
	 * Méthode en charge de
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws GloriaException
	 */

	private void listCandidates(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			GloriaException {
		List<Candidate> liste;
		List<Candidate> listeFiltree = null;
		liste = candidateService.getAll();
		String motClePourFiltre = request.getParameter("filtrerListeCandidat");

		if (liste != null) {
			/* if (motClePourFiltre == null) { */

			request.setAttribute("listeCandidats", liste);
			RequestDispatcher rd = request
					.getRequestDispatcher("/WEB-INF/jsp/teacher/gestionCandidat.jsp");
			rd.forward(request, response);

		} else {

			request.setAttribute("erreur",
					"Les candidats sont inaccessibles pour le moment");

		}
	}

	/**
	 * Méthode en charge de
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws GloriaException
	 */
	private void supprimerCandidat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			GloriaException {

		try {
			int identifiant = Integer.parseInt(request.getParameter("id"));
			Candidate candidate = new CandidateService().getById(identifiant);
			this.candidateService.remove(candidate);
			request.setAttribute("message",
					"La suppression s'est déroulée avec succès.");
		} catch (Exception e) {
			request.setAttribute("erreur", "La suppression a échoué.");
			e.printStackTrace();
		}

		// Rappel de la méthode affichant la liste pour actualisation.
		this.listCandidates(request, response);

	}

	/**
	 * Méthode en charge de
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws GloriaException
	 */
	private void afficherModificationCandidat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			GloriaException {
		int identifiant = Integer.parseInt(request.getParameter("id"));
		try {
			Candidate candidatAModifier = this.candidateService
					.getById(identifiant);
			request.setAttribute("candidatAModifier", candidatAModifier);
		} catch (Exception e) {
			request.setAttribute("erreur",
					"La demande de modification a échoué.");
			e.printStackTrace();
		}

		this.listCandidates(request, response);
	}

	/**
	 * Méthode en charge de
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws GloriaException
	 */
	private void validerModificationCandidat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			GloriaException {
		try {
			Candidate candidate = new Candidate();
			candidate.setFirstName(request.getParameter("firstName"));
			candidate.setLastName(request.getParameter("lastName"));
			candidate.setEmail(request.getParameter("email"));
			candidate.setLogin(request.getParameter("login"));
			candidate.setPassword(request.getParameter("password"));
			candidate.setPromotion(new PromotionDAO().selectById(Integer
					.parseInt(request.getParameter("idPromotion"))));
			this.candidateService.modify(candidate);
			request.setAttribute("message",
					"La modification s'est déroulée avec succès.");
		} catch (Exception e) {
			request.setAttribute("erreur","La demande de modification a échoué.");
			e.printStackTrace();
		}

		this.listCandidates(request, response);
	}

}
