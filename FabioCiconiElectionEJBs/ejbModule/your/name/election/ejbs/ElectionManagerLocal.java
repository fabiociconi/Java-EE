package your.name.election.ejbs;

import java.io.PrintStream;

import javax.ejb.Local;

import your.name.entities.Candidate;
import your.name.entities.Voter;
import your.name.exceptions.DataInputException;
import your.name.execptions.ElectionException.ElectionException;

@Local
public interface ElectionManagerLocal {
    public Voter authenticateVoter(int voterId, String password) throws ElectionException;
    public void castBallot(Voter v, Candidate c) throws ElectionException, DataInputException;
    public void printVoteCount(PrintStream out) throws ElectionException;
}
