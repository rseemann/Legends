package Skills;

import java.io.Serializable;

public class Skill implements Serializable{ //implements SynergyBonus
	private String name;
	private int rank;
	
	public Skill(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
