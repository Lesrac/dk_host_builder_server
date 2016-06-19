package ch.frick.darklands.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="combatWeapon.all", query="select c from CombatWeapon c")
})
public class CombatWeapon extends Equipment implements Serializable{

	private int attackDice;
	
	private int weaponPlus;
	
	private int mAndW;
	
	private int attackRange;
	
	private int chragePlus;
	
	private int mAndWAndCh;
	
	private String woundPlus;

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

	public int getChragePlus() {
		return chragePlus;
	}

	public void setChragePlus(int chragePlus) {
		this.chragePlus = chragePlus;
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
	
	
}
