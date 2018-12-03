package com.groupSpring.garbageAppSpring.model;

import java.io.Serializable;

public class TotalMaterialRecycling implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String materialname;
	
	private float tons;

	public String getMaterialname() {
		return materialname;
	}

	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}

	public float getTons() {
		return tons;
	}

	public void setTons(float tons) {
		this.tons = tons;
	}
	
}
