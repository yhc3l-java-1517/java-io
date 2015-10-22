package se.coredev.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import se.coredev.users.model.User;
import se.coredev.users.model.UserFileInfo;
import se.coredev.users.model.UserParser;
import se.coredev.users.model.UserService;
import se.coredev.users.storage.Storage;
import se.coredev.users.storage.file.FileStorage;
import se.coredev.users.storage.memory.MemoryStorage;

public final class Main {

	public static void main(String[] args) throws IOException {
		
		Storage<User> diskStorage = new FileStorage<>(new UserFileInfo() , new UserParser());
		Storage<User> storage = new MemoryStorage<>(diskStorage);
		UserService userService = new UserService(storage);
		
//		User user = new User("1001", "master", "admin");
//		userService.save(user);
//		
//		List<User> users = new ArrayList<>();
//		users.add(new User("1002", "yoda", "sysadmin"));
//		users.add(new User("1003", "luke", "master"));
//		users.add(new User("1004", "leia", "superuser"));
//		users.add(new User("1005", "darth", "regularuser"));
//		
//		userService.save(users);
		
		userService.print();
	}
	
}
