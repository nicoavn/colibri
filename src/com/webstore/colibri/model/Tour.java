package com.webstore.colibri.model;

import java.util.ArrayList;

public class Tour {

	public Tour() {

	}

	private ArrayList<TourStop> placesToGo;
	private String tourTitle;
	private TourType[] type;

	public ArrayList<TourStop> getPlacesToGo() {
		return placesToGo;
	}

	public void setPlacesToGo(ArrayList<TourStop> placesToGo) {
		this.placesToGo = placesToGo;
	}

	public String getTourTitle() {
		return tourTitle;
	}

	public void setTourTitle(String tourTitle) {
		this.tourTitle = tourTitle;
	}

	public TourType[] getType() {
		return type;
	}

	public void setType(TourType[] type) {
		this.type = type;
	}

}
