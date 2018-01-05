package your.name.election.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import your.name.entities.Candidate;
import your.name.exceptions.CandidateException;

public class CandidateManager {

    public CandidateManager() {
	super();
    }

    // First four methods are not implemented because they not required in this
    // exercise.
    // However they would be implemented in a more generic bean used in other
    // situations.

    public Candidate getCandidate(String CandidateCode) throws CandidateException {
	return null;
    }

    public Candidate addCandidate(Candidate candidate) throws CandidateException {
	return null;
    }

    public Candidate deleteCandidate(String CandidateCode) throws CandidateException {
	return null;
    }

    public Candidate updateCandidate(Candidate Candidate) throws CandidateException {
	return null;
    }

    // returns candidate information used to generate buttons on the ballot form

    public List<Candidate> getCandidates() {
	EntityManagerFactory emf = EMFSupplier.getInstance().getEMF();
	EntityManager em = emf.createEntityManager();
	TypedQuery<Candidate> tq = em.createNamedQuery("Candidate.findAll", Candidate.class);
	List<Candidate> candidates = tq.getResultList();
	return candidates;
    }
}
