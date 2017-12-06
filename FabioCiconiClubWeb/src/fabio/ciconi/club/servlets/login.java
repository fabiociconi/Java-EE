package fabio.ciconi.club.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fabio.ciconi.club.model.Membership;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher rd = null;
	rd = request.getRequestDispatcher("/Welcome.jsp");
	rd.forward(request, response);
	return;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher reqDisp = null;

	// get user typed
	String user = request.getParameter("userName");
	String password = request.getParameter("password");
	// login instance
	Membership mm = Membership.getInstance();

	// set user

	
	try {
	    boolean ret = mm.authenticate(user, password);
	    
	if (ret == false) {
		throw new Exception("Not user Registred");	
		 
	    }
	    
	} catch (Exception e) {
	    
	    reqDisp = request.getRequestDispatcher("/index.jsp");
	    request.setAttribute("Message", e.toString());
	    reqDisp.forward(request, response);
	    return;
	}
    
	

	// get session and set obj to "user"
	request.getSession().setAttribute("user", user);

	// LIST ALL members
	List<String> members = ((Membership) mm).getMemberNames();

	request.getSession().setAttribute("men", members);

	// if it is correct, redirect to main page
	reqDisp = request.getRequestDispatcher("/clubwebsite.jsp");
	reqDisp.forward(request, response);

    }

}
