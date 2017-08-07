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
	private boolean marked ;
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
	/**
	 * Getter pour marked.
	 * @return the marked
	 */
	public boolean isMarked() {
		return marked;
	}
	/**
	 * Setter pour marked.
	 * @param marked the marked to set
	 */
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [id=").append(id).append(", question=")
				.append(question).append(", imageURI=").append(imageURI)
				.append(", weight=").append(weight).append(", answers=")
				.append(answers).append("]");
		return builder.toString();
	}
	
	
	
}
