package college.courses.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import college.courses.data.Course;
import college.courses.exceptions.CourseNotFoundException;
import college.courses.exceptions.ImproperInputException;
import college.courses.model.CourseManager;
import college.courses.model.ProfessorManager;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletHelper sh = new ServletHelper(request, response);
		if (!sh.checkLogin()) {
			return;
		}
		String courseCode = sh.checkCourse();
		if (courseCode == null) {
			return;
		}
		try {
			CourseManager cm = new CourseManager();
			Course course = cm.getCourse(courseCode);
			request.setAttribute("courseCode", courseCode);
			request.setAttribute("courseTitle", course.getCourseTitle() );
			request.setAttribute("professor", course.getProfessor() );
			ProfessorManager pm = new ProfessorManager();
			request.setAttribute("professors", pm.getProfessorList());
			request.getRequestDispatcher("/updateCourse.jsp").forward(request, response);
			return;
		} catch (CourseNotFoundException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletHelper sh = new ServletHelper(request, response);
		if (!sh.checkLogin()) {
			return;
		}
		String courseCode = sh.checkCourse();
		if (courseCode == null) {
			return;
		}
		String command = request.getParameter("submit");
		if (command.equals("Cancel")) {
			session.setAttribute("courseCode", null);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return;
		}
		try {
			CourseManager cm = new CourseManager();
			Course c = sh.getCourseData();
			c = cm.updateCourse(c);
			request.setAttribute("course", c);
			sh.updateBanner();
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return;
		} catch (CourseNotFoundException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		} catch (ImproperInputException e) {
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
