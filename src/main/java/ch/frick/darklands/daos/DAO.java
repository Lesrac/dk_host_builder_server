package ch.frick.darklands.daos;

import java.util.List;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface DAO<T> {
	@Nullable
	T getById(Long id);

	List<T> getAll();

	void saveOrUpdate(T t);

	void delete(T t);
}
