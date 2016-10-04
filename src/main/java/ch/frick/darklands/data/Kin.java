package ch.frick.darklands.data;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@NamedQueries({
	@NamedQuery(name="kin.all", query="select k from Kin k")
}) 
public class Kin implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "KIN_KINDREDS", 
		joinColumns = @JoinColumn(name = "KIN_ID", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "KINDRED_ID", referencedColumnName = "ID"))
	private Set<Kindred> kindreds;

	public Kin(){}
	
	public Kin(String name){
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

	public Set<Kindred> getKindreds() {
		return kindreds;
	}

	public void setKindreds(Set<Kindred> kindreds) {
		this.kindreds = kindreds;
	}
	
}
