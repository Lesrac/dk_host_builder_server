package ch.frick.darklands.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ch.frick.darklands.daos.WarriorDAO;
import ch.frick.darklands.data.Kindred;
import ch.frick.darklands.data.Warrior;

public class JpaWarriorDAO extends AbstractManagedDAO<Warrior> implements WarriorDAO {

	@Override
	public Warrior getById(Long id) {
		EntityManager em = factory.createEntityManager();
		Warrior find = em.find(Warrior.class, id);
		em.close();
		return find;
	}

	@Override
	public List<Warrior> getAll() {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Warrior> q = em.createNamedQuery("warrior.all", Warrior.class);
		List<Warrior> find = q.getResultList();
		em.close();
		return find;
	}

	@Override
	public void saveOrUpdate(Warrior t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Warrior t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Warrior> getWarriorsByKindred(Long kindred_id) {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Warrior> q = em.createNamedQuery("warrior.byKindred", Warrior.class);
		q.setParameter("kindred_id", kindred_id);
		List<Warrior> find = q.getResultList();
		em.close();
		return find;
	}

}
