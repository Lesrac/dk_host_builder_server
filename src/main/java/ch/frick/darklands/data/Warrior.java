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

@SuppressWarnings({ "serial", "initialization.fields.uninitialized" })
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
	private int uniteSizeMin;

	@Column(nullable = false)
	private int uniteSizeMax;

	@Column(nullable = false)
	private int baseSize;

	@Column(nullable = false)
	private int cost;

	@Column(nullable = false)
	private String spelling;

	@Column(nullable = false)
	private boolean isSellsword;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "WARRIOR_KIN", joinColumns = @JoinColumn(name = "WARRIOR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "KIN_ID", referencedColumnName = "ID"))
	private Set<Kin> kin;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROFILE_ID")
	private Profile profile;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "WARRIOR_COMBATWEAPON", joinColumns = @JoinColumn(name = "WARRIOR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "COMBATWEAPON_ID", referencedColumnName = "ID"))
	private List<CombatWeapon> combatWeapons;

	@ManyToMany(mappedBy = "warriors", fetch = FetchType.LAZY)
	private List<WarriorClass> warriorClasses;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRIVILEGE_ID", nullable = false)
	private Privilege privilege;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACUITY_ID", nullable = false)
	private Acuity acuity;

	@OneToMany(mappedBy = "warrior", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<WarriorUbiquity> ubiquities;

	@ManyToMany(mappedBy = "warriors", fetch = FetchType.LAZY)
	private List<Token> tokens;

	public Warrior() {
	}

	public Warrior(String name, Kindred kindred, int hands, int uniteSizeMin, int uniteSizeMax, int baseSize, int cost,
			String spelling, boolean sellsword) {
		super();
		this.name = name;
		this.kindred = kindred;
		this.hands = hands;
		this.uniteSizeMin = uniteSizeMin;
		this.uniteSizeMax = uniteSizeMax;
		this.baseSize = baseSize;
		this.cost = cost;
		this.spelling = spelling;
		this.isSellsword = sellsword;
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

	public int getUniteSizeMin() {
		return uniteSizeMin;
	}

	public void setUniteSizeMin(int unitSizeMin) {
		this.uniteSizeMin = unitSizeMin;
	}

	public int getUniteSizeMax() {
		return uniteSizeMax;
	}

	public void setUniteSizeMax(int unitSizeMax) {
		this.uniteSizeMax = unitSizeMax;
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
		return isSellsword;
	}

	public void setIsSellsword(boolean isSellsword) {
		this.isSellsword = isSellsword;
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

	public List<WarriorClass> getWarriorClass() {
		return warriorClasses;
	}

	public void setWarriorClass(List<WarriorClass> warriorClass) {
		this.warriorClasses = warriorClass;
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

	public List<CombatWeapon> getCombatWeapons() {
		return combatWeapons;
	}

	public void setCombatWeapons(List<CombatWeapon> combatWeapons) {
		this.combatWeapons = combatWeapons;
	}

	public List<WarriorClass> getWarriorClasses() {
		return warriorClasses;
	}

	public void setWarriorClasses(List<WarriorClass> warriorClasses) {
		this.warriorClasses = warriorClasses;
	}

	public void setSellsword(boolean isSellsword) {
		this.isSellsword = isSellsword;
	}

}