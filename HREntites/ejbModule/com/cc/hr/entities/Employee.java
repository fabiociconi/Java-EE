package com.cc.hr.entities;

import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="getEmployees", query = "SELECT e FROM Employee e"),
	@NamedQuery(name="getMaxEmployeeid", query = "select max(e.empcode) from Employee e"),
	@NamedQuery(name="getEmployeesOrdered", query = "SELECT e FROM Employee e ORDER BY e.empcode"),
	@NamedQuery(name="getEmployeesByJobTitle", query = "SELECT e FROM Employee e WHERE e.jobTitle = :jobTitle"),
	@NamedQuery(name="getEmployeesByGivenName", query = "SELECT e FROM Employee e WHERE e.name.givenName = :givenName"),
	@NamedQuery(name="getEmployeesByFamilyName", query = "SELECT e FROM Employee e WHERE e.name.familyName = :familyName"),
	@NamedQuery(name="getEmployeesByCommonName", query = "SELECT e FROM Employee e WHERE e.name.commonName = :commonName"),
	@NamedQuery(name="getEmployeesByDeptartment", query = "SELECT e FROM Employee e WHERE e.department.deptCode = :deptCode")})

	@Table(schema="HR", name="EMPLOYEE")
	public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String empcode;

	private String jobTitle;

    @Embedded
	private PersonsName name;

	public PersonsName getName() {
		return name;
	}

	public void setName(PersonsName name) {
		this.name = name;
	}

	@ManyToOne
 	@JoinColumn(name="DEPTCODE")
	private Department department;

	@OneToOne(mappedBy="employee")
	private Email email;

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email=email;
	}

	@OneToMany(mappedBy="employee", fetch = EAGER, cascade = CascadeType.ALL)
	private Set<PhoneNumber> phoneNumbers;

	
	public Employee() {
		super();
	}

	public String getEmpcode() {
		return this.empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
}
