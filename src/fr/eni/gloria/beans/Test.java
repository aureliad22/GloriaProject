/**
 * @author lvanhove2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.beans;

import java.io.Serializable;
import java.util.List;

/**
 * @author lvanhove2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
public class Test implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6269583789622750276L;
	private int id ;
	private String title; 
	private String successTreshold ;
	private String semiSuccessTreshold ;
	private int duration ;
	private Teacher creator ;
	private List<Question> questions ;
	/**
	 * Constructeur.
	 */
	public Test() {
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
	 * Getter pour title.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Setter pour title.
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Getter pour successTreshold.
	 * @return the successTreshold
	 */
	public String getSuccessTreshold() {
		return successTreshold;
	}
	/**
	 * Setter pour successTreshold.
	 * @param successTreshold the successTreshold to set
	 */
	public void setSuccessTreshold(String successTreshold) {
		this.successTreshold = successTreshold;
	}
	/**
	 * Getter pour semiSuccessTreshold.
	 * @return the semiSuccessTreshold
	 */
	public String getSemiSuccessTreshold() {
		return semiSuccessTreshold;
	}
	/**
	 * Setter pour semiSuccessTreshold.
	 * @param semiSuccessTreshold the semiSuccessTreshold to set
	 */
	public void setSemiSuccessTreshold(String semiSuccessTreshold) {
		this.semiSuccessTreshold = semiSuccessTreshold;
	}
	/**
	 * Getter pour duration.
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * Setter pour duration.
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * Getter pour creator.
	 * @return the creator
	 */
	public Teacher getCreator() {
		return creator;
	}
	/**
	 * Setter pour creator.
	 * @param creator the creator to set
	 */
	public void setCreator(Teacher creator) {
		this.creator = creator;
	}
	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Test [id=").append(id).append(", title=").append(title)
				.append(", successTreshold=").append(successTreshold)
				.append(", semiSuccessTreshold=").append(semiSuccessTreshold)
				.append(", duration=").append(duration).append(", creator=")
				.append(creator).append("]");
		return builder.toString();
	}
	
	
}
