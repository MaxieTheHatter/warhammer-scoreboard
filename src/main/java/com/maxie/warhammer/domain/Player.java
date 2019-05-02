package com.maxie.warhammer.domain;

public class Player {
	
	private String name;
	private String army;
	private int score;
	private ArmyResource armyResource;
	
	private Player() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArmy() {
		return army;
	}

	public void setArmy(String army) {
		this.army = army;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArmyResource getArmyResource() {
		return armyResource;
	}

	public void setArmyResource(ArmyResource armyResource) {
		this.armyResource = armyResource;
	}

	public static class Builder {
		private String name;
		private String army;
		private int score;
		
		public Builder(String name) {
			this.name = name;
		}
		
		public Builder army(String army) {
			this.army = army;
			return this;
		}
		
		public Builder score(int score) {
			this.score = score;
			return this;
		}
		
		
		public Player build() {
			Player player = new Player();
			player.setName(this.name);
			player.setArmy(this.army);
			player.setScore(this.score);
			return player;
		}
		
	}
	
}
