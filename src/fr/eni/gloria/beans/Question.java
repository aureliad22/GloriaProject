/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.beans;

import java.io.Serializable;
import java.util.List;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4167260659065832755L;
	private int id;
	private String question;
	private String imageURI;
	private int weight ;
	private List<Answer> answers ;
	/**
	 * Constructeur.
	 */
	public Question() {
		super();
	}
	/**
	 * Getter pour id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter pour id.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter pour question.
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * Setter pour question.
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * Getter pour imageURI.
	 * @return the imageURI
	 */
	public String getImageURI() {
		return imageURI;
	}
	/**
	 * Setter pour imageURI.
	 * @param imageURI the imageURI to set
	 */
	public void setImageURI(String imageURI) {
		this.imageURI = imageURI;
	}
	/**
	 * Getter pour weight.
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * Setter pour weight.
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * Getter pour answers.
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}
	/**
	 * Setter pour answers.
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	
}
