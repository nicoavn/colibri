package com.webstore.colibri.view;

import java.util.ArrayList;

import android.content.Intent;
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

public class GMapActivity extends FragmentActivity {

	private GoogleMap map;
	private ArrayList<Category> choosenCategories;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.map_view_layout);

		// "Categories"

		Intent intent = getIntent();
		intent.getSerializableExtra("Categories");

		map = ((MapFragment) getFragmentManager()
				.findFragmentById(R.id.the_map)).getMap();

		if (map != null) {
			Log.i("iinfoo", "MapNOTNULL");
			CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(
					19.455869, -70.707113));
			CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

			map.moveCamera(center);
			map.animateCamera(zoom);
		} else {
			Log.e("iinfoo", "NULLLLLLL MAP");
		}

		ArrayList<Marker> places = new ArrayList<Marker>();

		places.add(map.addMarker(new MarkerOptions().position(
				new LatLng(19.450892, -70.694625)).title(
				"Monumento a los Héroes de la Restauración")));

		places.add(map.addMarker(new MarkerOptions().position(
				new LatLng(19.442354, -70.68248)).title("PCUMM")));

		places.add(map.addMarker(new MarkerOptions().position(
				new LatLng(19.445672, -70.714066))
				.title("Las Aromas Golf Club")));

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
}
