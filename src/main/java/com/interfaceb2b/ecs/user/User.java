package com.interfaceb2b.ecs.user;

public class User {
	private String username = "";
	private String passwordKey = "";
	private String salt = "";
	private String firstName = "";
	private String lastName = "";
	private String organization = "";

	public User() {

	}

	public User(String username, String key, String firstName) {

		this.username = username;
		this.passwordKey = key;
		this.firstName = firstName;

	}

	public User(String username, String key, String firstName, String lastName, String organization) {
		this.username = username;
		this.passwordKey = key;
		this.firstName = firstName;
		this.lastName = lastName;
		this.organization = organization;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordKey() {
		return passwordKey;
	}

	public void setPasswordKey(String key) {
		this.passwordKey = key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
