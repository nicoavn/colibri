package com.webstore.colibri.view;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.webstore.colibri.R;
import com.webstore.colibri.model.Tour;
import com.webstore.colibri.model.TourStop;

public class TourRouteDrawer extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GlobalActivityHandlerUtility.tourRouteDrawer = this;

		this.setContentView(R.layout.route_drawer_view_layout);

		CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(
				19.493077, -70.697199));
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);

		map = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.drawer_map)).getMap();

		Marker startPoint = map.addMarker(new MarkerOptions().position(
				new LatLng(19.456395, -70.709887)).title("Start Point"));
		startPoint.setIcon(BitmapDescriptorFactory
				.fromResource(R.drawable.flagblue));

		Marker endPoint = map.addMarker(new MarkerOptions().position(
				new LatLng(19.447979, -70.702951)).title("End Point"));
		endPoint.setIcon(BitmapDescriptorFactory
				.fromResource(R.drawable.flagend));

		Marker placeOne = map.addMarker(new MarkerOptions().position(
				new LatLng(19.452531, -70.703719)).title(
				"Monumento de los Héroes"));
		placeOne.setIcon(BitmapDescriptorFactory
				.fromResource(R.drawable.flaggreen));

		map.animateCamera(zoom);
		map.moveCamera(center);
		map.animateCamera(zoom);
		map.moveCamera(center);

		this.tour = GlobalActivityHandlerUtility.customTourSetUp.tour;

		if (this.tour != null) {

			// drawTour(tour);

		}
	}

	public void drawTour(Tour tour) {
		List<TourStop> list = tour.getPlacesToGo();

		Log.i("INFO!", list.get(0).getPlace().getLocation().toString());
		Log.i("INFO!", list.get(1).getPlace().getLocation().toString());

		list.get(1).getPlace().getLocation();
		CameraUpdate center = CameraUpdateFactory.newLatLng(list.get(1)
				.getPlace().getLocation());
		// CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

		// map.moveCamera(center);
		// map.animateCamera(zoom);
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
