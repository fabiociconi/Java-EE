package com.cc.hr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.cc.hr.exceptions.InvalidDataException;


// import org.apache.openjpa.persistence.jdbc.ForeignKey;

@Entity
@NamedQueries({@NamedQuery(name="getPhoneNumber", query = "SELECT p FROM PhoneNumber p"),
	@NamedQuery(name="getMaxPhoneid", query = "SELECT MAX(p.phoneid) FROM PhoneNumber p"),
	@NamedQuery(name="getPhoneNumberOrdered", query = "SELECT p FROM PhoneNumber p ORDER BY p.phoneid"),
	@NamedQuery(name="getPhoneNumberByLocalnum", query = "SELECT p FROM PhoneNumber p WHERE p.localnum = :localnum"),
	@NamedQuery(name="getPhoneNumberByPhonetype", query = "SELECT p FROM PhoneNumber p WHERE p.phoneType = :phonetype"),
	@NamedQuery(name="getPhoneNumberByEmployee", query = "SELECT p FROM PhoneNumber p WHERE p.employee.empcode = :empcode")})

	@Table(schema="HR")
public class PhoneNumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int phoneid;

	private String localnum;
	
	@Enumerated (EnumType.STRING)
	private PhoneType phoneType;

	@ManyToOne
	@JoinColumn(name="EMPCODE")
	private Employee employee;

	public PhoneNumber() {
		super();
	}

	public int getPhoneid() {
		return this.phoneid;
	}

	public void setPhoneid(int phoneid) {
		this.phoneid = phoneid;
	}

	public String getLocalnum() {
		return this.localnum;
	}

	public void setLocalnum(String localnum) throws InvalidDataException {
		if ( ! localnum.matches( "[0-9]{10}" ) ) {
			throw new InvalidDataException("Phone number but be 10 digits");
		}		
		this.localnum = localnum;
	}

	public PhoneType getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}
	
	public void setPhoneType( String type) {
		if ( type.equals("WORK")) {
			this.phoneType = PhoneType.WORK;
		} else if ( type.equals("HOME")) {
			this.phoneType = PhoneType.HOME;
		} else if (type.equals("MOBILE")) { 
			this.phoneType = PhoneType.MOBILE;
		} else {
			this.phoneType = PhoneType.OTHER;
		}
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
