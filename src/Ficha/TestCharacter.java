package Ficha;

import junit.framework.TestCase;

import org.junit.Test;

public class TestCharacter extends TestCase {
	@Test
	public void characterCanHaveAName() {
		RPGCharacter character = new RPGCharacter();
		character.setName("Finha");
		assertEquals("Finha", character.getName());
	}

}
