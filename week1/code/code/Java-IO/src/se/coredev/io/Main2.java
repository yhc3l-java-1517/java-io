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

		User user1 = new User("master1", "secret");
		User user2 = new User("master2", "secret");
		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);

		// Write
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.data"))) {
			out.writeObject(users);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		// Read
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.data"))) {
			List<User> usersFromDisk = (List<User>) in.readObject();
			for (User u : usersFromDisk) {
				System.out.println(u.getUsername());
			}
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
