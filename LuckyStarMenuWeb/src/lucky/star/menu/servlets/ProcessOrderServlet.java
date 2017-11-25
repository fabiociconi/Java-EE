package lucky.star.menu.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lucky.star.menu.model.MenuItem;
import lucky.star.menu.model.MenuManager;
import lucky.star.menu.model.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/processorder")
public class ProcessOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MenuManager mm = MenuManager.getInstance();
		Order order = new Order();
		List<MenuItem> mis = mm.getMenu();
		for ( MenuItem mi : mis) {
			int itemNo = mi.getItemNo();
			String sitemNo = "" + itemNo;
			request.getParameter( sitemNo);
			int quantity = Integer.parseInt(request.getParameter(sitemNo));
			if ( quantity > 0) {
				mi.setQuantity(quantity);
				order.addItem(mi);
			}
		}
		if ( order.getOrderedItems().size() < 1) {
			request.setAttribute("message", "Your order is empty");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("order", order.getOrderedItems());
		request.getRequestDispatcher("showorder.jsp")
				.forward(request, response);
	}
}
