package asgn4.startup.model;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import asgn4.startup.dto.Course;
import asgn4.startup.exceptions.CourseNotFoundException;
import asgn4.startup.exceptions.DuplicateCourseException;

/**
 * @author ZeusAC
 *
 */
public class CourseManager implements CourseCatalog {

    private static CourseManager instance = null;
    private Map<String, Course> courses = null;
    private int courseQtd;

    private CourseManager() {
	courses = new ConcurrentHashMap<String, Course>();
    }

    /**
     * @return
     */
    public static CourseManager getInstance() {
	// no need to sync if instance created
	if (instance == null) {
	    // synchronize for first client or race condition
	    synchronized (CourseManager.class) {
		if (instance == null) {
		    instance = new CourseManager();
		}
	    }
	}
	return instance;
    }

    /**
     * @return
     */
    public Collection<Course> getAllCourses() {
	return courses.values();
    }

    /**
     * @return the courseQtd
     */
    public int getCourseQtd() {
	return courseQtd = courses.size();
    }


    @Override
    public Course getCourse(String courseCode) throws CourseNotFoundException {
	if (courseCode == null) {
	    throw new CourseNotFoundException("No course with null courseCode");
	}
	if (courses.containsKey(courseCode)) {
	    return courses.get(courseCode);
	} else {
	    throw new CourseNotFoundException("No course with code " + courseCode);
	}
    }

    @Override
    public Course addCourse(Course c) throws DuplicateCourseException {
	if (c == null) {
	    throw new DuplicateCourseException("Cannot add a null Course");
	}
	String code = c.getCourseCode();
	if (courses.containsKey(code)) {
	    throw new DuplicateCourseException("Duplicate course code " + code);
	}
	courses.put(code, c);
	return c;
    }

    @Override
    public Course updateCourse(Course c) throws CourseNotFoundException {
	if (c == null) {
	    throw new CourseNotFoundException("Cannot update a null Course");
	}
	Course oldC = getCourse(c.getCourseCode());
	if (c.equals(oldC)) {
	    // no change - nothing to do
	    return c;
	}
	// insert changed course
	courses.put(c.getCourseCode(), c);
	// retrieve again to get derived fields, if there are any
	return getCourse(c.getCourseCode());
    }

    @Override
    public Course deleteCourse(String courseCode) throws CourseNotFoundException {
	if (courseCode == null) {
	    throw new CourseNotFoundException("No course with null courseCode");
	}
	if (courses.containsKey(courseCode)) {
	    Course c = courses.get(courseCode);
	    courses.remove(courseCode);
	    return c;
	} else {
	    throw new CourseNotFoundException("No course with code " + courseCode);
	}
    }
}