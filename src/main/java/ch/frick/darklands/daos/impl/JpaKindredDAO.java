package ch.frick.darklands.daos.impl;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.frick.darklands.daos.KindredDAO;
import ch.frick.darklands.data.Kindred;

public class JpaKindredDAO extends AbstractManagedDAO<Kindred> implements KindredDAO {

	@Override
	public Kindred getById(Long id) {
		EntityManager em = factory.createEntityManager();
		Kindred find = em.find(Kindred.class, id);
		em.close();
		return find;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kindred> getAll() {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Kindred> q = em.createNamedQuery("kindred.all", Kindred.class);
		List<Kindred> kindreds = q.getResultList();
		em.close();
		return kindreds.isEmpty() ? Collections.EMPTY_LIST : kindreds;
	}

	@Override
	public void saveOrUpdate(Kindred t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Kindred kindred) {
		EntityManager em = factory.createEntityManager();
		em.remove(kindred);
		em.close();
	}

}
