package ch.frick.darklands.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({ @NamedQuery(name = "warriorClass.all", query = "select w from WarriorClass w") })
public class WarriorClass implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToMany
	@JoinTable(name = "WARRIOR_CLASSES", 
		joinColumns = @JoinColumn(name = "WARRIORCLASS_ID", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "WARRIOR_ID", referencedColumnName = "ID"))
	private List<Warrior> warriors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
