package com.webstore.colibri.view;

import java.util.ArrayList;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.webstore.colibri.R;
import com.webstore.colibri.model.Category;
import com.webstore.colibri.model.Place;
import com.webstore.colibri.model.PlaceLocation;
import com.webstore.colibri.model.Region;
import com.webstore.colibri.model.Zone;
import com.webstore.colibri.service.TourPlaceService;

public class GMapActivity extends FragmentActivity {

	private GoogleMap map;
	private final ArrayList<Category> choosenCategories = new ArrayList<Category>();
	Intent intent;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.map_view_layout);

		intent = getIntent();

		Category tempCategory;

		// "Categories"
		for (Category c : Category.values()) {
			tempCategory = (Category) intent.getSerializableExtra(c.name());
			if (tempCategory != null) {
				choosenCategories.add(tempCategory);
			}
		}

		// "Where"
		String where = intent.getStringExtra("where");

		// "Zone"
		String zone = intent.getStringExtra("zone");

		Place p = new Place();

		p.setLatitude(19.455869);
		p.setLongitude(-70.707113);

		p.setName(where);

		Region r = new Region();

		Zone z = new Zone();

		z.setName(zone);

		PlaceLocation[] pl = { r, z };

		ArrayList<Place> places = TourPlaceService.getPlacesByCategories(
				choosenCategories, 3, pl);

		map = ((MapFragment) getFragmentManager()
				.findFragmentById(R.id.the_map)).getMap();

		if (map != null) {
			Log.i("MapTag", "Map Cool");
			focusMap(null);
		} else {
			Log.e("MapTag", "Null Map");
		}

		map.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker marker) {

				return false;
			}
		});

		// Criteria criteria = new Criteria();
		// LocationManager locationManager = (LocationManager)
		// getSystemService(Context.LOCATION_SERVICE);
		// String provider = locationManager.getBestProvider(criteria, false);
		// Location location = locationManager.getLastKnownLocation(provider);
		// double lat = location.getLatitude();
		// double lng = location.getLongitude();
		// LatLng coordinate = new LatLng(lat, lng);

	}

	private void focusMap(Location[] locations) {

		CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(p
				.getLatitude(), p.getLongitude()));
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

		map.moveCamera(center);
		map.animateCamera(zoom);

		ArrayList<Marker> places = new ArrayList<Marker>();

		places.add(map.addMarker(new MarkerOptions().position(
				new LatLng(19.450892, -70.694625)).title(
				"Monumento a los Héroes de la Restauración")));

		places.add(map.addMarker(new MarkerOptions().position(
				new LatLng(19.442354, -70.68248)).title("PCUMM")));

		places.add(map.addMarker(new MarkerOptions().position(
				new LatLng(19.445672, -70.714066))
				.title("Las Aromas Golf Club")));
	}
}
