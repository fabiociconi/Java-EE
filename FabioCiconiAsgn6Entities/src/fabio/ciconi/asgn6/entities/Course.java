package fabio.ciconi.asgn6.entities;

import java.io.Serializable;
import java.lang.Object;
import javax.persistence.*;

import college.courses.exceptions.ImproperInputException;

/**
 * Entity implementation class for Entity: Course
 *
 */

@Entity
@Table(name="course", schema="college")
@NamedQueries({
	@NamedQuery(name="getCourseCodes", query = "SELECT d FROM Course d")})



public class Course extends Object implements Serializable {

   
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @Column(name="COURSECODE")
    private String courseCode;
    // a course can have an empty or null title
    @Column(name="COURSETITLE")
    private String courseTitle;
    // next two fields could be omitted but included to just avoid nulls in database
    
    
    @Column(name="CAPACITY")
    private int capacity = 0;
    @Column(name="ENROLLED")
    private int enrolled = 0;
    
    @ManyToOne
    @JoinColumn(name="PROFID")
    protected Professor professor;

    /**
     * @throws ImproperInputException
     */
    public Course() throws ImproperInputException {
	setProfessor(null);
	setCourseTitle(null);
    }

    /**
     * @return
     */
    public String getCourseCode() {
	return courseCode;
    }

    /**
     * @param courseCode
     * @throws ImproperInputException
     */
    public void setCourseCode(String courseCode) throws ImproperInputException {
	if (courseCode == null) {
	    throw new ImproperInputException("Course must have a course code");
	}
	courseCode.toUpperCase();
	if (!courseCode.matches("[A-Z]{3,4}[0-9]{3,4}")) {
	    throw new ImproperInputException("Course code must be 3 or 4 letters followed by 3 or 4 digits");
	}
	this.courseCode = courseCode;
    }

    /**
     * @return
     */
    public String getCourseTitle() {
	return courseTitle;
    }

    /**
     * @param courseTitle
     */
    public void setCourseTitle(String courseTitle) {
	this.courseTitle = courseTitle;
    }

    /**
     * @return
     */
    public Professor getProfessor() {
	return professor;
    }

    /**
     * @param professor
     */
    public void setProfessor(Professor professor) {
	// professor can be null when professor not assigned
	this.professor = professor;
    }

    /**
     * @param courseCode
     * @throws ImproperInputException
     */
    public Course(String courseCode) throws ImproperInputException {
	super();
	setCourseCode(courseCode);
    }

    /**
     * @param courseCode
     * @param courseTitle
     * @throws ImproperInputException
     */
    public Course(String courseCode, String courseTitle) throws ImproperInputException {
	this(courseCode);
	setCourseTitle(courseTitle);
    }

    /**
     * @param code
     * @param title
     * @param professor
     * @throws ImproperInputException
     */
    public Course(String code, String title, Professor professor) throws ImproperInputException {
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
