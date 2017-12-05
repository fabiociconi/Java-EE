package asgn4.startup.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asgn4.startup.dto.Course;
import asgn4.startup.dto.Login;
import asgn4.startup.exceptions.ImproperInputException;

import asgn4.startup.model.CourseCatalog;
import asgn4.startup.model.CourseManager;

/**
 * Servlet implementation class FabioCiconiLoginServlet
 * 
 * @author Fabio Alexandre Ciconi Assignment #3 - Java EE - Game Guess
 */

// -Servlet Declaration
@WebServlet(name = "RegisterLogin", description = "This is a servlet to Register Course", urlPatterns = {
	"/registerLogin" })

public class FabioCiconiLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Default Constructor
     * 
     * @see HttpServlet#HttpServlet()
     */
    public FabioCiconiLoginServlet() {
	super();

    }

    /**
     * doGet Method
     * 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher reqDisp = null;

	try {
	    
	    
	    //DEFINE HOUR LAST UPDATE//
	    Calendar cal = Calendar.getInstance();
	
	    DateFormat dateFormat = new SimpleDateFormat("EEE MMM d k:mm:ss z y G");
	    
	    String time = dateFormat.format(cal.getTime());

	    request.getServletContext().setAttribute("lastUpdated", time);
	    

	    //get user typed
	    String user = request.getParameter("username");

	    // login instance
	    Login userLogin = new Login();

	    // set user
	    userLogin.setUser(user);

	    // get session and set obj to "user"
	    request.getSession().setAttribute("user", userLogin);

	    // using singleton
	    CourseCatalog cm = CourseManager.getInstance();
	    
	    
	    //LIST ALL COURSES
	    Collection<Course> courses = ((CourseManager) cm).getAllCourses();
	    request.getSession().setAttribute("map", courses);
	    
	    //****
	    // show instance hash code -
	    System.out.println("Instace ID 0...: " + cm.hashCode());

	    // get session and set obj cm to "codeCourseAtr"
	    request.getSession().setAttribute("codeCourseAtr", cm);

	    // if it is correct, redirect to main page
	    reqDisp = request.getRequestDispatcher("/main.jsp");
	    reqDisp.forward(request, response);

	} catch (ImproperInputException e) {
	    // error handling: store message in request scope
	    request.setAttribute("exception", e.getMessage());
	    // stay in login page and print error message
	    reqDisp = request.getRequestDispatcher("/login.jsp");
	    reqDisp.forward(request, response);

	}
	return;
    }

}
