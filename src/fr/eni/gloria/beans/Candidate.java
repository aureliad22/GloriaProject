/**
 * @author Administrateur
 * @date 31 juil. 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.beans;

 /**
 * @author Administrateur
 * @date 31 juil. 2017
 * @version GloriaProject V1.0
 */
public class Candidate extends User {

	/**
	 * numero de série de la classe
	 */
	private static final long serialVersionUID = -6180129165227284646L;
	
	private Promotion promotion;

	/**
	 * Getter pour promotion.
	 * @return the promotion
	 */
	public Promotion getPromotion() {
		return promotion;
	}

	/**
	 * Setter pour promotion.
	 * @param promotion the promotion to set
	 */
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
	

}