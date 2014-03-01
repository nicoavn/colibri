package com.webstore.colibri.model;

public class TourStop {

	public TourStop() {

	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public int getSecuence() {
		return secuence;
	}

	public void setSecuence(int secuence) {
		this.secuence = secuence;
	}

	private Place place;
	private int secuence;
}
