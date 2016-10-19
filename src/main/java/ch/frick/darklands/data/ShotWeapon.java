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
@NamedQueries({ @NamedQuery(name = "shotWeapon.all", query = "select s from ShotWeapon s") })
public class ShotWeapon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int shootDice;

	private String gazeDamage;

	private String glanceDamage;

	private int minimumRange;

	private int lethalRange;

	private int effectiveRange;

	private int maximumRange;

	private String woundPlus;

	@ManyToOne
	@JoinColumn(name = "EQUIPMENT_ID", nullable = false)
	private Equipment equipment;

	public int getShootDice() {
		return shootDice;
	}

	public void setShootDice(int dice) {
		this.shootDice = dice;
	}

	public String getGazeDamage() {
		return gazeDamage;
	}

	public void setGazeDamage(String gazeDamage) {
		this.gazeDamage = gazeDamage;
	}

	public String getGlanceDamage() {
		return glanceDamage;
	}

	public void setGlanceDamage(String glanceDamage) {
		this.glanceDamage = glanceDamage;
	}

	public int getMinimumRange() {
		return minimumRange;
	}

	public void setMinimumRange(int minimumRange) {
		this.minimumRange = minimumRange;
	}

	public int getLethalRange() {
		return lethalRange;
	}

	public void setLethalRange(int lethalRange) {
		this.lethalRange = lethalRange;
	}

	public int getEffectiveRange() {
		return effectiveRange;
	}

	public void setEffectiveRange(int effectiveRange) {
		this.effectiveRange = effectiveRange;
	}

	public int getMaximumRange() {
		return maximumRange;
	}

	public void setMaximumRange(int maximumRange) {
		this.maximumRange = maximumRange;
	}

	public String getWoundPlus() {
		return woundPlus;
	}

	public void setWoundPlus(String woundPlus) {
		this.woundPlus = woundPlus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

}
