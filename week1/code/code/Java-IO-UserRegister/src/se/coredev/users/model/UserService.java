package se.coredev.users.model;

import java.io.IOException;
import java.util.List;

import se.coredev.users.storage.Storage;

public final class UserService {

	private final Storage<User> storage;

	public UserService(Storage<User> storage) {
		this.storage = storage;
	}

	public void save(User user) throws IOException {
		storage.add(user);
	}

	public void save(List<User> users) throws IOException {
		storage.add(users);
	}

	public void print() {
		for (User user : storage.getAll()) {
			System.out.println(user);
		}
	}
}