package com.cc.hr.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PersonsName implements Serializable{

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getNameTitle() {
		return nameTitle;
	}

	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}

	private static final long serialVersionUID = 1L;
	
	private String givenName;

	private String familyName;

	private String commonName;
	 
	// For unknown reasons, the enum type CourtesyTitle does not work here
	// So nameTitle is just an orindary string.
	//@Enumerated (EnumType.STRING)
	private String nameTitle;
	
	public String toString( ) {
			return commonName;
	}
}
