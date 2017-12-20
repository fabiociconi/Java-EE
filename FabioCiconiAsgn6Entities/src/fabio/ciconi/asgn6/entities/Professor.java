package fabio.ciconi.asgn6.entities;

import java.io.Serializable;
import java.lang.Object;
import java.util.Set;

import javax.persistence.*;

import college.courses.exceptions.ImproperInputException;

/**
 * Entity implementation class for Entity: Professor
 *
 */
@Entity
@Table(name="professor", schema="college")

public class Professor extends Object implements Serializable {

    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="PROFID")
    private int profId;
    @Column(name="GIVENNAME")
    private String firstName;
    @Column(name="MIDDLENAME")
    private String middleName;
    @Column(name="FAMILYNAME")
    private String lastName;
    //@Embedded
    @OneToMany(mappedBy="professor")
    private Set<Course> courses;

    /**
     * 
     */
    public Professor() {
	super();
    }

    /**
     * @param firstName
     * @param lastName
     * @throws ImproperInputException
     */
    public Professor(String firstName, String lastName) throws ImproperInputException {
	setFirstName(firstName);
	setLastName(lastName);
    }

    /**
     * @param firstName
     * @param middleName
     * @param lastName
     * @throws ImproperInputException
     */
    public Professor(String firstName, String middleName, String lastName) throws ImproperInputException {
	setFirstName(firstName);
	setMiddleName(middleName);
	setLastName(lastName);
    }

    /**
     * @return
     */
    public int getProfId() {
	return profId;
    }

    /**
     * @param profId
     */
    public void setProfessorID(int profId) {
	this.profId = profId;
    }

    /**
     * @return
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * @param firstName
     * @throws ImproperInputException
     */
    public void setFirstName(String firstName) throws ImproperInputException {
	if (firstName == null || firstName.isEmpty()) {
	    throw new ImproperInputException("Proressor must have a first name");
	}
	this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getMiddleName() {
	return middleName;
    }

    /**
     * @param middleName
     */
    public void setMiddleName(String middleName) {
	if (middleName == null || middleName.isEmpty()) {
	    middleName = null;
	}
	this.middleName = middleName;
    }

    /**
     * @return
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * @param lastName
     * @throws ImproperInputException
     */
    public void setLastName(String lastName) throws ImproperInputException {
	if (lastName == null || lastName.isEmpty()) {
	    throw new ImproperInputException("Proressor must have a last name");
	}
	this.lastName = lastName;
    }

    /**
     * @return
     */
    public String getFullName() {
	String name = getFirstName();
	if (middleName != null) {
	    name += " " + getMiddleName();
	}
	name += " " + getLastName();
	return name;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	// omit field courses so avoid problems of lazy fetch
	// result = prime * result + ((courses == null) ? 0 : courses.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
	result = prime * result + profId;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Professor other = (Professor) obj;
	// omit field courses so avoid problems of lazy fetch
	// if (courses == null) {
	// if (other.courses != null)
	// return false;
	// } else if (!courses.equals(other.courses))
	// return false;
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
	if (profId != other.profId)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	// omit field courses so avoid problems of lazy fetch
	return "Professor [profId=" + profId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
		+ lastName + "]";
    }

}
