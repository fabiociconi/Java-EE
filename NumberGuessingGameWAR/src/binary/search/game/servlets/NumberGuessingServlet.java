package binary.search.game.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import binary.search.game.exceptions.GameLostException;
import binary.search.game.model.NumberGuesser;

/**
 * Servlet implementation class NumberGuessingServlet
 */
@WebServlet("/GuessingGame")
public class NumberGuessingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberGuessingServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	NumberGuesser ng = new NumberGuesser();

	RequestDispatcher rd = null;
	try {
	    ng.firstGuess();
	    rd = request.getRequestDispatcher("nextGuess.jsp");
	} catch (Exception e) {
	    e.printStackTrace(System.out);
	    request.setAttribute("Exception", e);
	    rd = request.getRequestDispatcher("badGuess.jsp");
	} finally {
	    request.getSession().setAttribute("Guesser", ng);
	    rd.forward(request, response);
	}
	return;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher rd = null;

	NumberGuesser ng = (NumberGuesser) request.getSession().getAttribute("Guesser");

	String result = request.getParameter("submit");
	try {
	    if (result != null && result.equals("too low")) {
		ng.guessHigher();
		rd = request.getRequestDispatcher("nextGuess.jsp");
	    } else if (result != null && result.equals("too high")) {
		ng.guessLower();
		rd = request.getRequestDispatcher("nextGuess.jsp");
	    } else if (result != null && result.equals("correct")) {
		rd = request.getRequestDispatcher("goodGuess.jsp");
	    } else {
		throw new GameLostException("Other user response than: high | too loww | correct");
	    }

	} catch (Exception e) {
	    request.setAttribute("exception", e);
	    e.printStackTrace(System.out);
	    rd = request.getRequestDispatcher("badGuess.jsp");
	} finally {
	    request.setAttribute("Guesser", ng);
	    rd.forward(request, response);
	}
	return;
    }

}
