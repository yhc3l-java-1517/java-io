package se.coredev.io;

import java.io.Serializable;

public final class User implements Serializable {
	
	private static final long serialVersionUID = 5947760511614438263L;
	private final String username;
	private final String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	//TODO: implement equals and hashCode
}
