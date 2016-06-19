package ch.frick.darklands.daos.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.frick.darklands.daos.ManagedDAO;

public abstract class AbstractManagedDAO<T> implements ManagedDAO<T> {

	private final static Logger Logger = LoggerFactory.getLogger(AbstractManagedDAO.class);

	protected EntityManagerFactory factory;

	public AbstractManagedDAO() {
		factory = Persistence.createEntityManagerFactory("example");
	}

	@Override
	public T manage(T instance) {
		EntityManager em = factory.createEntityManager();
		T merge = em.merge(instance);
		em.close();
		return merge;
	}

}
