package ch.frick.darklands.daos;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface ManagedDAO<T> {
	@Nullable T manage(T instance);
}
