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
import college.courses.exceptions.InvalidCommandException;
import college.courses.model.CourseManager;
import college.courses.model.ProfessorManager;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
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
		// clear last course user worked on
		HttpSession session = request.getSession();
		session.setAttribute("courseCode", null);
		// GET a course or ADD a course - sets new course to work on
		String command = request.getParameter("submit");
		try {
			switch (command) {
			case "Get": {
				CourseManager cm = new CourseManager();
				String courseCode = request.getParameter("courseCode").trim();
				if (courseCode.isEmpty()) {
					throw new InvalidCommandException("code code cannot be empty");
				}
				courseCode = courseCode.toUpperCase();
				Course course = cm.getCourse(courseCode);
				session.setAttribute("courseCode", courseCode);
				request.setAttribute("course", course);
				//
				System.out.println(course);
				request.getRequestDispatcher("/displayCourse.jsp").forward(request, response);
				return;
			}
			case "Add": {
				session.setAttribute( "courseCode", null );
				ProfessorManager pm = new ProfessorManager();
				request.setAttribute("professors", pm.getProfessorList());
				request.getRequestDispatcher("/addCourse.jsp").forward(request, response);
				return;
			}
			default: {
				throw new InvalidCommandException("Unrecognized command:" + command);
			}
			}
		} catch (InvalidCommandException | CourseNotFoundException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return;
		}  catch (Exception e) {
			  e.printStackTrace();
			  request.setAttribute("message", e);
			  request.getRequestDispatcher("/error.jsp").forward(request, response);
			  return;
		}
	}

}
