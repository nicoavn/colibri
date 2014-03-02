package com.webstore.colibri.view;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.webstore.colibri.R;
import com.webstore.colibri.model.Tour;
import com.webstore.colibri.model.TourStop;

public class TourRouteDrawer extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GlobalActivityHandlerUtility.tourRouteDrawer = this;

		this.setContentView(R.layout.route_drawer_view_layout);

		this.tour = GlobalActivityHandlerUtility.customTourSetUp.tour;

		if (this.tour != null) {

			map = ((MapFragment) getFragmentManager().findFragmentById(
					R.id.drawer_map)).getMap();

			drawTour(tour);

			setContentView(R.layout.map_view_layout);

		}
	}

	public void drawTour(Tour tour) {
		List<TourStop> list = tour.getPlacesToGo();
		DrawerUtilityClass md = new DrawerUtilityClass();

		Document doc = md.getDocument(list.get(0).getPlace().getLocation(),
				list.get(1).getPlace().getLocation(),
				DrawerUtilityClass.MODE_DRIVING);

		ArrayList<LatLng> directionPoint = md.getDirection(doc);
		PolylineOptions rectLine = new PolylineOptions().width(3).color(
				Color.RED);

		for (int i = 0; i < directionPoint.size(); i++) {
			rectLine.add(directionPoint.get(i));
		}
		Polyline polylin = map.addPolyline(rectLine);

		list.get(1).getPlace().getLocation();
		CameraUpdate center = CameraUpdateFactory.newLatLng(list.get(1)
				.getPlace().getLocation());
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

		map.moveCamera(center);
		map.animateCamera(zoom);

	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public GoogleMap getMap() {
		return map;
	}

	public void setMap(GoogleMap map) {
		this.map = map;
	}

	private Tour tour;
	private GoogleMap map;
}
