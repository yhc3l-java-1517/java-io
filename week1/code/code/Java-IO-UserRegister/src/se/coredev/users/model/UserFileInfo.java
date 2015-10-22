package se.coredev.users.model;

import java.io.File;

import se.coredev.users.storage.file.FileInfo;

public final class UserFileInfo implements FileInfo<User> {

	@Override
	public String getSingleFileName(User value) {
		return value.getId() + value.getUsername();
	}

	@Override
	public String getCollectionFileName() {
		return "users";
	}

	@Override
	public String getFileExtension() {		
		return ".txt";
	}

	@Override
	public File getDirectory() {
		return new File("users");
	}

}
