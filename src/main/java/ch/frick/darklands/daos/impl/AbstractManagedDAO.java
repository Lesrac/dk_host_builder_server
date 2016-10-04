package ch.frick.darklands.daos.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.checkerframework.checker.nullness.qual.Nullable;

import ch.frick.darklands.daos.ManagedDAO;

public abstract class AbstractManagedDAO<T> implements ManagedDAO<T> {

	protected EntityManagerFactory factory;

	public AbstractManagedDAO() {
		factory = Persistence.createEntityManagerFactory("example");
	}

	@Override
	public @Nullable T manage(T instance) {
		EntityManager em = factory.createEntityManager();
		T merge = null;
		if (instance != null) {
			merge = em.merge(instance);
		}
		em.close();
		return merge;
	}

}
