package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Promotion;
import fr.eni.gloria.beans.Teacher;
import fr.eni.gloria.services.CandidateService;
import fr.eni.gloria.services.PromotionService;
import fr.eni.gloria.utils.GloriaException;

/**
 * Servlet implementation class CreateCandidatServlet
 */
public class CreateCandidatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidateService serv = new CandidateService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCandidatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Promotion> list = null;
		try {
			list = new PromotionService().getAll();
			request.setAttribute("list", list);
		} catch (GloriaException e) {
		
			request.setAttribute("error", e.getMessage());
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/teacher/createCandidat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			create(request,response);
		} catch (GloriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * En charge de 
	 * @param request
	 * @param response
	 * @throws IOException, GloriaException 
	 * @throws ServletException 
	 */
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, GloriaException {
		
		CandidateService serv = new CandidateService();		
		Promotion promo =new Promotion();
		Candidate c =new Candidate();
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String promotion_Lib = request.getParameter("promotion");
		HttpSession session = request.getSession(true);	
		
		
		c.setFirstName(nom);
		c.setLastName(prenom);
		c.setEmail(email);
		c.setLogin(login);
		c.setPassword(password);	
		
		
		
		//promo.setTitle(promotion_Lib);
		//c.setPromotion(promo);
		serv.add(c);
		session.setAttribute("candidate", c);
		request.getRequestDispatcher("/WEB-INF/jsp/teacher/createCandidat.jsp").forward(request, response);		
		
		
	}

}
