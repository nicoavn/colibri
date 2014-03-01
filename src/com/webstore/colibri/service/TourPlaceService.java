package com.webstore.colibri.service;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;
import com.webstore.colibri.model.Category;
import com.webstore.colibri.model.Place;
import com.webstore.colibri.model.PlaceLocation;

public class TourPlaceService {

	public static ArrayList<Place> getPlacesByCategories(
			ArrayList<Category> categories, int max, PlaceLocation[] pl) {
		ArrayList<Place> placesToReturn = new ArrayList<Place>();

		if (pl != null) {
			// Filter by location
		}

		placesToReturn.add(new Place("Fortaleza", new LatLng(19.4481,
				-70.702993)));
		placesToReturn.add(new Place("Parque Colón", new LatLng(19.450083,
				-70.699861)));
		placesToReturn.add(new Place("Monumento Natural Pico Diego de Ocampo",
				new LatLng(19.575156, -70.774468)));

		return placesToReturn;
	}

}
