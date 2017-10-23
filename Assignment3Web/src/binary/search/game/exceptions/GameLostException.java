/**
 *  Author Fabio Alexandre Ciconi
 */
package binary.search.game.exceptions;

/**
 * @author Fabio Alexandre Ciconi
 *
 */
public class GameLostException extends Exception {

  
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public GameLostException() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public GameLostException(String arg0) {
	super(arg0);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public GameLostException(Throwable cause) {
	super(cause);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public GameLostException(String message, Throwable cause) {
	super(message, cause);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public GameLostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	// TODO Auto-generated constructor stub
    }

}
