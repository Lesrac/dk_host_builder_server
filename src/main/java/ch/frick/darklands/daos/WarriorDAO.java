package ch.frick.darklands.daos;

import java.util.List;

import ch.frick.darklands.data.Warrior;
import ch.frick.darklands.data.WarriorClass;
import ch.frick.darklands.data.Token;

public interface WarriorDAO extends DAO<Warrior>{

	List<Warrior> getWarriorsByKindred(Long kindred_id);
	
	List<WarriorClass> getWarriorClasses();
	
	List<Token> getTokens();
	
}
