package ch.frick.darklands.daos;

import java.util.List;

public interface DAO<T> {
	T getById(Long id);
	List<T> getAll();

	void saveOrUpdate(T t);

	void delete(T t);
}
