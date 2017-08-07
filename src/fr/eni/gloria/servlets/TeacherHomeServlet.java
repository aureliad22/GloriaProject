package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.invoke.empty.Empty;
import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Teacher;
import fr.eni.gloria.services.TeacherService;
import fr.eni.gloria.utils.GloriaLogger;


/**
 * Servlet implementation class TeacherAuthServlet
 */
public class TeacherHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("je suis au doGet de la servlet");
		request.getRequestDispatcher("/WEB-INF/jsp/teacher/TeacherAccess.jsp").forward(request, response);
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération des paramètres login et mot de passe
				TeacherService ts=new TeacherService();
				
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				HttpSession session = request.getSession(true);
				
				Teacher t=ts.authenticate(login, password);
				
				if (t !=null) {
					session.setAttribute("user", t);
					request.getRequestDispatcher("/WEB-INF/jsp/teacher/home.jsp").forward(request, response);
					System.out.println("je suis à la servlet");
				}else {
					System.out.println("login erroné");
					request.setAttribute("error", "Login et/ou mot de passe incorrect(s)");
					request.getRequestDispatcher("/WEB-INF/jsp/teacher/TeacherAccess.jsp").forward(request, response);
					System.out.println("je suis au else de la servlet");
				}
	}
	
	

}
