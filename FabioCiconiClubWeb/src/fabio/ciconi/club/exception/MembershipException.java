/**
 *  Author Fabio Alexandre Ciconi
 */
package fabio.ciconi.club.exception;

/**
 * @author ZeusAC
 *
 */
public class MembershipException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public MembershipException() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public MembershipException(String message) {
	super(message);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public MembershipException(Throwable cause) {
	super(cause);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public MembershipException(String message, Throwable cause) {
	super(message, cause);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public MembershipException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	// TODO Auto-generated constructor stub
    }

}
