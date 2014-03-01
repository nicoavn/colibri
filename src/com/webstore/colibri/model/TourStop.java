package com.webstore.colibri.model;

public class TourStop {

	public TourStop() {

	}

	public int getTourStopId() {
		return TourStopId;
	}

	public void setTourStopId(int tourStopId) {
		TourStopId = tourStopId;
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

	private int TourStopId;
	private Place place;
	private int secuence;
}
