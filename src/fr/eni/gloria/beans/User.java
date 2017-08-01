/**
 * @author lvanhove2017
 * @date 31 juil. 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lvanhove2017
 * @date 31 juil. 2017
 * @version GloriaProject V1.0
 */
public class User implements Serializable {

	/**
	 * numero de série de la classe
	 */
	private static final long serialVersionUID = 3604016087739802322L;
	
	/**
	 * Identifiant d'un utilisateur.
	 */
	private int id;
	/**
	 * Nom.
	 */
	private String firstName;
	/**
	 * Prénom.
	 */
	private String lastName;
	/**
	 * Mot de passe.
	 */
	private String password;
	/**
	 * Mot de passe.
	 */
	private String login;
	/**
	 * Getter pour login.
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 *Setter pour login
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Email.
	 */
	private String email;
	
	/**
	 * numéro de téléphone
	 */
	private String phone;
	/**
	 * date de naissance
	 */
	private Date birthdate;
	
	/**
	 * 
	 * Constructeur par défaut
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
	 *Setter pour id
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
	 *Setter pour firstName
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
	 *Setter pour lastName
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Getter pour password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *Setter pour password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Getter pour email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 *Setter pour email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Getter pour phone.
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 *Setter pour phone
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Getter pour birthdate.
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}
	/**
	 *Setter pour birthdate
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", login=");
		builder.append(login);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", birthdate=");
		builder.append(birthdate);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	

}