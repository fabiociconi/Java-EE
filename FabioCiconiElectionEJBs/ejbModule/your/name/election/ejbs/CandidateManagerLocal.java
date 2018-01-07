package your.name.election.ejbs;

import java.util.List;

import javax.ejb.Local;

import your.name.entities.Candidate;

/**
 * @author ZeusAC
 *
 */
@Local
public interface CandidateManagerLocal {
    /**
     * @return
     */
    public List<Candidate> getCandidates();
}
