package ch.frick.darklands.data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@NamedQueries({ @NamedQuery(name = "warrior.all", query = "select w from Warrior w"),
		@NamedQuery(name = "warrior.byKindred", query = "select w from Warrior w where w.kindred.id = :kindred_id") })
public class Warrior implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KINDRED_ID", nullable = false)
	@JsonManagedReference
	private Kindred kindred;

	@Column(nullable = false)
	private int hands;

	@Column(nullable = false)
	private int unitSizeMin;

	@Column(nullable = false)
	private int unitSizeMax;

	@Column(nullable = false)
	private int baseSize;

	@Column(nullable = false)
	private int cost;

	@Column(nullable = false)
	private String spelling;

	@Column(nullable = false)
	private boolean sellsword;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "WARRIOR_KIN", joinColumns = @JoinColumn(name = "WARRIOR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "KIN_ID", referencedColumnName = "ID"))
	private Set<Kin> kin;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROFILE_ID")
	private Profile profile;

	@ManyToMany
	@JoinTable(name = "WARRIOR_EQUIPMENT", joinColumns = @JoinColumn(name = "WARRIOR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "EQUIPMENT_ID", referencedColumnName = "ID"))
	private List<Equipment> equipments;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WARRIOR_CLASS_ID", nullable = false)
	private WarriorClass warriorClass;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRIVILEGE_ID", nullable = false)
	private Privilege privilege;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACUITY_ID", nullable = false)
	private Acuity acuity;

	@OneToMany(mappedBy = "warrior")
	@JsonManagedReference
	private Set<WarriorUbiquity> ubiquities;

	@ManyToMany(mappedBy = "warriors")
	private List<Token> tokens;

	public Warrior() {
	}

	public Warrior(String name, Kindred kindred, int hands, int unitSizeMin, int unitSizeMax, int baseSize,
			int cost, String spelling, boolean sellsword) {
		super();
		this.name = name;
		this.kindred = kindred;
		this.hands = hands;
		this.unitSizeMin = unitSizeMin;
		this.unitSizeMax = unitSizeMax;
		this.baseSize = baseSize;
		this.cost = cost;
		this.spelling = spelling;
		this.sellsword = sellsword;
	}

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

	public Set<Kin> getKin() {
		return kin;
	}

	public void setKin(Set<Kin> kin) {
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

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public Set<WarriorUbiquity> getUbiquities() {
		return ubiquities;
	}

	public void setUbiquities(Set<WarriorUbiquity> ubiquities) {
		this.ubiquities = ubiquities;
	}

}