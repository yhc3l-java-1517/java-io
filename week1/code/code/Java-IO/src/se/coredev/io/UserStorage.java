package se.coredev.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class UserStorage {

	private final File destination;
	private final List<User> users;

	public UserStorage(String directory) {

		File dir = new File(directory);
		this.destination = new File(dir, "users.data");
		this.users = new ArrayList<>();
		
		if (!dir.exists()) {
			dir.mkdir();
		}
		restore();
	}

	private void persist() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(destination))) {
			out.writeObject(users);
		}
		catch (IOException e) {
			throw new RuntimeException("Could not persist users", e);
		}
	}

	@SuppressWarnings("unchecked")
	private void restore() {

		if (destination.exists()) {

			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(destination))) {
				this.users.addAll((List<User>) in.readObject());
			}
			catch (IOException | ClassNotFoundException e) {
				throw new RuntimeException("Could not restore storage", e);
			}
		}
	}

	public void add(User user) {
		users.add(user);
		persist();
	}

	public void add(List<User> users) {
		this.users.addAll(users);
		persist();
	}

	public List<User> getAll() {
		return new ArrayList<>(users);
	}
}
