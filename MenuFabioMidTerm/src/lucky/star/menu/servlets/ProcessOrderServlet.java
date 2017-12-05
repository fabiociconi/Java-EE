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
 * Servlet implementation class ProcessOrderServlet
 */
@WebServlet("/process")
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	    
	    
	    MenuManager mm = MenuManager.getInstance();
	    
	    Order order = new Order();
	    List<MenuItem> list= mm.getMenu();
	    for (MenuItem menuItem : list) {
		
		int number = menuItem.getItemNo();
		
		//aqui passa o valor numerico parasteing para pegar na list do JSP
		String sitemNo = "" + number;		
		request.getParameter(sitemNo);
		
		int quant = Integer.parseInt(request.getParameter(sitemNo));
		if(quant>0) {
		    menuItem.setQuantity(quant);
		    order.addItem(menuItem);
		}
	    }
	    
	    request.getSession().setAttribute("order", order.getOrderedItems());
	    request.getRequestDispatcher("showorder.jsp").forward(request, response);
	}

}
