package asgn4.startup.model;

import asgn4.startup.dto.Course;
import asgn4.startup.exceptions.CourseNotFoundException;
import asgn4.startup.exceptions.DuplicateCourseException;

public interface CourseCatalog {

    public Course getCourse(String courseCode) throws CourseNotFoundException;

    public Course addCourse(Course c) throws DuplicateCourseException;

    public Course deleteCourse(String courseCode) throws CourseNotFoundException;

    public Course updateCourse(Course c) throws CourseNotFoundException;


}
