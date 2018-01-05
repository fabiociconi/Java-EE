package your.name.election.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import your.name.entities.Candidate;
import your.name.execptions.CandidateException.CandidateException;


/**
 * Session Bean implementation class CandidateManager
 */
@Stateless
public class CandidateManager implements CandidateManagerLocal {
    @PersistenceContext (name="ElectionDS")
    private EntityManager em;
    public CandidateManager() {
  	super();
      }

 

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
 
  	TypedQuery<Candidate> tq = em.createNamedQuery("Candidate.findAll", Candidate.class);
  	List<Candidate> candidates = tq.getResultList();
  	return candidates;
      }

}
