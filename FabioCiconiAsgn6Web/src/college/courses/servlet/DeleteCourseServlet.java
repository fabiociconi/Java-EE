package college.courses.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import college.courses.exceptions.CourseNotFoundException;
import college.courses.model.CourseManager;

/**
 * Servlet implementation class DeleteCourseServlet
 */
@WebServlet("/delete")
public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCourseServlet() {
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
		String courseCode = sh.checkCourse();
		if ( courseCode == null ) {
			return;
		}
		CourseManager cm = new CourseManager();
		try {
			cm.deleteCourse(courseCode);
			sh.updateBanner();
			request.getSession().setAttribute("courseCode", null);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return;
		} catch (CourseNotFoundException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
	}
}
