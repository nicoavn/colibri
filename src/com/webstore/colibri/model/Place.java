package com.webstore.colibri.model;

import android.graphics.Bitmap;

import com.google.android.gms.maps.model.LatLng;

public class Place {

	private int placeId;
	private String name;
	private LatLng location;
	private Category placeCategory;
	private Bitmap picture;

	public Place() {

	}

	public Place(String placeName, LatLng location) {
		this.name = placeName;
		this.location = location;
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

	public LatLng getLocation() {
		return location;
	}

	public void setLocation(LatLng location) {
		this.location = location;
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

}
