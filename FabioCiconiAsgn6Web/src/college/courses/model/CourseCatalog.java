package college.courses.model;

import college.courses.data.Course;
import college.courses.exceptions.CourseNotFoundException;
import college.courses.exceptions.DuplicateCourseException;
import college.courses.exceptions.ImproperInputException;

public interface CourseCatalog {
	
	public Course getCourse(String courseCode) throws CourseNotFoundException;

	public Course addCourse(Course c) throws DuplicateCourseException, ImproperInputException;

	public Course deleteCourse(String courseCode) throws CourseNotFoundException;
	
	public Course updateCourse(Course c) throws CourseNotFoundException, ImproperInputException;
}
