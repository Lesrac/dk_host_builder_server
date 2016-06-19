package ch.frick.darklands.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="shotWeapon.all", query="select s from ShotWeapon s")
}) 
public class ShotWeapon extends Equipment implements Serializable{

	private int dice;
	
	private int weaponPlus;
	
	private int mAndW;
	
	private int minimumRange;
	
	private int lethalRange;
	
	private int effectiveRange;
	
	private int maximumRange;
	
	private String woundPlus;

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
	
}
