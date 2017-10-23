package asgn4.startup.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asgn4.startup.dto.Course;
import asgn4.startup.dto.Professor;
import asgn4.startup.exceptions.CourseNotFoundException;
import asgn4.startup.exceptions.ImproperInputException;
import asgn4.startup.model.CourseCatalog;


/**
 * Servlet implementation class FabioCiconiDeleteUpdateCourseServlet
 */
@WebServlet("/deleteUpdateCourse")
public class FabioCiconiDeleteUpdateCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FabioCiconiDeleteUpdateCourseServlet() {
	super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher rd = null;
	
	switch (request.getParameter("submit")) {
	
	    case "Back":
		rd = request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);
		break;
	    case "Reset":
		rd = request.getRequestDispatcher("/display.jsp");
		rd.forward(request, response);
		break;
		}
	return;

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher rd = null;

	// pega valores na memoria
	CourseCatalog cm = (CourseCatalog) request.getSession().getAttribute("codeCourseAtr");

	// new values
	String codeCourse = request.getParameter("codeCourse");
	String titleCourse = request.getParameter("CourseName");
	String firstName = request.getParameter("profFirstNameCourse");
	String middleName = request.getParameter("profMiddleNameCourse");
	String lastName = request.getParameter("profLastNameCourse");

	 Calendar cal = Calendar.getInstance();		
	 DateFormat dateFormat = new SimpleDateFormat("EEE MMM d k:mm:ss z y G");	
	
	// check option
	switch (request.getParameter("submit")) {
	case "Delete":
	    try {
		cm.deleteCourse(codeCourse);
		System.out.println("Course Deleted");
		 //DEFINE HOUR LAST UPDATE//		   	   
		    String time = dateFormat.format(cal.getTime());
		    request.getServletContext().setAttribute("lastUpdated", time);
		 //

	    } catch (CourseNotFoundException e) {
		request.setAttribute("exception", e.getMessage());

	    }finally {
		rd = request.getRequestDispatcher("/display.jsp");
		rd.forward(request, response);
	    }
	    
	    break;
	case "Update":
	    try {

		Course course = cm.getCourse(codeCourse);
		course.setCourseTitle(titleCourse);

		try {

		    course.setProfessor(new Professor(firstName, middleName, lastName));
		    //DEFINE HOUR LAST UPDATE//		   	   
		    String time = dateFormat.format(cal.getTime());
		    request.getServletContext().setAttribute("lastUpdated", time);
		    //	
		    

		} catch (ImproperInputException e) {
		    request.setAttribute("exception", e.getMessage());
		}

		course = cm.updateCourse(course);
		System.out.println("Course Updated");

	    } catch (CourseNotFoundException e) {
		request.setAttribute("exception", e.getMessage());
	
		break;
	   
		
	    }finally {
		rd = request.getRequestDispatcher("/display.jsp");
		rd.forward(request, response);
	    }
	    
	   
	}
	return;

    }

}
