/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.beans;

import java.io.Serializable;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class Answer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 937852511631584085L;
	
	private int id; 
	private int position ;
	private String answer ;
	private boolean correct ;
	/**
	 * Constructeur.
	 */
	public Answer() {
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
	 * Getter pour position.
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * Setter pour position.
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	/**
	 * Getter pour answer.
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * Setter pour answer.
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * Getter pour correct.
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}
	/**
	 * Setter pour correct.
	 * @param correct the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Answer [id=").append(id).append(", position=")
				.append(position).append(", answer=").append(answer)
				.append(", correct=").append(correct).append("]");
		return builder.toString();
	}
	
	

	
}
