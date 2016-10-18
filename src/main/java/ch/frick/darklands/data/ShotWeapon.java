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

@SuppressWarnings({ "serial", "initialization.fields.uninitialized" })
@Entity
@NamedQueries({ @NamedQuery(name = "shotWeapon.all", query = "select s from ShotWeapon s") })
public class ShotWeapon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int dice;

	private int weaponPlus;

	private int mAndW;

	private int minimumRange;

	private int lethalRange;

	private int effectiveRange;

	private int maximumRange;

	private String woundPlus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EQUIPMENT_ID", nullable = false)
	private Equipment equipment;

	public int getDice() {
		return dice;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}

	public int getWeaponPlus() {
		return weaponPlus;
	}

	public void setWeaponPlus(int weaponPlus) {
		this.weaponPlus = weaponPlus;
	}

	public int getmAndW() {
		return mAndW;
	}

	public void setmAndW(int mAndW) {
		this.mAndW = mAndW;
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
