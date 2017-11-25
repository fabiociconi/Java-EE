package asgn4.startup.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asgn4.startup.dto.Course;
import asgn4.startup.dto.Professor;
import asgn4.startup.exceptions.DuplicateCourseException;
import asgn4.startup.exceptions.ImproperInputException;
import asgn4.startup.model.CourseCatalog;



/**
 * Servlet implementation class FabioCiconiAddCourseServlet
 */
@WebServlet(
	name = "AddCourse", 
	description = "add course", 
	urlPatterns = { "/addCourse" })

public class FabioCiconiAddCourseServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FabioCiconiAddCourseServlet() {
	super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher rd = null;
	
	rd = request.getRequestDispatcher("/main.jsp");
	rd.forward(request, response);
	return;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher reqDisp = null;

	CourseCatalog cm = (CourseCatalog) request.getSession().getAttribute("codeCourseAtr");

	
	String codeCourse 		= request.getParameter("codeCourse");
	String nameCourse 		= request.getParameter("nameCourse");
	String profFirstNameCourse 	= request.getParameter("profFirstNameCourse");
	String profMiddleNameCourse 	= request.getParameter("profMiddleNameCourse");
	String profLastNameCourse 	= request.getParameter("profLastNameCourse");

	try {
	    Professor professor = new Professor(profFirstNameCourse, profMiddleNameCourse, profLastNameCourse);
	    
	    cm.addCourse(new Course(codeCourse, nameCourse, professor));
	    System.out.println("Course Added");
	    
	    //DEFINE HOUR LAST UPDATE//
	    Calendar cal = Calendar.getInstance();	
	    DateFormat dateFormat = new SimpleDateFormat("EEE MMM d k:mm:ss z y G");	    
	    String time = dateFormat.format(cal.getTime());
	    request.getServletContext().setAttribute("lastUpdated", time);
	    //
	    //getServletContext().setAttribute("lastUpdated", time);
	    
	    reqDisp = request.getRequestDispatcher("/main.jsp");
	    reqDisp.forward(request, response);
	    
	} catch (ImproperInputException e) {
	    // error handling: store message in request scope
	    request.setAttribute("exception", e.getMessage());
	    reqDisp = request.getRequestDispatcher("/addCourse.jsp");
	    reqDisp.forward(request, response);
	} catch (DuplicateCourseException e) {
	    request.setAttribute("exception", e.getMessage());
	    reqDisp = request.getRequestDispatcher("/addCourse.jsp");
	    reqDisp.forward(request, response);
	}

	
	return;
    }

}
