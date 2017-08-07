package fr.eni.gloria.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Question;
import fr.eni.gloria.beans.Test;

/**
 * Servlet implementation class CandidateRunTestServlet
 */
public class CandidateRunTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateRunTestServlet() {
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
		HttpSession session = request.getSession();
		Test currentTest = (Test)session.getAttribute("requestedTest"); 
		System.out.println(currentTest);
		RequestDispatcher rd = null ;
		System.out.println(session.getAttribute("testBegun"));
		//1.Si test non commencé : /Premiere question
		if (session.getAttribute("testBegun")==null) {
			System.out.println("Entrée dans 1.");
			//Initialisation des variables d'itération : 
			session.setAttribute("testBegun", true);
			session.setAttribute("currentSectionIndex", 0);
			session.setAttribute("currentQuestionIndex", 0);
			session.setAttribute("currentTestDone", false);
			
			//Récupération de la première question du test
			Question nextQuestion = currentTest.getSections().get(0).getQuestions().get(0);
			request.setAttribute("nextQuestion", nextQuestion);
			rd = request.getRequestDispatcher("/WEB-INF/jsp/candidate/runTest.jsp");
			
			
		//2. Si le test est déja commencé mais non terminé :	
		}else if (!(boolean)session.getAttribute("currentTestDone")){
			System.out.println("Entrée dans 2. Test en cours de passage");
			
			//Enregistrement de la réponse dans la base de données : 
			System.out.println("Sauvegarde de la réponse donnée");
			
			//Récupération des variables : 
			int currentQuestionIndex = (int) session.getAttribute("currentQuestionIndex");
			int currentSectionIndex = (int) session.getAttribute("currentSectionIndex");
			int questionMaxIndex = currentTest.getSections().get(currentSectionIndex).getQuestions().size()-1 ;
			int sectionMaxIndex = currentTest.getSections().size()-1;
			
			//2.1 Si on arrive à la fin de la liste de question de la section courante :
			if (currentQuestionIndex == questionMaxIndex){
				System.out.println("Entrée dans 2.1 Dernière question de la section courante");
				
				// 2.1.1 si la section courante est la dernière section du test courant mais que le candidat n'a pas cloturé le test :
				if (currentSectionIndex == sectionMaxIndex) {
					System.out.println("Entrée dans 2.1.1 : Fin de la derniere section du test.");
					rd=request.getRequestDispatcher("/WEB-INF/jsp/candidate/recapTest.jsp");
				
				//2.1.2. Passage à la section suivante. 
				}else{
					System.out.println("Entrée dans 2.1.2 : Changement de section / Affichage première question");
					currentSectionIndex++;
					currentQuestionIndex = 0 ;
					
					session.setAttribute("currentSectionIndex",currentSectionIndex);
					session.setAttribute("currentQuestionIndex", currentQuestionIndex);
					Question nextQuestion = currentTest.getSections().get(currentSectionIndex).getQuestions().get(currentQuestionIndex);
					session.setAttribute("nextQuestion", nextQuestion);
					rd = request.getRequestDispatcher("/WEB-INF/jsp/candidate/runTest.jsp");
					System.out.println("Section [index="+currentSectionIndex +", idSection="+currentTest.getSections().get(currentSectionIndex).getId() +"] | Question [index="+currentQuestionIndex+", idQuestion="+currentTest.getSections().get(currentSectionIndex).getQuestions().get(currentQuestionIndex).getId()+"]");
					
				}
			//2.2 Passage à la prochaine question de la section courante	
			}else{
				System.out.println("Entrée dans 2.2 : Affichage de la question suivante de la même section");
				//Incrément de l'index de question
				session.setAttribute("currentQuestionIndex", ++currentQuestionIndex);
				Question nextQuestion = currentTest.getSections().get(currentSectionIndex).getQuestions().get(currentQuestionIndex);
				request.setAttribute("nextQuestion", nextQuestion);
				rd = request.getRequestDispatcher("/WEB-INF/jsp/candidate/runTest.jsp");
				System.out.println("Section [index="+currentSectionIndex +", idSection="+currentTest.getSections().get(currentSectionIndex).getId() +"] | Question [index="+currentQuestionIndex+", idQuestion="+currentTest.getSections().get(currentSectionIndex).getQuestions().get(currentQuestionIndex).getId()+"]");
			}
		//3. Si le test est terminé et cloturé : 	
		}else{
			System.out.println("Entrée dans 3.");
			rd=request.getRequestDispatcher("/WEB-INF/jsp/candidate/testResult.jsp");
		}
		
		//Display next question
		System.out.println("Sortie. \n\n");
		rd.forward(request, response);
	}
	
	

}
