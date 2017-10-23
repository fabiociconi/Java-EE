/**
 *  Author Fabio Alexandre Ciconi
 */
package asgn4.startup.dto;

import asgn4.startup.exceptions.ImproperInputException;

/**
 * @author ZeusAC
 *
 */
public class Login {

    private String user;

    /**
     * 
     */
    public Login() {
	super();
    }

    /**
     * @return the user
     */
    public String getUser() {
	return user;
    }

    /**
     * @param user
     * @throws ImproperInputException
     */
    public void setUser(String user) throws ImproperInputException {
	if (user.equals("")) {

	    throw new ImproperInputException("You must insert an user!!!!");

	} else {
	    System.out.println("user " + user);

	    this.user = user;
	}

    }

}
