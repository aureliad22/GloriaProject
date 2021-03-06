/**
 * @author Administrateur
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.beans;

import java.io.Serializable;


 /**
 * @author Administrateur
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
public class Promotion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6474796814244571626L;
	private int id;
	private String title;
	
	
	/**
	 * Constructeur
	 */
	public Promotion() {
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
	 *Setter pour id
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter pour libelle.
	 * @return the libelle
	 */
	public String getTitle() {
		return title;
	}
	/**
	 *Setter pour libelle
	 * @param libelle the libelle to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Promotion [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}

