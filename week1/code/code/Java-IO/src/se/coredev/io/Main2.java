package se.coredev.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class Main2 {

	public static void main(String[] args) {

		User user1 = new User("1001", "master1", "secret", new Role("admin"));
		User user2 = new User("1002", "master2", "secret", new Role("user"));
		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		UserStorage storage = new UserStorage("users");
//		storage.add(users);
		for (User user : storage.getAll()) {
			System.out.println("Username:"+ user.getUsername() + ", Password:" + user.getPassword()
			+ "Role:" + user.getRole().getName());
		}
		System.out.println("Finished!");

		// // Write
		// try (ObjectOutputStream out = new ObjectOutputStream(new
		// FileOutputStream("user.data"))) {
		// out.writeObject(users);
		// }
		// catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// // Read
		// try (ObjectInputStream in = new ObjectInputStream(new
		// FileInputStream("user.data"))) {
		// List<User> usersFromDisk = (List<User>) in.readObject();
		// for (User u : usersFromDisk) {
		// System.out.println(u.getUsername());
		// }
		// }
		// catch (IOException | ClassNotFoundException e) {
		// e.printStackTrace();
		// }

	}

}
