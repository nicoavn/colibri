package com.webstore.colibri.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.webstore.colibri.R;

public class MainActivity extends Activity {

	private Button showMap;
	private Button buildCustomTour;
	private Intent mapIntent;
	private Intent buildCustomIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		showMap = (Button) findViewById(R.id.show_map);
		showMap.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mapIntent = new Intent(MainActivity.this, GMapActivity.class);
				startActivity(mapIntent);
			}
		});

		buildCustomTour = (Button) findViewById(R.id.build_custom_tour_btn);
		buildCustomTour.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				buildCustomIntent = new Intent(MainActivity.this,
						CustomTourSetUp.class);
				startActivity(buildCustomIntent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
