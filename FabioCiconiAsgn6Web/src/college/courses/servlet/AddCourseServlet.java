package college.courses.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import college.courses.data.Course;
import college.courses.exceptions.DuplicateCourseException;
import college.courses.exceptions.ImproperInputException;
import college.courses.model.CourseManager;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/add")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletHelper sh = new ServletHelper(request, response);
		if (!sh.checkLogin()) {
			return;
		}
		HttpSession session = request.getSession();
		try {
			Course course = sh.getCourseData();
			CourseManager cm = new CourseManager();
			cm.addCourse(course);
			session.setAttribute("courseCode", course.getCourseCode() );
			sh.updateBanner();
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return;
		} catch (ImproperInputException | DuplicateCourseException e) {
			e.printStackTrace(System.out);
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/updateCourse.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
	}
}
