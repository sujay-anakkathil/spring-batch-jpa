package com.test.spring.batch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Override
	public String toString() {
		return "Person [id=" + id + ", email=" + email + ", phone=" + phone + ", password=" + password + ", networkId="
				+ networkId + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	private String phone;
	private String password;
	@Column(name="network_id")
	private String networkId;
	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name="last_name")
	private String lastName;
	@Column(name="first_name")
	private String firstName;

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(final String networkId) {
		this.networkId = networkId;
	}

	public Person() {
	}

	public Person(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}


}
