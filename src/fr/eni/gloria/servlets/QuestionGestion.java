
package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.beans.Promotion;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.beans.Theme;
import fr.eni.gloria.services.PromotionService;
import fr.eni.gloria.services.QuestionService;
import fr.eni.gloria.services.ThemeService;
import fr.eni.gloria.utils.GloriaException;

/**
 * Servlet implementation class QuestionGestion
 */
public class QuestionGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionService qService = new QuestionService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionGestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("/WEB-INF/jsp/candidate/question.jsp");
		
		listThemes(request, response);
		
	}

	/**
	 * En charge de 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listThemes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Theme> listThemes = null;
		try {
			listThemes = new ThemeService().getAll();
			request.setAttribute("listThemes", listThemes);
						
		} catch (GloriaException e) {
		
			request.setAttribute("error", e.getMessage());
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/question.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listThemes(request, response);
		
		System.out.println("je suis dans le post de Question Gestion");
		
		Question question = new Question();
		Theme themeLink = new Theme();
		
		//HttpSession session = request.getSession();
			
		String enonce = request.getParameter("enonce");
		int poids = Integer.parseInt(request.getParameter("poids"));		
		String theme = request.getParameter("theme");
		String reponses = request.getParameter("reponses");
		System.out.println(reponses);
		
		/*for (Answer element : ) {
			
		}*/
		//List<Answer> reponses = request.getParameter("reponsesObligatoires");
		int nombreReponse = Integer.parseInt(request.getParameter("compteurReponse"));	
		
		//List<Answer> reponses = (List<Answer>)session.getAttribute("reponsesObligatoires");
		/*String theme = request.getParameter("ReponseAdd");
		String theme = request.getParameter("checkBoxAdd");
		String theme = request.getParameter("theme");
		
		question.setQuestion(enonce);
		question.setWeight(poids);
		themeLink.setLibelle(theme);
		
		
		qService.add(question);*/
		System.out.println(nombreReponse);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/question.jsp").forward(request, response);
		
		
	}

}

