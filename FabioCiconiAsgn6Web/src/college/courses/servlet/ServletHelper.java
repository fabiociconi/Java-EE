package college.courses.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import college.courses.exceptions.ImproperInputException;
import college.courses.model.CourseManager;
import college.courses.model.ProfessorManager;
import fabio.ciconi.asgn6.entities.Course;
import fabio.ciconi.asgn6.entities.Professor;

public class ServletHelper {
	HttpServletRequest request;
	HttpServletResponse response;

	ServletHelper(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	void updateBanner() {
		ServletContext context = request.getServletContext();
		CourseManager cm = new CourseManager();
		List<String> courseCodes = cm.getCourseCodes();
		int courseCount = courseCodes.size();
		context.setAttribute("courseCodes", courseCodes);
		context.setAttribute("courseCount", courseCount);
		Date lastUpdated = Calendar.getInstance().getTime();
		context.setAttribute("lastUpdated", lastUpdated);
	}

	boolean checkLogin() throws IOException, ServletException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") == null) {
			session.invalidate();
			request.setAttribute("message", "You must login before working with courses");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		} else {
			return true;
		}
	}

	String checkCourse() throws IOException, ServletException {
		HttpSession session = request.getSession();
		String courseCode = (String) session.getAttribute("courseCode");
		if (courseCode == null) {
			request.setAttribute("message", "Please select a course to work with");
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return null;
		} else {
			return courseCode;
		}
	}

	Course getCourseData() throws ImproperInputException {
		// read course code and title
		Course course = null;
		String courseCode = (String) request.getSession().getAttribute("courseCode");
		if ( courseCode == null ) {
			courseCode = request.getParameter("courseCode");
			courseCode = courseCode.trim().toUpperCase();
		}
		String courseTitle = request.getParameter("courseTitle").trim();
		// store course code and title in request scope for error handling
		request.setAttribute("courseCode", courseCode);
		request.setAttribute("courseTitle", courseTitle);
		course = new Course( courseCode, courseTitle);
		// read professor
		String profIdS = request.getParameter("profId").trim();
		if (profIdS.equals("TBA")) {
			course.setProfessor(null);
		} else if (profIdS.equals("Add")) {
			String firstName = request.getParameter("profFirstName").trim();
			String middleName = request.getParameter("profMiddleName").trim();
			String lastName = request.getParameter("profLastName").trim();
			// store first, middle and last name in request scope for error handling
			request.setAttribute("profFirstName", firstName);
			request.setAttribute("profMiddleName", middleName);
			request.setAttribute("profLastName", lastName);
			Professor professor = new Professor(firstName, middleName, lastName);
			course.setProfessor(professor);
		} else {
			try {
			int profId = Integer.parseInt(profIdS);
			ProfessorManager pm = new ProfessorManager();
			course.setProfessor(pm.getProfessor(profId));
			} catch ( NumberFormatException e) {
				throw new ImproperInputException( "Existing professor not found in database");
			}
		}
		return course;
	}
}
