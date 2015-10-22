package se.coredev.users.storage.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import se.coredev.users.storage.Storage;

public final class FileStorage<T> implements Storage<T> {

	private final FileInfo<T> fileInfo;
	private final FileValueParser<T> parser;

	public FileStorage(FileInfo<T> fileInfo, FileValueParser<T> parser) {
		this.fileInfo = fileInfo;
		this.parser = parser;
		setup();
	}

	private void setup() {
		if (!fileInfo.getDirectory().exists()) {
			fileInfo.getDirectory().mkdir();
		}
	}

	private void persist(String fileName, List<T> values) {

		final File destination = new File(fileInfo.getDirectory(), fileName);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

			for (T value : values) {
				writer.write(parser.asString(value));
				writer.newLine();
			}
		}
		catch (IOException e) {
			throw new RuntimeException("Could not persist users", e);
		}
	}

	private Set<T> readAllFromFile(File sourceFile) {

		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {

			final Set<T> result = new HashSet<>();

			String line = null;
			while ((line = reader.readLine()) != null) {
				result.add(parser.asType(line));
			}

			return result;
		}
		catch (IOException e) {
			throw new RuntimeException("Problem while reading from disk", e);
		}
	}

	@Override
	public void add(T value) {
		String filename = fileInfo.getSingleFileName(value) + fileInfo.getFileExtension();
		persist(filename, Arrays.asList(value));
	}

	@Override
	public void add(List<T> values) {
		persist(fileInfo.getCollectionFileName() + fileInfo.getFileExtension(), values);
	}

	@Override
	public Set<T> getAll() {

		final Set<T> result = new HashSet<>();

		for (String fileName : fileInfo.getDirectory().list()) {

			File sourceFile = new File(fileInfo.getDirectory(), fileName);
			result.addAll(readAllFromFile(sourceFile));
		}

		return result;
	}
}