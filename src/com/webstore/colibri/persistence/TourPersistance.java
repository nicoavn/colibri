package com.webstore.colibri.persistence;

import java.util.ArrayList;
import java.util.List;

import com.webstore.colibri.model.Tour;

public class TourPersistance {
	private static ArrayList<Tour> persistedTours = new ArrayList<Tour>();

	public static Tour persist(Tour tour) {
		TourPersistance.persistedTours.add(tour);
		return tour;
	}

	public static List<Tour> findAll() {
		return TourPersistance.persistedTours;
	}
}
