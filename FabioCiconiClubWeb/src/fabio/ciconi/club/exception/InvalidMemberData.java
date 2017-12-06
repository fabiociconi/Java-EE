/**
 *  Author Fabio Alexandre Ciconi
 */
package fabio.ciconi.club.exception;

/**
 * @author ZeusAC
 *
 */
public class InvalidMemberData extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public InvalidMemberData() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public InvalidMemberData(String arg0) {
	super(arg0);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public InvalidMemberData(Throwable cause) {
	super(cause);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public InvalidMemberData(String message, Throwable cause) {
	super(message, cause);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public InvalidMemberData(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	// TODO Auto-generated constructor stub
    }

}
