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

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="equipment.all", query="select e from Equipment e")
})
public class Equipment implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private int hands;
	
	private boolean option;
	
	private int cost;
	
	@ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="EQUIPMENT_CLASS_ID", nullable = false)
	private EquipmentClass equipmentClass;
	
	@ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="EQUIPMENT_TYPE_ID", nullable = false)
	private EquipmentType equipmentType;
	
	@ManyToMany
  @JoinTable(
      name="EQUIPMENT_EQUIPMENTRULE",
      joinColumns=@JoinColumn(name="EQUIPMENT_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="EQUIPMENTRULE_ID", referencedColumnName="ID"))
	private List<EquipmentRule> equipmentRules;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHands() {
		return hands;
	}

	public void setHands(int hands) {
		this.hands = hands;
	}

	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public EquipmentClass getEquipmentClass() {
		return equipmentClass;
	}

	public void setEquipmentClass(EquipmentClass equipmentClass) {
		this.equipmentClass = equipmentClass;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	public List<EquipmentRule> getEquipmentRules() {
		return equipmentRules;
	}

	public void setEquipmentRules(List<EquipmentRule> equipmentRules) {
		this.equipmentRules = equipmentRules;
	}
	
	
}
