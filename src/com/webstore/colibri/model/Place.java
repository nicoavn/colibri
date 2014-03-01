package com.webstore.colibri.model;

import android.graphics.Bitmap;

public class Place {

	private int placeId;
	private String name;
	private double latitude;
	private double longitude;
	private Category placeCategory;
	private Bitmap picture;
	private Zone zone;

	public Place() {

	}

	public Place(String placeName, double latitude, double longitude) {
		this.name = placeName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Category getPlaceCategory() {
		return placeCategory;
	}

	public void setPlaceCategory(Category placeCategory) {
		this.placeCategory = placeCategory;
	}

	public Bitmap getPicture() {
		return picture;
	}

	public void setPicture(Bitmap picture) {
		this.picture = picture;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

}
