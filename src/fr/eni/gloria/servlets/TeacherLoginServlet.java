package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Teacher;
import fr.eni.gloria.services.TeacherService;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * Servlet implementation class TeacherLoginServlet
 */
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = GloriaLogger.getLogger(this.getClass().getName()); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/teacher/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.entering(this.getClass().getName(), "doPost");
		//Récupération des paramètres login et mot de passe
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		//Appel de la Service pour checker l'identification :
		Teacher user = null;
		user = new TeacherService().authenticate(login, password);

		if ( user != null) {

			session.setAttribute("user", user);
			session.setAttribute("profileType", "teacher");
			request.getRequestDispatcher("/Teacher").forward(request, response);
		}else{
			request.setAttribute("error", "Login et/ou mot de passe incorrect(s)");
			request.getRequestDispatcher("/WEB-INF/jsp/teacher/login.jsp").forward(request, response);
		}
	}
}
