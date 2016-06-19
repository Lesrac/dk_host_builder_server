package ch.frick.darklands.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="armour.all", query="select a from Armour a")
}) 
public class Armour implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int number;
	
	private int cAndA;
	
	private String woundMinus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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
	
}
