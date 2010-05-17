package Skills;

import Ficha.Skill;
import Interfaces.SynergyBonus;

public abstract class Investigation extends Skill implements SynergyBonus{
	
	public void createSkill(){
		this.setName("Investigation");
		this.addEmphasis("Interrogation");
		this.addEmphasis("Search");
		this.addEmphasis("Notice");
	}
	
	
	
	@Override
	public void SynerGyDescription() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSynergyBonusToSkill(Skill targetSkill) {
		// TODO Auto-generated method stub
		
	}
	
}
