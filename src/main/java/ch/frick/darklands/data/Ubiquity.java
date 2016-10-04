package ch.frick.darklands.data;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings({"serial", "initialization.fields.uninitialized"})
@Entity
@NamedQueries({ @NamedQuery(name = "ubiquity.all", query = "select u from Ubiquity u") })
public class Ubiquity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "ubiquity")
	@JsonBackReference
	private Set<WarriorUbiquity> warriors;

	public Ubiquity() {
	}

	public Ubiquity(String name) {
		super();
		this.name = name;
	}

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

	public Set<WarriorUbiquity> getWarriors() {
		return warriors;
	}

	public void setWarriors(Set<WarriorUbiquity> warriors) {
		this.warriors = warriors;
	}

}
