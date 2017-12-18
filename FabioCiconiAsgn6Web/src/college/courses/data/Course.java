package college.courses.data;

import java.io.Serializable;

import college.courses.exceptions.ImproperInputException;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	private String courseCode;
	// a course can have an empty or null title
	private String courseTitle;
	// next two fields could be omitted but included to just avoid nulls in database
	private int capacity = 0;
	private int enrolled = 0;
	protected Professor professor;

	public Course() throws ImproperInputException {
		setProfessor(null);
		setCourseTitle(null);
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) throws ImproperInputException {
		if (courseCode == null ) {
			throw new ImproperInputException("Course must have a course code");
		}
		courseCode.toUpperCase();
		if ( ! courseCode.matches("[A-Z]{3,4}[0-9]{3,4}" ) ) {
			throw new ImproperInputException(
				"Course code must be 3 or 4 letters followed by 3 or 4 digits" );
		}
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		// professor can be null when professor not assigned
		this.professor = professor;
	}

	public Course(String courseCode) throws ImproperInputException {
		super();
		setCourseCode(courseCode);
	}

	public Course(String courseCode, String courseTitle)
			throws ImproperInputException {
		this(courseCode);
		setCourseTitle(courseTitle);
	}

	public Course(String code, String title, Professor professor)
			throws ImproperInputException {
		this(code, title);
		this.professor = professor;
	}

	public String toString() {
		String output = getCourseCode() + ": [" + getCourseTitle() + "]";
		if (getProfessor() != null) {
			output += " Professor " + getProfessor();
		}
		return output;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
		result = prime * result + ((courseTitle == null) ? 0 : courseTitle.hashCode());
		result = prime * result + enrolled;
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
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
		Course other = (Course) obj;
		if (capacity != other.capacity)
			return false;
		if (courseCode == null) {
			if (other.courseCode != null)
				return false;
		} else if (!courseCode.equals(other.courseCode))
			return false;
		if (courseTitle == null) {
			if (other.courseTitle != null)
				return false;
		} else if (!courseTitle.equals(other.courseTitle))
			return false;
		if (enrolled != other.enrolled)
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}


	
}
