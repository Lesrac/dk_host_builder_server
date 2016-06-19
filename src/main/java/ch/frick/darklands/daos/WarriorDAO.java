package ch.frick.darklands.daos;

import java.util.List;

import ch.frick.darklands.data.Warrior;

public interface WarriorDAO extends DAO<Warrior>{

	List<Warrior> getWarriorsByKindred(Long kindred_id);
	
}
