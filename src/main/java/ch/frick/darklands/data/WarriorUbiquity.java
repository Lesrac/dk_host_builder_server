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

@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"warrior_id", "ubiquity_id", "realm_id"})})
@NamedQueries({
	@NamedQuery(name="warriorubiquity.warriorInfo", query="select wur from WarriorUbiquity wur where wur.warrior.id = :warrior_id")
}) 
public class WarriorUbiquity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "WARRIOR_ID")
	private Warrior warrior;
	
	@ManyToOne
	@JoinColumn(name = "UBIQUITY_ID")
	private Ubiquity ubiquity;
	
	@ManyToOne
	@JoinColumn(name = "REALM_ID")
	private Realm realm;
	
	@Column
	private int ubiquity_amount;
	
}
