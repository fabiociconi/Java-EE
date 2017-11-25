package your.name.clock.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import your.name.clock.model.LocalePicker;
import your.name.clock.model.SetLocaleException;

/**
 * Servlet implementation class LocaleServlet
 */
@WebServlet("/setLocale")
public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocaleServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// invalidate user session to clear history and other settings
		HttpSession session = request.getSession();
		session.invalidate();
		// start over at the welcome page
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/clockSolution.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get locale chosen by user
		String localeName = request.getParameter("locale");
		// test whether locale recognized 
		try {
			// test whether locale recognized 
			LocalePicker.getLocaleFor(localeName);
			// store locale name in request or session (either accepted)
			HttpSession session = request.getSession();
			session.setAttribute("localeName", localeName.trim() );
			// call doPost on ClockServlet
			request.getRequestDispatcher("clock").forward(request, response);
		} catch (SetLocaleException e) {
			// error handling: store message in request scope
			request.setAttribute("errMsg", e.getMessage() );
			// return user to welcome page 
			request.getRequestDispatcher("/clockSolution.jsp").forward(request, response);
		}
	}

}
