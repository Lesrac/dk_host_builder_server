package ch.frick.darklands.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="kindred.all", query="select k from Kindred k")
}) 
public class Kindred implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="kindred")
	@JsonBackReference
	private List<Warrior> warriors = new ArrayList<Warrior>();

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

	public List<Warrior> getWarriors() {
		return warriors;
	}

	public void setWarriors(List<Warrior> warriors) {
		this.warriors = warriors;
	}
	
}
