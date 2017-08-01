package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestsServlet
 */
public class TestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestsServlet() {
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
		//Récupérer la liste des tests disponibles pour ce candidate
		
		//BOUCHON
		List<String> tests = new ArrayList<String>();
		tests.add(" test 1");
		tests.add(" test 2");
		
		//Affichage de la liste dans la jsp tests.jsp
		request.setAttribute("tests", tests);
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/tests.jsp").forward(request, response);
	}

}
