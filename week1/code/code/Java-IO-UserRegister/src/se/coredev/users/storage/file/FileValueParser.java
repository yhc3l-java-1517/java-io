package se.coredev.users.storage.file;

public interface FileValueParser<T>  {

	T asType(String string);

	String asString(T value);
}
