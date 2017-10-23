package asgn4.startup.dto;

import asgn4.startup.exceptions.ImproperInputException;

public class Professor {

    private String firstName = null;
    private String middleName = null;
    private String lastName = null;

    public Professor(String firstName, String lastName) throws ImproperInputException {
	setFirstName(firstName);
	setLastName(lastName);
    }

    public Professor(String firstName, String middleName, String lastName) throws ImproperInputException {
	setFirstName(firstName);
	setMiddleName(middleName);
	setLastName(lastName);
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) throws ImproperInputException {
	if (firstName == null || firstName.isEmpty()) {
	    throw new ImproperInputException("Proressor must have a first name");
	}
	this.firstName = firstName;
    }

    public String getmiddleName() {
	return middleName;
    }

    public void setMiddleName(String middleName) throws ImproperInputException {
	// middle name can be null or empty String
	this.middleName = middleName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) throws ImproperInputException {
	if (lastName == null || lastName.isEmpty()) {
	    throw new ImproperInputException("Proressor must have a last name");
	}
	this.lastName = lastName;
    }

    public String toString() {
	String name = firstName + " ";
	if (middleName != null) {
	    name += middleName + " ";
	}
	return name + lastName;
    }

    // hashCode() method generated by Eclipse IDE tool
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
	return result;
    }

    // equlas() method generated by Eclipse IDE tool
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Professor other = (Professor) obj;
	if (firstName == null) {
	    if (other.firstName != null)
		return false;
	} else if (!firstName.equals(other.firstName))
	    return false;
	if (lastName == null) {
	    if (other.lastName != null)
		return false;
	} else if (!lastName.equals(other.lastName))
	    return false;
	if (middleName == null) {
	    if (other.middleName != null)
		return false;
	} else if (!middleName.equals(other.middleName))
	    return false;
	return true;
    }

}
