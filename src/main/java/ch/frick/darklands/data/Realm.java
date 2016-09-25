package ch.frick.darklands.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({ @NamedQuery(name = "realm.all", query = "select r from Realm r") })
public class Realm implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KINDRED_ID", nullable = false)
	private Kindred kindred;

	public Realm() {
	}

	public Realm(String name, Kindred kindred) {
		super();
		this.name = name;
		this.kindred = kindred;
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

	public Kindred getKindred() {
		return kindred;
	}

	public void setKindred(Kindred kindred) {
		this.kindred = kindred;
	}

}
