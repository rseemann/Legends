package Skills;

public class Skill{ //implements SynergyBonus
	private String name;
	private int rank;
	
	public Skill(String name) {
		this.name = name;
		this.rank = 1;
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
	
	public String toString(){
		return this.name+ " "+ this.rank;
	}

}
