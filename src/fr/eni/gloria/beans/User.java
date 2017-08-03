/**
 * @author lvanhove2017
 * @date 31 juil. 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.beans;

import java.io.Serializable;

/**
 * @author lvanhove2017
 * @date 31 juil. 2017
 * @version GloriaProject V1.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = 3604016087739802322L;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String password;
	/**
	 * Constructeur.
	 */
	public User() {
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
	 * Getter pour firstName.
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Setter pour firstName.
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Getter pour lastName.
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Setter pour lastName.
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Getter pour email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter pour email.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Getter pour login.
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Setter pour login.
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Getter pour password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Setter pour password.
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Getter pour serialversionuid.
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", firstName=")
				.append(firstName).append(", lastName=").append(lastName)
				.append(", email=").append(email).append(", login=")
				.append(login).append(", password=").append(password)
				.append("]");
		return builder.toString();
	}
	
	

	
	
	
	

}