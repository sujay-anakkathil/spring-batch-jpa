package com.test.spring.batch.vo;

public class PersonVO {
	private String lastName;
	private String firstName;

	public PersonVO() {
	}

	public PersonVO(final String firstName, final String lastName) {
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

	@Override
	public String toString() {
		return "firstName: " + firstName + ", lastName: " + lastName;
	}
}
