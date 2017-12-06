package fabio.ciconi.club.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fabio.ciconi.club.exception.InvalidMemberData;
import fabio.ciconi.club.exception.MembershipException;
import fabio.ciconi.club.model.Member;
import fabio.ciconi.club.model.Membership;

/**
 * Servlet implementation class resgistrationLogin
 */
@WebServlet("/reg")
public class resgistrationLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public resgistrationLogin() {
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
	rd = request.getRequestDispatcher("/index.jsp");
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

	Membership mm = Membership.getInstance();

	// get user typed
	String user = request.getParameter("username");
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String password = request.getParameter("password");

	
	try {

	    if(user.isEmpty())
	    {
		throw new Exception("User is Required");
	    }
	    if(firstName.isEmpty())
	    {
		throw new Exception("First Name is Required");
	    }
	    if(firstName.isEmpty())
	    {
		throw new Exception("Last Name is Required");
	    }
	 
	    if(password.isEmpty())
	    {
		throw new Exception("Password is Required");
	    }
	    
	    mm.addMember(new Member(user, firstName, lastName, password));

	} catch (MembershipException e) {
	
	    request.setAttribute("exception", e.getMessage());
	    reqDisp = request.getRequestDispatcher("/membershipexception.jsp");
	    reqDisp.forward(request, response);
	    return;
	} catch (InvalidMemberData e) 
	{
	    request.setAttribute("exception", e.getMessage());
	    reqDisp = request.getRequestDispatcher("/Welcome.jsp");
	    reqDisp.forward(request, response);
	    return;
	}catch(Exception e)
	{
	    reqDisp = request.getRequestDispatcher("/Welcome.jsp");
	    request.setAttribute("exception", e.toString());
	    reqDisp.forward(request, response);
	    return;
	}

	request.getSession().setAttribute("user", user);
	reqDisp = request.getRequestDispatcher("/index.jsp");
	reqDisp.forward(request, response);
	return;
    }

}
