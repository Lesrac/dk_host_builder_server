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
@NamedQueries({ @NamedQuery(name = "combatWeapon.all", query = "select c from CombatWeapon c") })
public class CombatWeapon implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int attackDice;

	private int weaponPlus;

	private int mAndW;

	private int attackRange;

	private int chargePlus;

	private int mAndWAndCh;

	private String woundPlus;

	@ManyToOne
	@JoinColumn(name = "EQUIPMENT_ID", nullable = false)
	private Equipment equipment;

	public int getAttackDice() {
		return attackDice;
	}

	public void setAttackDice(int attackDice) {
		this.attackDice = attackDice;
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

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	public int getChargePlus() {
		return chargePlus;
	}

	public void setChargePlus(int chargePlus) {
		this.chargePlus = chargePlus;
	}

	public int getmAndWAndCh() {
		return mAndWAndCh;
	}

	public void setmAndWAndCh(int mAndWAndCh) {
		this.mAndWAndCh = mAndWAndCh;
	}

	public String getWoundPlus() {
		return woundPlus;
	}

	public void setWoundPlus(String woundPlus) {
		this.woundPlus = woundPlus;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

}
