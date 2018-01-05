package your.name.election.model;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

public class EMFSupplier {

    private static EMFSupplier emfSupplier = null;
    private EntityManagerFactory emf = null;
    private String EMFJndiName = "java:/ElectionEMF";

    private EMFSupplier() {
	if (emf == null) {
	    try {
		InitialContext ctx = new InitialContext();
		emf = (EntityManagerFactory) ctx.lookup(EMFJndiName);
	    } catch (NamingException ne) {
		System.out.println("Please correct persistence unit: check persistence.xml");
		ne.printStackTrace();
	    }
	}
    }

    public static EMFSupplier getInstance() {
	if (emfSupplier == null) {
	    emfSupplier = new EMFSupplier();
	}
	return emfSupplier;
    }

    public EntityManagerFactory getEMF() {
	return emf;
    }
}
