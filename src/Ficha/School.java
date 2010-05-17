package Ficha;

import java.util.ArrayList;

import Skills.Skill;

abstract class School implements SchoolTechniques{
	private String name;
	private String benefit;
	private int benefitBonus;
	private ArrayList<Skill> schoolSkill;
	private double honor;
	private String outfit;
	private String special;
	
}

interface SchoolTechniques{
	public void rank1();
	public void rank2();
	public void rank3();
	public void rank4();
	public void rank5();
}