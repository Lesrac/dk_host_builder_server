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

@SuppressWarnings({"serial", "initialization.fields.uninitialized"})
@Entity
@NamedQueries({ @NamedQuery(name = "token.all", query = "select t from Token t") })
public class Token implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToMany
	@JoinTable(name = "WARRIOR_TOKEN", 
		joinColumns = @JoinColumn(name = "TOKEN_ID", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "WARRIOR_ID", referencedColumnName = "ID"))
	private List<Warrior> warriors;

	public Token() {
	}

	public Token(String name) {
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

}
