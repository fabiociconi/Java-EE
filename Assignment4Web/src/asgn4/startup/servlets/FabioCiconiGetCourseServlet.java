package asgn4.startup.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asgn4.startup.dto.Course;
import asgn4.startup.exceptions.CourseNotFoundException;
import asgn4.startup.model.CourseCatalog;


/**
 * Servlet implementation class FabioCiconiGetCourseServlet
 */
@WebServlet(name = "GetCourse", description = "Get course in the course class", urlPatterns = { "/getCourse" })

public class FabioCiconiGetCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FabioCiconiGetCourseServlet() {
	super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {


	RequestDispatcher reqDisp = null;
	
	// check which button the user chose
	switch (request.getParameter("submit")) {

	case "Add":
	    //go to add course page	   
	    reqDisp = request.getRequestDispatcher("/addCourse.jsp");
	    reqDisp.forward(request, response);
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

	RequestDispatcher reqDisp = null;


	CourseCatalog cm = (CourseCatalog) request.getSession().getAttribute("codeCourseAtr");

	// get course typed by the user
	String codeCourse = request.getParameter("getCourse");
	
	
	try {
	    // check if the course exists
	    Course c = cm.getCourse(codeCourse);
	    request.getSession().setAttribute("course", c);
	    reqDisp = request.getRequestDispatcher("/display.jsp");
	    reqDisp.forward(request, response);

	} catch (CourseNotFoundException e) {
	    // error handling: store message in request scope
	    request.setAttribute("exception", e.getMessage());
	    reqDisp = request.getRequestDispatcher("/main.jsp");
	    reqDisp.forward(request, response);

	}
		
	return;
    }

}
