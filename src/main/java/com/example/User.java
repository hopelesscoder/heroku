package com.example;

/**
 * @author Daniele Pasquini
 *
 */
public class User {
	
	private int id;
    private String firstName;
    private String lastName;
	private String email;
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
