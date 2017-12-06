package fabio.ciconi.club.model;

import fabio.ciconi.club.exception.InvalidMemberData;

public class Member {
	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String password;

	public Member(String userName, String firstName, String lastName, String password) throws InvalidMemberData {
		setUserName(userName);
		setFirstName(userName);
		setLastName(userName);
		setPassword(password);
	}

	public String getUserName() {
		return userName;
	}

	private void setUserName(String userName) throws InvalidMemberData {
		if ( userName == null || userName.trim().isEmpty() ) {
			throw new InvalidMemberData ("No user name supplied");
		}
		this.userName = userName;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws InvalidMemberData {
		if ( firstName == null || firstName.trim().isEmpty() ) {
			throw new InvalidMemberData ("No user name supplied");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws InvalidMemberData {
		if ( lastName == null || lastName.trim().isEmpty() ) {
			throw new InvalidMemberData ("No user name supplied");
		}
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws InvalidMemberData {
		if ( password == null || password.trim().isEmpty() ) {
			throw new InvalidMemberData ("No password supplied");
		}
		this.password = password;
	}

	// generated my Eclipse
	@Override
	public String toString() {
		return "Member [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}


	// generated my Eclipse
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}


	// generated my Eclipse
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
	

}
