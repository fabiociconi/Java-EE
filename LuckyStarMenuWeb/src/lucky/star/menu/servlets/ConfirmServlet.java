package lucky.star.menu.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/confirmorder")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String getOrderTime() {
    	Calendar cal = Calendar.getInstance();
    	long time = cal.getTimeInMillis() + 1200000; // 20 minutes = 1200000 ms;
    	DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG);
    	return df.format(new Date(time));
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String message = "thank you";
		String orderId = (String) session.getAttribute("orderId");
		if (orderId == null ) {
			message = "ERROR: No order identifier. Did you confirm or cancel already?";
		} else if (session.getAttribute("order") == null ) {
			message = "ERROR: You have no order to confirm";
		} else if (request.getParameter("confirm").equals("CONFIRM") ) {
			message = "Order " + orderId + " will be ready within 20 minutes, by " + getOrderTime();
		} else if (request.getParameter("confirm").equals("CANCEL") ) {
			message = "Order " + orderId + " Cancelled.";
		}
		session.setAttribute("orderId",  null);
		session.invalidate();
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
}
