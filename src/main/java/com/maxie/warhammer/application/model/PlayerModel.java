package com.maxie.warhammer.application.model;

import com.maxie.warhammer.domain.ArmyResource;

public class PlayerModel {
	private String name;
	private String army;
	private int score;
	private ArmyResource resource;
	
	public PlayerModel() {
		// no args-constructor
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

	public ArmyResource getResource() {
		return resource;
	}

	public void setResource(ArmyResource resource) {
		this.resource = resource;
	}
}
