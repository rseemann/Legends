package Ficha;

import java.util.*;

public class RPGCharacter {
	private String name;
	private Family family;
	private Skill[] skills;
	private String clan;
	private Map wounds = new HashMap();
	private double glory;
	private double honor;
	private double status;
	private double taint;
	private int experiencePoints;

	// traits
	private int stamina;
	private int willpower;
	private int stength;
	private int perception;
	private int agility;
	private int intelligence;
	private int reflexes;
	private int awareness;
	private int voidTrait; // can't create a variable named void

	// rings
	private int earthRing;
	private int waterRing;
	private int fireRing;
	private int airRing;
	private int voidRing;
	private int ringSum;

	private int rank;

	public void calcRank() {
		// this.rank = (Formulas)
	}

	// system related methods
	// hit points
	public void setWounds() {
		wounds.put("Healthy", this.earthRing * 2);
		wounds.put("Nicked", this.earthRing * 4);
		wounds.put("Grazed", this.earthRing * 6);
		wounds.put("Hurt", this.earthRing * 8);
		wounds.put("Injured", this.earthRing * 10);
		wounds.put("Crippled", this.earthRing * 12);
		wounds.put("Down", this.earthRing * 14);
		wounds.put("Out", this.earthRing * 19);
	}

	
	
	
	
	// ring related methods
	public void calcRingSum() {
		this.ringSum = this.earthRing + this.waterRing + this.fireRing
				+ this.airRing + this.voidRing;
	}

	public void calcRings() { // calculates the value of the rings

		// earth ring
		if (this.stamina <= this.willpower) {
			this.earthRing = this.stamina;
		} else {
			this.earthRing = this.willpower;
		}

		// water ring
		if (this.stength <= this.perception) {
			this.waterRing = this.stength;
		} else {
			this.waterRing = this.perception;
		}

		// fire ring
		if (this.agility <= this.intelligence) {
			this.fireRing = this.agility;
		} else {
			this.fireRing = this.intelligence;
		}

		// air ring
		if (this.reflexes <= this.awareness) {
			this.airRing = this.reflexes;
		} else {
			this.airRing = this.awareness;
		}

		// void ring
		this.voidRing = this.voidTrait;
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

	public void setFamily(Family family) {
		this.family = family;
	}

	public Family getFamily() {
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

	public void setStength(int stength) {
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

	public void setVoidTrait(int voidTrait) {
		this.voidTrait = voidTrait;
	}

	public int getVoidTrait() {
		return voidTrait;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

	public String getClan() {
		return clan;
	}

	
}
