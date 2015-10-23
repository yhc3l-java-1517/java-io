package se.coredev.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class User implements Serializable {

	private static final long serialVersionUID = 5947760511614438263L;
	private final String id;
	private transient String username;
	private transient String password;
	private transient Role role;

	public User(String id, String username, String password, Role role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}
	 // Username:secret, Password:userRole:master2
	 private void writeObject(ObjectOutputStream out) throws IOException {
		 out.defaultWriteObject();
		 out.writeUTF(username);
		 out.writeUTF(password);
		 out.writeUTF(role.getName());
	 }
	 
	 private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		 in.defaultReadObject();
		 username = in.readUTF();
		 password = in.readUTF();
		 role = new Role(in.readUTF());
	 }

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof User) {
			User otherUser = (User) other;
			return id.equals(otherUser.id) && username.equals(otherUser.username);
		}

		return false;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result += id.hashCode() * 37;
		result += username.hashCode() * 37;
		return result;
	}

}
