package fabio.ciconi.asgn3.servlets;

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
 * Servlet implementation class FabioCiconiGuessingServlet
 * @author Fabio Alexandre Ciconi
 * Assignment #3 - Java EE - Game Guess
 */

//-Servlet Declaretion
@WebServlet(
        name = "GuessNumberServelt",
        description = "This is a servlet to Guess Number Game",
        urlPatterns = "/guessnumber" )
	//@WebServlet("/guessnumber")


public class FabioCiconiGuessingServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    /**
     * Default Constructor
     * @see HttpServlet#HttpServlet()
     */
    public FabioCiconiGuessingServlet() {
	super();

    }

    /**
     * doGet Method
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	//instance of NumberGuesser
	NumberGuesser guessInst = new NumberGuesser();
	
	//Request Dispatcher declaration
	RequestDispatcher reqDisp=request.getRequestDispatcher("/GuessNumber.jsp");


	try {
	    //call first Guess that will be 500 
	    guessInst.firstGuess();
	    
	    //take the session and set attribute to the obj
	    request.getSession().setAttribute("guessNumber", guessInst);	    
	    reqDisp.forward(request, response);	  

	} catch (GameLostException e) {

	    // error handling: store message in request scope
	    request.setAttribute("exception", e.getMessage());	
	    
	    // return user to welcome page	
	    reqDisp =request.getRequestDispatcher("/Index.jsp");
	    reqDisp.forward(request, response);
	}
	return;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	
	//Initialization of Request Dispatcher
	RequestDispatcher reqDisp= null;

	//take the attributes in the session
	NumberGuesser guessInst = (NumberGuesser)request.getSession().getAttribute("guessNumber");

	try {

	    //check which button the user chose
	    switch (request.getParameter("getAnswer")) {

	    case "Correct":
		//finish the game
		reqDisp=request.getRequestDispatcher("/GameOver.jsp");
		reqDisp.forward(request, response);
		break;

	    case "Too High":
		//call a method to take lower number
		guessInst.guessLower();
		reqDisp = request.getRequestDispatcher("/GuessNumber.jsp");
		request.getSession().setAttribute("guessNumber", guessInst);	    
		reqDisp.forward(request, response);	  
		break;

	    case "Too Low":
		//call a method to take higher number 
		guessInst.guessHigher();
		reqDisp =request.getRequestDispatcher("/GuessNumber.jsp");
		request.getSession().setAttribute("guessNumber", guessInst);	    
		reqDisp.forward(request, response);
		break;
	    }

	} catch (GameLostException e) {

	
	    
	    // error handling: store message in request scope
	    request.setAttribute("exception", e.toString());	  
	    
	    // go to Exception screen
	    reqDisp =request.getRequestDispatcher("/GameException.jsp");
	    reqDisp.forward(request, response);
	}	
	return;
    }
}
