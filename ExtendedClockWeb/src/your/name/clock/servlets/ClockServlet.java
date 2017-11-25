package your.name.clock.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import your.name.clock.model.ClockBean;
import your.name.clock.model.DateTimeFormatException;
import your.name.clock.model.LocalePicker;
import your.name.clock.model.SetLocaleException;

/**
 * Servlet implementation class ClockServlets
 */
@WebServlet("/clock")
public class ClockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClockServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String responsePage = "clock.jsp";
		// get locale from session  - set by locale servlet
		try {
			HttpSession session = request.getSession();
			String locName = (String) session.getAttribute("localeName");
			Locale locale = LocalePicker.getLocaleFor(locName);
			request.setAttribute("localeName", locale.getDisplayName());
			ClockBean clock = new ClockBean();
			// when called from LocaleServlet, format is not provided
			String format = request.getParameter("format");
			if (format == null) {
				format = "full";
			}
			// Store the locale-sensitive time and format for display
			request.setAttribute("format", format);
			String time = clock.getCurrentTimeFormatted(format, locale);
			// Add the time to the call history
			List<String> history = (List<String>) session.getAttribute("CallHistory");
			if (history == null) {
				history = new ArrayList<String>();
			}
			history.add(time);
			session.setAttribute("CallHistory", history);
			request.setAttribute("currentTime", time);
		} catch (DateTimeFormatException | SetLocaleException e) {
			// error handling using a general purpose error page
			request.setAttribute("exception", e);
			responsePage = "/errorPage.jsp";
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(responsePage);
			rd.forward(request, response);
		}
	}


}