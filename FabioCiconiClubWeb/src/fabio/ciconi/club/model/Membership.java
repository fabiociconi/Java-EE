package fabio.ciconi.club.model;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import fabio.ciconi.club.exception.MembershipException;

import java.util.List;
import java.util.Map;

public class Membership {
    private static Membership membership = null;
    private Map<String, Member> members;

    private Membership() {
	members = new ConcurrentHashMap<String, Member>();
    }

    // enhanced singleton implementation to minimize synchronization
    public static Membership getInstance() {
	if (membership == null) {
	    synchronized (Membership.class) {
		if (membership == null) {
		    membership = new Membership();
		}
	    }
	}
	return membership;
    }

    // returns null if no member has this name/key
    public Member getMember(String userName) throws MembershipException {
	Member member = members.get(userName);
	if (member == null) {
	    throw new MembershipException(" No member with user name: " + userName);
	}
	return member;
    }

    // Overwrite is member with this name exists
    public Member addMember(Member member) throws MembershipException {
	String user = member.getUserName();
	Member exists = members.get(user);
	if (exists != null) {
	    throw new MembershipException(" User name " + user + "already in use");
	}
	members.put(user, member);
	return member;
    }

    public Member removeMember(String userName) throws MembershipException {
	Member member = members.get(userName);
	if (member == null) {
	    throw new MembershipException("Attempt to remove unknown member: " + userName);
	}
	members.remove(userName);
	return member;
    }

    public List<String> getMemberNames() {
	List<String> memberNames = new ArrayList<String>();
	for (Member member : members.values()) {
	    memberNames.add(member.getUserName());
	}
	return memberNames;
    }

    public boolean authenticate(String userName, String password) {
	Member member = members.get(userName);
	if (member == null) {
	    return false;
	}
	return member.getPassword().equals(password);
    }

}
