package lucky.star.menu.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lucky.star.menu.model.MenuItem;
import lucky.star.menu.model.MenuManager;
import sun.security.jca.GetInstance;

/**
 * Servlet implementation class MenuServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    	MenuManager mm = MenuManager.getInstance();
	    	
	    	//Collection<MenuItem> items = ((MenuManager) mm).getMenu();
		//request.getSession().setAttribute("map", items);
	    	request.getSession().setAttribute("map", mm.getMenu());
	    	
	    	RequestDispatcher rd = null;
		
		rd = request.getRequestDispatcher("/menu.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    getServletContext().setAttribute("lastNum", 12000);
	    //get user typed
	    String user = request.getParameter("username");
	    if(user == null||user.isEmpty())
	    {
		request.setAttribute("message","You must type a valid Name");
		doGet(request,response);
		return;		
	    }
	    //aumenta sempre um numero e grava no context
//	    int orderNum = 0;
//	    synchronized (this) {
//		orderNum = (int) getServletContext().getAttribute("lastnum");
//		orderNum++;
//		getServletContext().setAttribute("lastNum", orderNum);
//	    }
	 
	    //RequestDispatcher reqDisp = null;
	    HttpSession session = request.getSession();
	    
	    MenuManager mm = MenuManager.getInstance();	
	    //Collection<MenuItem> items = ((MenuManager) mm).getMenu();
	    request.getSession().setAttribute("map", mm.getMenu());	    
	    
	    session.setAttribute("orderId", user);
	    request.getRequestDispatcher("/orderform.jsp").forward(request, response);
	    return;
	}    

}
