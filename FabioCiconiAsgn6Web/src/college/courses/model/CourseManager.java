package college.courses.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import college.courses.exceptions.CourseNotFoundException;
import college.courses.exceptions.DuplicateCourseException;
import college.courses.exceptions.ImproperInputException;
import fabio.ciconi.asgn6.entities.Course;

public class CourseManager implements CourseCatalog {

    public CourseManager() {
	super();
    }

    @Override
    public Course getCourse(String courseCode) throws CourseNotFoundException {
	return null;
    }

    @Override
    public Course addCourse(Course c) throws DuplicateCourseException, ImproperInputException {
	if (c == null) {
	    throw new DuplicateCourseException("Cannot add a null Course");
	}
	return null;
    }

    @Override
    public Course deleteCourse(String courseCode) throws CourseNotFoundException {

	return null;
    }

    @Override
    public Course updateCourse(Course c) throws CourseNotFoundException, ImproperInputException {
	Course course = getCourse(c.getCourseCode());
	// if c is identical to stored course, do no work
	if (c.equals(course)) {
	    return c;
	}
	return course;
    }

    /**
     * @return
     */
    public List<String> getCourseCodes() {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("FabioCiconiAsgn6Entities");
	
	EntityManager em = emf.createEntityManager();
	TypedQuery<Course> query = em.createNamedQuery("getCourseCodes", Course.class);
	
	
	List<Course> results = query.getResultList();

	List<String> rr = new ArrayList<>();
	
	for (Course item : results) {
	
	    rr.add(item.getCourseCode());
	}
	
	return rr;
    }

}
