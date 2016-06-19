package ch.frick.darklands.daos;

public interface ManagedDAO<T> {
	T manage(T instance);
}
