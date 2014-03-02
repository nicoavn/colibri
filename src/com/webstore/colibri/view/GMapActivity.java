package com.webstore.colibri.view;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.webstore.colibri.R;
import com.webstore.colibri.model.Category;
import com.webstore.colibri.model.Place;

public class GMapActivity extends FragmentActivity {

	private GoogleMap map;
	private final ArrayList<Category> choosenCategories = new ArrayList<Category>();
	private final ArrayList<Marker> selectedMarkers = new ArrayList<Marker>();
	private Button finishBtn;
	Intent intent;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		GlobalActivityHandlerUtility.gMapActivity = this;
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
		// String where = intent.getStringExtra("where");

		// "Zone"
		// String zone = intent.getStringExtra("zone");

		// Place p = new Place();
		//
		// p.setLatitude(19.455869);
		// p.setLongitude(-70.707113);
		//
		// p.setName(where);

		// Region r = new Region();
		//
		// Zone z = new Zone();
		//
		// z.setName(zone);

		// PlaceLocation[] pl = { r, z };

		// ArrayList<Place> places = TourPlaceService.getPlacesByCategories(
		// choosenCategories, 3, null);

		map = ((MapFragment) getFragmentManager()
				.findFragmentById(R.id.the_map)).getMap();

		if (map != null) {
			Log.i("MapTag", "Map Cool");
			addMarkers(map, new ArrayList<Marker>());
			focusMap(new LatLng(19.455869, -70.707113), 15);
		} else {
			Log.e("MapTag", "Null Map");
		}

		map.setOnMarkerClickListener(new OnMarkerClickListener() {
			@Override
			public boolean onMarkerClick(Marker marker) {
				if (selectedMarkers.contains(marker)) {
					selectedMarkers.remove(marker);
					marker.setIcon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
				} else {
					selectedMarkers.add(marker);
					marker.setIcon(BitmapDescriptorFactory
							.fromResource(R.drawable.greenmarker));
				}
				return false;
			}
		});

		finishBtn = (Button) findViewById(R.id.map_done_btn);
		finishBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ArrayList<Place> resultingPlaces = new ArrayList<Place>();

				Place tempPlace;

				for (Marker m : selectedMarkers) {
					tempPlace = new Place();
					tempPlace.setLocation(m.getPosition());
					tempPlace.setName(m.getTitle());

					resultingPlaces.add(tempPlace);
				}

				setResult(RESULT_OK);

				GlobalActivityHandlerUtility.customTourSetUp.choosenPlaces = resultingPlaces;

				finish();
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

	private void focusMap(LatLng focusTarget, int zoomLevel) {

		CameraUpdate center = CameraUpdateFactory.newLatLng(focusTarget);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(zoomLevel);

		map.moveCamera(center);
		map.animateCamera(zoom);
	}

	private void addMarkers(GoogleMap map, ArrayList<Marker> places) {

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
