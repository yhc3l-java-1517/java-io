package se.coredev.users.storage.file;

import java.io.File;

public interface FileInfo<T> {

	String getSingleFileName(T value);

	String getCollectionFileName();

	String getFileExtension();
	
	File getDirectory();
}