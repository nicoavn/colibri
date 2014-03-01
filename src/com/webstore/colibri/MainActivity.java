package com.webstore.colibri;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button showMap;
	Intent mapIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		showMap = (Button) findViewById(R.id.showMap);
		showMap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mapIntent = new Intent(MainActivity.this, GMapActivity.class);
				startActivity(mapIntent);
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
