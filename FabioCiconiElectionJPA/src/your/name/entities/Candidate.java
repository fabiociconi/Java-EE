package your.name.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import your.name.exceptions.DataInputException;

/**
 * The persistent class for the candidate database table.
 * 
 */
@Entity
@Table(name = "CANDIDATE", schema = "ELECTION")
@NamedQueries({ @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c"),
	@NamedQuery(name = "getCandidateByName", query = "SELECT c from Candidate c where c.name = :candidateName") })
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String cid;
    @Embedded
    private PersonsName name;
    @Column(name = "CVOTES")
    private int votes;

    public Candidate() {
	super();
    }

    public Candidate(String firstName, String lastName, int votes) throws DataInputException {
	PersonsName name = new PersonsName(firstName, lastName);
	setName(name);
	setVotes(votes);
    }

    public String getCid() {
	return this.cid;
    }

    public void setCid(String cid) {
	this.cid = cid;
    }

    public PersonsName getName() {
	return name;
    }

    public void setName(PersonsName name) {
	this.name = name;
    }

    public int getVotes() {
	return this.votes;
    }

    public void setVotes(int votes) throws DataInputException {
	if (votes < 0) {
	    throw new DataInputException("Votes for a candidate must be a postive number");
	}
	this.votes = votes;
    }

    @Override
    public String toString() {
	return cid + ": " + name + " has " + votes + " votes";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cid == null) ? 0 : cid.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + votes;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Candidate other = (Candidate) obj;
	if (cid == null) {
	    if (other.cid != null)
		return false;
	} else if (!cid.equals(other.cid))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (votes != other.votes)
	    return false;
	return true;
    }

}