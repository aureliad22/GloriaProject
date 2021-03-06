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
public class Theme implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 791510171471760631L;
	
	private int id;
	private String libelle;
	
	
	/**
	 * Constructeur
	 */
	public Theme() {
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
	public String getLibelle() {
		return libelle;
	}
	/**
	 *Setter pour libelle
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Theme [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
