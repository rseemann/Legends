package Testes;

import static org.junit.Assert.*;

import org.junit.*;

import Ficha.RPGCharacter;

public class RPGCharacterTest {
	RPGCharacter rpgChar = new RPGCharacter();
	
	@Test
	public void testEarthRingWhenWillPowerIsHigher() {
		rpgChar.setStamina(10);
		rpgChar.setWillpower(20);
		rpgChar.calcRings();
		assertEquals(10, rpgChar.getEarthRing());
	}

	@Test
	public void testEarthRingWhenStaminaIsHigher() {
		rpgChar.setStamina(20);
		rpgChar.setWillpower(10);
		rpgChar.calcRings();
		assertEquals(10, rpgChar.getEarthRing());
	}
	
	@Test
	public void testAddSkill(){
		rpgChar.addSkill("Investigation");
		assertEquals(1, rpgChar.getSkillRank("investiGAtion"));
	}
	
	@Test
	public void testAddAnotherSkill(){
		rpgChar.addSkill("Kenjutsu");
		assertEquals(1, rpgChar.getSkillRank("kenjutsu"));
	}
	
	@Test
	public void testKnownSkillsAndRanks(){
		rpgChar.addSkill("Investigation");
		rpgChar.addSkill("Kenjutsu");
		rpgChar.setSkillRank("kenJUtsu", 5);
		System.out.println(rpgChar.getSkills());
		
	}
	


	

}
