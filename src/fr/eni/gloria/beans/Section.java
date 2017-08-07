/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.beans;

import java.io.Serializable;
import java.util.List;

/**
 * @author lvanhove2017
 * @date 4 août 2017
 * @version GloriaProject V1.0
 */
public class Section implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5921483930386877071L;
	private int id;
	private String caption;
	private List<Question> questions ;
	/**
	 * Constructeur.
	 */
	public Section() {
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
	 * Getter pour libelle.
	 * @return the libelle
	 */
	public String getCaption() {
		return caption;
	}
	/**
	 * Setter pour libelle.
	 * @param libelle the libelle to set
	 */
	public void setCaption(String libelle) {
		this.caption = libelle;
	}
	/**
	 * Getter pour questions.
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}
	/**
	 * Setter pour questions.
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Section [id=").append(id).append(", libelle=")
				.append(caption).append("]");
		return builder.toString();
	}
	
	
}
