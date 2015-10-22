package se.coredev.users.storage;

import java.util.List;
import java.util.Set;

public interface Storage<T> {

	void add(T value);

	void add(List<T> values);

	Set<T> getAll();
}
