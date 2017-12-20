package com.cc.hr.entities;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.cc.hr.exceptions.InvalidDataException;


@Entity
@NamedQueries({
	@NamedQuery(name="getDepartments", query = "SELECT d FROM Department d"),
	@NamedQuery(name="getDepartmentsOrdered", query = "SELECT d FROM Department d ORDER BY d.deptCode"),
	@NamedQuery(name="getDepartmentByDeptName", query = "SELECT d FROM Department d WHERE d.deptName = :deptName")})
	
@Table(schema="HR", name = "DEPARTMENT")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String deptCode;

	private String deptName;

	@OneToMany(mappedBy="department", fetch = LAZY)
	private Set<Employee> employees;

	public Department() {
		super();
	}
	
	public Department(String deptCode, String deptName) throws InvalidDataException {
		super();
		if (deptCode == null || deptName == null) {
			throw new InvalidDataException("Cannot create deparment with out 4-character code and name");
		} 
		if (deptCode.length() != 4 || deptName.length() < 1){
			throw new InvalidDataException("Cannot create deparment with out 4-character code and name");
		} 
		this.deptCode = deptCode;
		this.deptName = deptName;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getDeptCode() {
		return deptCode;
	}


	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String toString() {
		return deptCode + ": " + deptName;
	}
   
}
