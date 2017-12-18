package college.courses.data;

import java.io.Serializable;
import java.util.Set;

import college.courses.data.Course;
import college.courses.data.Professor;
import college.courses.exceptions.ImproperInputException;

public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;

	private int profId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Set<Course> courses;

	public Professor() {
		super();
	}

	public Professor(String firstName, String lastName) throws ImproperInputException {
		setFirstName(firstName);
		setLastName(lastName);
	}

	public Professor(String firstName, String middleName, String lastName) throws ImproperInputException {
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
	}

	public int getProfId() {
		return profId;
	}

	public void setProfessorID(int profId) {
		this.profId = profId;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		if (middleName == null || middleName.isEmpty()) {
			middleName = null;
		}
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
