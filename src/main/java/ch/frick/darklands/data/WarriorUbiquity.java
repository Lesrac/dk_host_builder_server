package ch.frick.darklands.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@SuppressWarnings({"serial", "initialization.fields.uninitialized"})
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "warrior_id", "ubiquity_id", "realm_id" }) })
@NamedQueries({
		@NamedQuery(name = "warriorubiquity.warriorInfo", query = "select wur from WarriorUbiquity wur where wur.warrior.id = :warrior_id") })
public class WarriorUbiquity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "WARRIOR_ID")
	@JsonBackReference
	private Warrior warrior;

	@ManyToOne(optional = false)
	@JoinColumn(name = "UBIQUITY_ID")
	@JsonManagedReference
	private Ubiquity ubiquity;

	@ManyToOne(optional = false)
	@JoinColumn(name = "REALM_ID")
	private Realm realm;

	@Column(nullable = false)
	private int ubiquity_amount;

	public WarriorUbiquity() {
	}

	public WarriorUbiquity(Warrior warrior, Ubiquity ubiquity, Realm realm, int ubiquity_amount) {
		super();
		this.warrior = warrior;
		this.ubiquity = ubiquity;
		this.realm = realm;
		this.ubiquity_amount = ubiquity_amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Warrior getWarrior() {
		return warrior;
	}

	public void setWarrior(Warrior warrior) {
		this.warrior = warrior;
	}

	public Ubiquity getUbiquity() {
		return ubiquity;
	}

	public void setUbiquity(Ubiquity ubiquity) {
		this.ubiquity = ubiquity;
	}

	public Realm getRealm() {
		return realm;
	}

	public void setRealm(Realm realm) {
		this.realm = realm;
	}

	public int getUbiquity_amount() {
		return ubiquity_amount;
	}

	public void setUbiquity_amount(int ubiquity_amount) {
		this.ubiquity_amount = ubiquity_amount;
	}

}
