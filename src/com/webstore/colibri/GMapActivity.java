package com.webstore.colibri;

import android.os.Bundle;

import com.google.android.maps.MapActivity;

public class GMapActivity extends MapActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.map_view_layout);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
