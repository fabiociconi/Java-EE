package com.cc.hr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.cc.hr.exceptions.InvalidDataException;

// import org.apache.openjpa.persistence.jdbc.ForeignKey;

@Entity
@NamedQueries({
	@NamedQuery(name="getEmail", query = "SELECT e FROM Email e"),
	@NamedQuery(name="getEmailByEmailAddress", query = "SELECT e FROM Email e WHERE e.emailAddress = :emailAddress")
})
@Table( schema="HR")
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String empcode;
	
	private String emailAddress;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;
	
	public Email() {
		super();
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) throws InvalidDataException{
		int findAt = emailAddress.indexOf('@');
		if ( findAt < 1 ) throw new InvalidDataException("Email address must contains an '@' character");
		String addressEnd = emailAddress.substring(findAt);
		int findDot = addressEnd.indexOf('.');
		if ( findDot < 1 ) throw new InvalidDataException("Email address must contains a '.' character after '@'"); 
		this.emailAddress = emailAddress;
	}
}
