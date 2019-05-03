package com.maxie.warhammer.domain;

public class ArmyResource {
	private String type;
	private int resource;
	
	private ArmyResource() {
		
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getResource() {
		return resource;
	}

	public void setResource(int resource) {
		this.resource = resource;
	}
	
	public static class Builder {
		private String type;
		private int resource;
		
		public Builder(String type) {
			this.type = type;
		}
		
		
		public Builder resource(int resource) {
			this.resource = resource;
			return this;
		}
		
		public ArmyResource build() {
			ArmyResource armyResource = new ArmyResource();
			armyResource.setType(this.type);
			armyResource.setResource(this.resource);
			return armyResource;
		}
	}

}
