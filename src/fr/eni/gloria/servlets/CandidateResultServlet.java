package fr.eni.gloria.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Answer;
import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Question;
import fr.eni.gloria.beans.Section;
import fr.eni.gloria.beans.Test;
import fr.eni.gloria.services.AnswerService;
import fr.eni.gloria.services.ResultService;
import fr.eni.gloria.services.SectionService;
import fr.eni.gloria.services.TestService;
import fr.eni.gloria.utils.GloriaException;

/**
 * Servlet implementation class CandidateResultServlet
 */
public class CandidateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandidateResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des parametres de session (stagiaire, test)
		HttpSession session = request.getSession();
		Test test = (Test) session.getAttribute("requestedTest");
		Candidate candidate = ((Candidate) session.getAttribute("user"));
		RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/jsp/candidate/testResult.jsp");		
		
		// 1. Calcul du total attendu pour le test courant:
		int totalTest = calculateTotalTest(request, candidate, test);
		// 2. Calcul du résultat obtenu par le candidat pour le test courant:
		int totalCandidat = calculateTotalCandidate(request, session, candidate, test);
		System.out.println(totalTest + " points attendus, " + totalCandidat + " points obtenus");
		
		// 3. Calcul du pourcentage de réussite:
		int score = (int)(totalCandidat*100/totalTest);
		session.setAttribute("score", score);
		
		// 4. Ajout du totalCandidat dans la base de données:
		try {
			ResultService.addResultCandidate(score, candidate, test);
		} catch (GloriaException e) {
			request.setAttribute("error", e.getMessage());
		}
		
		// 5. Comparaison du résultatCandidat avec les seuils définis pour le test (acquis, non acquis, en cours d'acquisition)
		String bilan = defineTresholds(test, score);
		session.setAttribute("bilan", bilan);

		rd.forward(request, response);
	}

	/**
	 * Méthode en charge de comparer le score obtenu par le candidat 
	 * avec les seuils définis pour le test donné en paramètre
	 * (non acquis, en cours d'acquisition, acquis)
	 * @param test
	 * @param score
	 * @return String énoncant le niveau obtenu
	 */
	private String defineTresholds(Test test, int score) {
		String bilan = null;
		if(score >= test.getSuccessTreshold()){
			bilan = "Acquis";
		} else if(score>= test.getSemiSuccessTreshold()){
			bilan = "En cours d'acquisition";
		} else {
			bilan = "Non acquis";
		}
		return bilan;
	}

	/**
	 * Méthode en charge de calculer le résultat total obtenu par un candidat
	 * à un test
	 * @param request
	 * @param session
	 * @param test
	 * @param stagiaire
	 * @return totalCandidate
	 */
	private int calculateTotalCandidate(HttpServletRequest request,	HttpSession session, Candidate candidate, Test test) {
		int totalCandidat = 0;
		List<Integer> rightQuestionsBySection = new ArrayList<Integer>();
		List<Integer> scoresBySection = new ArrayList<Integer>();
		List<Integer> gradiantsBySection = new ArrayList<Integer>();

			// 2.1. Parcours des sections
			for (Section section : test.getSections()) {	
				int totalSectionCandidat = 0;
				int compteurRightQuestion = 0;
				// 2.1.1. Parcours des questions
				for (Question question : section.getQuestions()) {
					boolean isRight = false;
					// 2.1.1.1. Vérification de la véracité de la réponse
					try {						
						isRight = verifyGoodAnswer(test, candidate, section, question); 
					} catch (GloriaException e) {
						request.setAttribute("error", e.getMessage());
					}
					// 2.1.1.2. Si la réponse est bonne: 
					// on ajoute au résultat total de la section le poids de la question
					// on incremente de 1 le compteur de bonnes reponses, 
					// on ajoute ce compteur à la liste de bonnes réponses par section
					if(isRight){
						totalSectionCandidat += question.getWeight();
						compteurRightQuestion++;
					}						
				}
				rightQuestionsBySection.add(compteurRightQuestion);
				System.out.println(compteurRightQuestion + " bonnes réponses dans cette section");
				System.out.println("total par section pour le candidat " +totalSectionCandidat);
	
				//2.1.3. Calcul du résultat attendu pour cette section.
				int totalSection = calculateTotalSection(request, candidate, test, section);
				System.out.println("total par section pour le test " +totalSection);
				
				//2.1.4. Calcul du score obtenu pour cette section.
				int scoreSection = (int)(totalSectionCandidat*100/totalSection);
				scoresBySection.add(scoreSection);
				int gradiant = ((scoreSection/10)+1)*10;
				gradiantsBySection.add(gradiant);
				System.out.println("score par section pour le test " +scoreSection);
				
				//2.1.5. Ajout du resultat section au résultat total
				totalCandidat += totalSectionCandidat; 
			}
		session.setAttribute("totalSection", rightQuestionsBySection);
		session.setAttribute("scoreSection", scoresBySection);
		session.setAttribute("gradient", gradiantsBySection);

		return totalCandidat;
	}

	/**
	 * Méthode en charge de vérifier que la/les réponse(s) fournie(s) par le candidat 
	 * pour une question est/sont correcte(s).
	 * @param test
	 * @param stagiaire
	 * @param section
	 * @param question
	 * @param isRight
	 * @return Vrai si la question a été correctement répondue.
	 * @throws GloriaException
	 */
	private boolean verifyGoodAnswer(Test test, Candidate candidate, Section section, Question question) throws GloriaException {
		boolean isRight = false;
		List<Answer> rightAnswers = AnswerService.getRightAnswers(question);
		List<Answer> givenAnswers = ResultService.getGivenAnswers(candidate, test, section, question);
// 1. Comparaison des listes de réponses attendues et obtenues
			if ((rightAnswers.size() == givenAnswers.size()) && givenAnswers.containsAll(rightAnswers)) {
// 2. Si les listes sont égales, alors on la réponse est correcte
					isRight = true;
			}
		return isRight;
	}
	
	/**
	 * Méthode en charge de retourner le total attendu pour le test donné en paramètre
	 * @param request
	 * @param test
	 * @param stagiaire
	 * @param totalTest
	 * @return
	 */
	private int calculateTotalTest(HttpServletRequest request, Candidate candidate, Test test) {
		int totalTest = 0;
		try {
			totalTest = TestService.getTotal(candidate, test);
		} catch (GloriaException ge) {
			request.setAttribute("error", ge.getMessage());
		}
		return totalTest;
	}

	/**
	 * Méthode en charge de retourner le total attendu pour la section donnée en paramètre
	 * @param request
	 * @param candidate
	 * @param test
	 * @param section
	 * @return totalSection
	 */
	private int calculateTotalSection(HttpServletRequest request, Candidate candidate, Test test, Section section) {
		int totalSection = 0;
		try {
			totalSection = SectionService.getTotalSection(candidate, test, section);
		} catch (GloriaException ge) {
			request.setAttribute("error", ge.getMessage());
		}
		return totalSection;
	}
}
