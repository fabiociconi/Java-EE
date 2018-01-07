package your.name.election.ejbs;

import java.io.PrintStream;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import your.name.entities.Candidate;
import your.name.entities.Voter;
import your.name.exceptions.DataInputException;
import your.name.execptions.ElectionException.ElectionException;


/**
 * Session Bean implementation class ElectionManager
 */
@Stateless
public class ElectionManager implements ElectionManagerLocal {
    @PersistenceContext (name="FabioCiconiElectionEntities")
    private EntityManager em;
    
    @Resource
    private SessionContext context;
    
    public ElectionManager() {
	super();
    }

    // user login: returns a Voter if user authenticated or null otherwise

    public Voter authenticateVoter(int voterId, String password) throws ElectionException {
	//EntityManagerFactory emf = EMFSupplier.getInstance().getEMF();
	//EntityManager em = emf.createEntityManager();
	Voter voter = em.find(Voter.class, voterId);
	if (voter == null) {
	    return null;
	}
	if (!voter.getPassword().equals(password)) {
	    return null;
	}
	// you could argue the next condition belongs in login servlet
	if (voter.isVoted()) {
	    context.setRollbackOnly();
	    throw new ElectionException("Attempt to vote twice: " + voter);
	}
	return voter;
    }

    // user votes: set Voter.hasVoted to true and add 1 to count of votes for
    // candidate

    public void castBallot(Voter v, Candidate c) throws ElectionException, DataInputException {
	//EntityManagerFactory emf = EMFSupplier.getInstance().getEMF();
	//EntityManager em = emf.createEntityManager();
	Candidate candidate = em.find(Candidate.class, c.getCid());
	if (candidate == null) {
	    throw new ElectionException("Attempt to vote for unknown candidate");
	}
	Voter voter = em.find(Voter.class, v.getVid());
	if (voter == null) {
	    throw new ElectionException("Attempt to vote by unknown voter");
	}
	EntityTransaction et = em.getTransaction();
	et.begin();
	candidate.setVotes(candidate.getVotes() + 1);
	if (voter.isVoted()) {
	   // et.rollback();
	    context.setRollbackOnly();
	    throw new ElectionException("Attempt to vote twice: " + voter);
	   
	}
	voter.setHasVoted(true);
	em.merge(voter);
	em.merge(candidate);
	et.commit();
    }

    // for testing and debugging only: print current vote count for each candidate

    public void printVoteCount(PrintStream out) throws ElectionException {
	//EntityManagerFactory emf = EMFSupplier.getInstance().getEMF();
	//EntityManager em = emf.createEntityManager();
	out.print("Vote count so far: ");
	TypedQuery<Candidate> tq = em.createNamedQuery("Candidate.findAll", Candidate.class);
	List<Candidate> candidates = tq.getResultList();
	for (Candidate c : candidates) {
	    out.printf("[%-12s%4d] ", c.getName(), c.getVotes());
	}
	out.println();
    }
}
