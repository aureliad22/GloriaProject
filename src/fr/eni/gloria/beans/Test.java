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
	private int successTreshold ;
	private int semiSuccessTreshold ;
	private int duration ;
	private Teacher creator ;
	private List<Section> sections ;
	private int result;
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
	public int getSuccessTreshold() {
		return successTreshold;
	}
	/**
	 * Setter pour successTreshold.
	 * @param successTreshold the successTreshold to set
	 */
	public void setSuccessTreshold(int successTreshold) {
		this.successTreshold = successTreshold;
	}
	/**
	 * Getter pour semiSuccessTreshold.
	 * @return the semiSuccessTreshold
	 */
	public int getSemiSuccessTreshold() {
		return semiSuccessTreshold;
	}
	/**
	 * Setter pour semiSuccessTreshold.
	 * @param semiSuccessTreshold the semiSuccessTreshold to set
	 */
	public void setSemiSuccessTreshold(int semiSuccessTreshold) {
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
	 * Getter pour sections.
	 * @return the sections
	 */
	public List<Section> getSections() {
		return sections;
	}
	/**
	 * Setter pour sections.
	 * @param sections the sections to set
	 */
	public void setSections(List<Section> sections) {
		this.sections = sections;
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
				.append(creator).append(", sections=").append(sections)
				.append("]");
		return builder.toString();
	}
	
	/**
	 * Getter pour result.
	 * @return the result
	 */
	public int getResult() {
		return result;
	}
	/**
	 * Setter pour result.
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}

}
