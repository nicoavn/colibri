package com.webstore.colibri.model;

import java.util.ArrayList;
import java.util.Date;

public class TourTaken {

	public TourTaken() {

	}

	private int TourTakenId;
	private Tour tour;
	private ArrayList<String> invitedFriends;
	private Date tourDate;

	public Tour getTour() {
		return tour;
	}

	public int getTourTakenId() {
		return TourTakenId;
	}

	public void setTourTakenId(int tourTakenId) {
		TourTakenId = tourTakenId;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public ArrayList<String> getInvitedFriends() {
		return invitedFriends;
	}

	public void setInvitedFriends(ArrayList<String> invitedFriends) {
		this.invitedFriends = invitedFriends;
	}

	public Date getTourDate() {
		return tourDate;
	}

	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}

}
