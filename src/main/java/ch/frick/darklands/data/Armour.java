package ch.frick.darklands.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings({ "serial", "initialization.fields.uninitialized" })
@Entity
@NamedQueries({ @NamedQuery(name = "armour.all", query = "select a from Armour a") })
public class Armour implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int armourPlus;

	private int cAndA;

	private String woundMinus;

	@ManyToOne
	@JoinColumn(name = "EQUIPMENT_ID", nullable = false)
	private Equipment equipment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getArmourPlus() {
		return armourPlus;
	}

	public void setArmourPlus(int number) {
		this.armourPlus = number;
	}

	public int getcAndA() {
		return cAndA;
	}

	public void setcAndA(int cAndA) {
		this.cAndA = cAndA;
	}

	public String getWoundMinus() {
		return woundMinus;
	}

	public void setWoundMinus(String woundMinus) {
		this.woundMinus = woundMinus;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

}
