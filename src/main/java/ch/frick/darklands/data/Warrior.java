package ch.frick.darklands.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="warrior.all", query="select w from Warrior w"),
	@NamedQuery(name="warrior.byKindred", query="select w from Warrior w where w.kindred.id = :kindred_id")
}) 
public class Warrior implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="KINDRED_ID", nullable = false)
	private Kindred kindred;
	
	private int hands;
	
	private int unitSizeMin;
	
	private int unitSizeMax;
	
	private int baseSize;
	
	private int cost;
	
	private String spelling;
	
	private boolean sellsword;
	
	@ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="KIN_ID", nullable = false)
	private Kin kin;
	
	@OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="PROFILE_ID")
	private Profile profile;
	
	@ManyToMany
  @JoinTable(
      name="WARRIOR_EQUIPMENT",
      joinColumns=@JoinColumn(name="WARRIOR_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="EQUIPMENT_ID", referencedColumnName="ID"))
	private List<Equipment> equipments;
	
	@ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="WARRIOR_CLASS_ID", nullable = false)
	private WarriorClass warriorClass;
	
	@ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="PRIVILEGE_ID", nullable = false)
	private Privilege privilege;
	
	@ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="ACUITY_ID", nullable = false)
	private Acuity acuity;

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

	public int getHands() {
		return hands;
	}

	public void setHands(int hands) {
		this.hands = hands;
	}

	public int getUnitSizeMin() {
		return unitSizeMin;
	}

	public void setUnitSizeMin(int unitSizeMin) {
		this.unitSizeMin = unitSizeMin;
	}

	public int getUnitSizeMax() {
		return unitSizeMax;
	}

	public void setUnitSizeMax(int unitSizeMax) {
		this.unitSizeMax = unitSizeMax;
	}

	public int getBaseSize() {
		return baseSize;
	}

	public void setBaseSize(int baseSize) {
		this.baseSize = baseSize;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	public boolean isSellsword() {
		return sellsword;
	}

	public void setSellsword(boolean sellsword) {
		this.sellsword = sellsword;
	}

	public Kin getKin() {
		return kin;
	}

	public void setKin(Kin kin) {
		this.kin = kin;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public WarriorClass getWarriorClass() {
		return warriorClass;
	}

	public void setWarriorClass(WarriorClass warriorClass) {
		this.warriorClass = warriorClass;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public Acuity getAcuity() {
		return acuity;
	}

	public void setAcuity(Acuity acuity) {
		this.acuity = acuity;
	}
	
}