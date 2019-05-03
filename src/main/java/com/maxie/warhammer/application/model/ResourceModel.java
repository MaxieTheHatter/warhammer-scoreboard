package com.maxie.warhammer.application.model;

public class ResourceModel {
	private String type;
	private int resource;
	
	public ResourceModel() {
		// no args-constructor
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
}
