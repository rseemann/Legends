package Ficha;

import java.io.Serializable;
import java.util.*;

import Skills.Skill;

public class RPGCharacter implements Serializable {
	private String name = "";
	private String family = "";
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	private int skillPoints;
	private String clan = "";
	private Map wounds = new HashMap();
	private double glory = 0;
	private double honor = 0;
	private double status = 0;
	private double taint = 0;
	private int experiencePoints = 0;
	private String school = "";

	// traits
	private int stamina= 0;
	private int willpower= 0;
	private int stength= 0;
	private int perception= 0;
	private int agility= 0;
	private int intelligence= 0;
	private int reflexes= 0;
	private int awareness= 0;
	
	// rings
	private int earthRing = 0;
	private int waterRing = 0;
	private int fireRing = 0;
	private int airRing = 0;
	private int voidRing = 0;
	private int ringSum = 0;

	private int rank = 0;

	public void calcRank() {
		this.rank = (this.ringSum * 10) + (skillPoints);
	}

	// system related methods
	// hit points
	public void setWounds(int earthRing) {
		wounds.put("Healthy", earthRing * 2);
		wounds.put("Nicked", earthRing * 4);
		wounds.put("Grazed", earthRing * 6);
		wounds.put("Hurt", earthRing * 8);
		wounds.put("Injured", earthRing * 10);
		wounds.put("Crippled", earthRing * 12);
		wounds.put("Down", earthRing * 14);
		wounds.put("Out", earthRing * 19);
	}

	public Map getWounds() {
		return wounds;

	}

	// constructor

	/*
	 * public void RPGCharacter(String name, String clan, int stamina, int
	 * willpower, int strength, int perception, int agility, int intelligence,
	 * int reflexes, int awareness, int voidTrait) {
	 * 
	 * this.setName(name); this.setClan(clan); this.setStamina(stamina);
	 * this.setWillpower(willpower); this.setStrength(strength);
	 * this.setPerception(perception); this.setAgility(agility);
	 * this.setIntelligence(intelligence); this.setReflexes(reflexes);
	 * this.setAwareness(awareness); this.setVoidTrait(voidTrait);
	 * 
	 * }
	 */

	// skills
	public void addSkill(String name) {
		skills.add(new Skill(name));
	}

	public int getSkillLocation(String skillName) { // finds the location of the
		// desired skill in the list
		int i = 0;
		while (skillName.compareToIgnoreCase(skills.get(i).getName()) != 0) {
			i++;
		}
		return i;
	}

	public int getSkillRank(String skillName) {
		int i = getSkillLocation(skillName);
		return skills.get(i).getRank();
	}

	public void setSkillRank(String skillName, int rank) {
		int i = getSkillLocation(skillName);
		this.skills.get(i).setRank(rank);
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	//

	// ring related methods
	public void calcRingSum() {
		ringSum = earthRing + waterRing + fireRing + airRing + voidRing;
	}

	public void calcRings() { // calculates the value of the rings

		// earth ring
		if (stamina <= willpower) {
			earthRing = stamina;
		} else {
			earthRing = willpower;
		}

		// water ring
		if (stength <= perception) {
			waterRing = stength;
		} else {
			waterRing = perception;
		}

		// fire ring
		if (agility <= intelligence) {
			fireRing = agility;
		} else {
			fireRing = intelligence;
		}

		// air ring
		if (reflexes <= awareness) {
			airRing = reflexes;
		} else {
			airRing = awareness;
		}

		// void ring
		
	}

	// getters e setters

	public void setHonor(double honor) {
		this.honor = honor;
	}

	public double getHonor() {
		return honor;
	}

	public void setGlory(double glory) {
		this.glory = glory;
	}

	public double getGlory() {
		return glory;
	}

	public void setStatus(double status) {
		this.status = status;
	}

	public double getStatus() {
		return status;
	}

	public void setTaint(double taint) {
		this.taint = taint;
	}

	public double getTaint() {
		return taint;
	}

	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	public int getRingSum() {
		return ringSum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getFamily() {
		return family;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getStamina() {
		return stamina;
	}

	public void setWillpower(int willpower) {
		this.willpower = willpower;
	}

	public int getWillpower() {
		return willpower;
	}

	public void setStrength(int stength) {
		this.stength = stength;
	}

	public int getStength() {
		return stength;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}

	public int getPerception() {
		return perception;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getAgility() {
		return agility;
	}

	public void setReflexes(int reflexes) {
		this.reflexes = reflexes;
	}

	public int getReflexes() {
		return reflexes;
	}

	public void setAwareness(int awareness) {
		this.awareness = awareness;
	}

	public int getAwareness() {
		return awareness;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}
	
	public void setVoidRing(int voidRing) {
		this.voidRing = voidRing;
	}
	
	public String getClan() {
		return clan;
	}

	public int getEarthRing() {
		return earthRing;
	}

	public int getWaterRing() {
		return waterRing;
	}

	public int getFireRing() {
		return fireRing;
	}

	public int getAirRing() {
		return airRing;
	}

	public int getVoidRing() {
		return voidRing;
	}

	public int getRank() {
		return rank;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

}
