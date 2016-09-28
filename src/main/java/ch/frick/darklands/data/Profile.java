package ch.frick.darklands.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="profile.all", query="select p from Profile p")
}) 
public class Profile implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int pace;
	
	private int skill;
	
	private int might;
	
	private int constitution;
	
	private int fortitude;
	
	private int authority;
	
	private int temper;
	
	@ElementCollection
  @CollectionTable(
        name="CONST_MARKER",
        joinColumns=@JoinColumn(name="PROFILE_ID")
  )
	private List<Integer> constitution_markers;
	
	@ManyToMany
	@JoinTable(
      name="PROFILE_SPECIALRULE",
      joinColumns=@JoinColumn(name="PROFILE_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="SPECIALRULE_ID", referencedColumnName="ID"))
	private List<SpecialRule> specialRules;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPace() {
		return pace;
	}

	public void setPace(int pace) {
		this.pace = pace;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getMight() {
		return might;
	}

	public void setMight(int might) {
		this.might = might;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getFortitude() {
		return fortitude;
	}

	public void setFortitude(int fortitude) {
		this.fortitude = fortitude;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public int getTemper() {
		return temper;
	}

	public void setTemper(int temper) {
		this.temper = temper;
	}

	public List<SpecialRule> getSpecialRules() {
		return specialRules;
	}

	public void setSpecialRules(List<SpecialRule> specialRules) {
		this.specialRules = specialRules;
	}

	public List<Integer> getConstitution_markers() {
		return constitution_markers;
	}

	public void setConstitution_markers(List<Integer> constitution_markers) {
		this.constitution_markers = constitution_markers;
	}
	
}
