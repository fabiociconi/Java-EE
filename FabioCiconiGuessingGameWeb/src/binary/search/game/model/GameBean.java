/**
 *  Author Fabio Alexandre Ciconi
 */
package binary.search.game.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import binary.search.game.exception.GameLostException;

/**
 * @author ZeusAC
 *
 */

@Named(value = "gameBean")
@SessionScoped
public class GameBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String player;
    private String nextPage;
    private NumberGuesser ng = null;
    private int guess;
    private int count;
    private int bet;
    private int owing;

    /**
     * @throws GameLostException
     */
    public void start() throws GameLostException {
	ng = new NumberGuesser();
	nextPage = "guessPage.xhtml";
	guess = ng.firstGuess();
	count = ng.getGuessCount();

    }

    private void gameLost() {
	setNextPage("errorPage.xhtml");
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	FacesMessage facesMessage = new FacesMessage("Did you change your number mid-game … ? ");
	FacesContext.getCurrentInstance().addMessage("GameLost", facesMessage);
	owing = 0;
    }

    /**
     * 
     */
    public void done() {
	setNextPage("index.xhtml");
	// guess = 0 ;
	// count = 0 ;
	bet = 0;
	owing = 0;

    }

    /**
     * 
     */
    public void tooHigh() {
	try {
	    // ng.guessLower();
	    guess = ng.guessLower();
	    count = ng.getGuessCount();
	} catch (GameLostException e) {
	    gameLost();
	}
    }

    /**
     * 
     */
    public void tooLow() {
	try {
	    // ng.guessHigher();
	    guess = ng.guessHigher();
	    count = ng.getGuessCount();
	} catch (GameLostException e) {
	    gameLost();
	}
    }

    /**
     * 
     */
    public void correct() {
	setNextPage("gameover.xhtml");

    }

    /**
     * @return the player
     */
    public String getPlayer() {
	return player;
    }

    /**
     * @param player
     *            the player to set
     */
    public void setPlayer(String player) {
	this.player = player;
    }

    /**
     * @return the bet
     */
    public int getBet() {
	return bet;
    }

    /**
     * @param bet
     *            the bet to set
     */
    public void setBet(int bet) {
	owing = bet + owing;
	this.bet = bet;

    }

    /**
     * @return the nextPage
     */
    public String getNextPage() {
	return nextPage;
    }

    /**
     * @param nextPage
     *            the nextPage to set
     */
    public void setNextPage(String nextPage) {
	this.nextPage = nextPage;
    }

    /**
     * @return the guess
     */
    public int getGuess() {
	return guess;
    }

    /**
     * @param guess
     *            the guess to set
     */
    public void setGuess(int guess) {
	this.guess = guess;
    }

    /**
     * @return the count
     */
    public int getCount() {
	return count;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setCount(int count) {
	this.count = count;
    }

    /**
     * @return the ng
     */
    public NumberGuesser getNg() {
	return ng;
    }

    /**
     * @param ng
     *            the ng to set
     */
    public void setNg(NumberGuesser ng) {
	this.ng = ng;
    }

    /**
     * @return the owing
     */
    public int getOwing() {
	return owing;
    }

    /**
     * @param owing
     *            the owing to set
     */
    public void setOwing(int owing) {
	this.owing = owing;
    }

}
