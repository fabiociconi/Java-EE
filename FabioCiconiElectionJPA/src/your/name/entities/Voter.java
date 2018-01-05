package your.name.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import your.name.exceptions.DataInputException;

@Entity
@Table(name = "VOTER", schema = "ELECTION")
public class Voter {
    @Id
    @Column(name = "VPK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vid;
    @Embedded
    private PersonsName voterName;
    private String password;
    @Column(name = "VOTED")
    Boolean hasVoted;

    public Voter() {
	super();
    }

    public int getVid() {
	return vid;
    }

    public void setVid(int vid) {
	this.vid = vid;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) throws DataInputException {
	if (password == null || password.trim().isEmpty()) {
	    throw new DataInputException("Attempt to create voter with no student number");
	}
	this.password = password.trim();
    }

    public PersonsName getVoterName() {
	return voterName;
    }

    public void setVoterName(PersonsName name) throws DataInputException {
	if (name == null) {
	    throw new DataInputException("A person must have a name");
	}
	this.voterName = name;
    }

    public boolean isVoted() {
	return getHasVoted();
    }

    public Boolean getHasVoted() {
	if (hasVoted == null) {
	    return Boolean.FALSE;
	} else {
	    return hasVoted;
	}
    }

    public void setHasVoted(Boolean hasVoted) {
	this.hasVoted = hasVoted;
    }

    @Override
    public String toString() {
	if (getHasVoted()) {
	    return vid + ": " + voterName + " has Voted";
	} else {
	    return vid + ": " + voterName + " has not Voted";
	}
    }

}
