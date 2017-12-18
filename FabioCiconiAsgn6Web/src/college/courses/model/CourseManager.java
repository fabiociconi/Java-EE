package college.courses.model;

import java.util.List;
import college.courses.data.Course;
import college.courses.exceptions.CourseNotFoundException;
import college.courses.exceptions.DuplicateCourseException;
import college.courses.exceptions.ImproperInputException;

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

	public List<String> getCourseCodes() {
		return null;
	}

}
