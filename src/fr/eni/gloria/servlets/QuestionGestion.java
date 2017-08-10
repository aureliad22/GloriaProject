
package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
import fr.eni.gloria.beans.ThemeQuestion;
import fr.eni.gloria.services.AnswerService;
import fr.eni.gloria.services.PromotionService;
import fr.eni.gloria.services.QuestionService;
import fr.eni.gloria.services.ThemeQuestionService;
import fr.eni.gloria.services.ThemeService;
import fr.eni.gloria.utils.GloriaException;

/**
 * Servlet implementation class QuestionGestion
 */
public class QuestionGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionService qService = new QuestionService();
	ThemeQuestionService tqs = new ThemeQuestionService();
	AnswerService rService = new AnswerService();
       
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
				
		Question question = new Question();		
		ThemeQuestion tq = new ThemeQuestion();
		
		//HttpSession session = request.getSession();
		
		// Enumeration pour tester la récupération des paramètres de la jsp !!!!!
		
		Enumeration<String> chaines = request.getParameterNames();
		while(chaines.hasMoreElements()) {
			String paramName = chaines.nextElement();
			System.out.print("PAram: " + paramName + " : ");
			String[] values = request.getParameterValues(paramName);
			for(String val : values) {
				System.out.print(val + " , ");
			}
			System.out.println("");
		}
		
		String enonce = request.getParameter("enonce");
		int poids = Integer.parseInt(request.getParameter("poids"));	
		question.setQuestion(enonce);
		question.setWeight(poids);
			
		int idTheme = Integer.parseInt(request.getParameter("theme"));
		
		
		List<Answer> ListeRep = new ArrayList<Answer>();
		List<String> enonceReponses = null ;
		boolean[] checkbox = null;		
		String[] Reps = request.getParameterValues("textReponse");
		if(Reps != null) {
			for(int i = 0 ; i < Reps.length ; i++) {				
				Answer rep = new Answer();
				boolean isCorrecte = request.getParameterValues("correct_" + i) !=null;
				rep.setAnswer(Reps[i]);
				rep.setCorrect(isCorrecte);					
				ListeRep.add(rep);
				question.setAnswers(ListeRep);				
			}
		}
		try {
			qService.add(question);
			
			int idQuestion = question.getId();
			tq.setIdQuestion(idQuestion);
			tq.setIdTheme(idTheme);
			
				tqs.add(tq);
			
		} catch (GloriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//List<Answer> reponses = request.getParameter("reponsesObligatoires");
		//int nombreReponse = Integer.parseInt(request.getParameter("compteurReponse"));
		//List<Answer> reponses = (List<Answer>)session.getAttribute("reponsesObligatoires");
		/*String theme = request.getParameter("ReponseAdd");
		String theme = request.getParameter("checkBoxAdd");
		String theme = request.getParameter("theme");
		
		*/
		request.getRequestDispatcher("/WEB-INF/jsp/candidate/question.jsp").forward(request, response);
		
		
	}

}

