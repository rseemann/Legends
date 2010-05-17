package Skills;

import java.util.ArrayList;

public abstract class BaseSkill {
	private String name;
	private int rank;
	private ArrayList<String> emphasis;
	private ArrayList<String> masteryAbility;

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

	public void addEmphasis(String emphasis) {
		this.emphasis.add("emphasis");
	}

	public ArrayList<String> getEmphasis() {
		return emphasis;
	}
}
