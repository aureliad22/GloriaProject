package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

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
	 * {@inheritDoc}
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/jsp/teacher/home.jsp").forward(req, res);

	}
	
	

}
