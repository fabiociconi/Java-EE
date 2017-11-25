package lucky.star.menu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lucky.star.menu.model.MenuManager;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/showmenu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		getServletContext().setAttribute("lastNum", 12000);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MenuManager mm = MenuManager.getInstance();
		request.setAttribute("menu", mm.getMenu());
		request.getRequestDispatcher("/menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		if (orderId == null || orderId.trim().isEmpty()) {
			request.setAttribute("message", "You must supply name to identify your order");
			doGet(request, response);
			return;
		}
		int orderNum = 0;
		synchronized (this) {
			orderNum = (int) getServletContext().getAttribute("lastNum");
			orderNum++;
			getServletContext().setAttribute("lastNum", orderNum);
		}
		HttpSession session = request.getSession();
		session.setAttribute("orderId", orderId + orderNum);
		MenuManager mm = MenuManager.getInstance();
		request.setAttribute("menu", mm.getMenu());
		request.getRequestDispatcher("/orderform.jsp").forward(request, response);
	}

}
