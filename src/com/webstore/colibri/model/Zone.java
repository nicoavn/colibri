package com.webstore.colibri.model;

public class Zone extends PlaceLocation {

	private int zoneId;
	private Province parent;
	private String name;

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public Province getParent() {
		return parent;
	}

	public void setParent(Province parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
