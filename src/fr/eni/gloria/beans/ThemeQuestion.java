/**
 * @author Administrateur
 * @date 8 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.beans;

import java.io.Serializable;

 /**
 * @author Administrateur
 * @date 8 août 2017
 * @version GloriaProject V1.0
 */
public class ThemeQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7702853962669505171L;
	
	
	private int idTheme;
	private int idQuestion;
	
	
	
	/**
	 * Constructeur
	 */
	public ThemeQuestion() {
		super();
	}
	/**
	 * Getter pour idTheme.
	 * @return the idTheme
	 */
	public int getIdTheme() {
		return idTheme;
	}
	/**
	 *Setter pour idTheme
	 * @param idTheme the idTheme to set
	 */
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	/**
	 * Getter pour idQuestion.
	 * @return the idQuestion
	 */
	public int getIdQuestion() {
		return idQuestion;
	}
	/**
	 *Setter pour idQuestion
	 * @param idQuestion the idQuestion to set
	 */
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ThemeQuestion [idTheme=");
		builder.append(idTheme);
		builder.append(", idQuestion=");
		builder.append(idQuestion);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
