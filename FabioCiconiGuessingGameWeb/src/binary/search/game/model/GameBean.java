/**
 *  Author Fabio Alexandre Ciconi
 */
package binary.search.game.model;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import binary.search.game.exception.ExcessGuessesException;
import binary.search.game.exception.GameLostException;
/**
 * @author ZeusAC
 *
 */
@Named(value = "gameBean")
@SessionScoped
public class GameBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private NumberGuesser ng = null;

    public void start() throws GameLostException {
	ng = new NumberGuesser();
	String nextPage = "guessPage";
	try {
	    int guess = ng.firstGuess();
	    int count = ng.getGuessCount();
	} catch (ExcessGuessesException e) {
	    gameLost();
	}
    }
   private void gameLost() {
	setNextPage("errorPage");
	FacesContext.getCurrentInstance().getExternalContext().
	invalidateSession();
	FacesMessage facesMessage = new FacesMessage(
	"Did you change your number mid-game … ? ");
	FacesContext.getCurrentInstance().addMessage("GameLost",
	facesMessage);
	}
}
