package com.webstore.colibri.view;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.webstore.colibri.R;
import com.webstore.colibri.model.Category;
import com.webstore.colibri.model.Place;
import com.webstore.colibri.model.Tour;
import com.webstore.colibri.model.TourStop;
import com.webstore.colibri.persistence.TourPersistance;

public class CustomTourSetUp extends Activity {

	private Spinner whereSpinner;
	private Button submit;
	private Intent placesPick;
	private EditText name;
	private EditText zone;
	public ArrayList<Place> choosenPlaces;
	public ArrayList<TourStop> endingStops = new ArrayList<TourStop>();
	public Tour tour;

	public static int MAP_REQUEST = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_set_up);

		GlobalActivityHandlerUtility.customTourSetUp = this;

		whereSpinner = (Spinner) findViewById(R.id.col_where);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.where_target_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		whereSpinner.setAdapter(adapter);

		final CheckBox cat_all = (CheckBox) findViewById(R.id.col_category_all);
		final CheckBox cat_cultural = (CheckBox) findViewById(R.id.col_category_cultural);
		final CheckBox cat_eco = (CheckBox) findViewById(R.id.col_category_eco);

		name = (EditText) findViewById(R.id.tour_title);
		zone = (EditText) findViewById(R.id.col_zone_field);

		submit = (Button) findViewById(R.id.custom_tour_submit);
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				placesPick = new Intent(CustomTourSetUp.this,
						GMapActivity.class);
				if (cat_all.isChecked())
					placesPick.putExtra(Category.ALL.name(), Category.ALL);
				if (cat_cultural.isChecked())
					placesPick.putExtra(Category.CULTURAL.name(),
							Category.CULTURAL);
				if (cat_eco.isChecked())
					placesPick.putExtra(Category.ECOLOGICAL.name(),
							Category.ECOLOGICAL);

				if (whereSpinner.isSelected()) {
					placesPick.putExtra("where", whereSpinner.getSelectedItem()
							.toString());
				}

				if (zone.getText().toString().length() > 0) {
					placesPick.putExtra("zone", zone.getText().toString());
				}

				startActivityForResult(placesPick, MAP_REQUEST);
			}
		});

		cat_all.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		cat_cultural.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		cat_eco.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		Log.d("RequestCode:", "" + requestCode);
		Log.d("MAP_REQUEST:", "" + MAP_REQUEST);

		TourStop tempTourStop;

		if (resultCode == RESULT_OK) {
			if (requestCode == MAP_REQUEST) {
				ArrayList<Place> places = this.choosenPlaces;
				if (places != null) {
					int counter = 1;
					for (Place p : places) {
						tempTourStop = new TourStop();
						tempTourStop.setPlace(p);
						tempTourStop.setSecuence(counter);
						endingStops.add(tempTourStop);
						counter++;
					}
					tour.setPlacesToGo(endingStops);
					tour.setTourTitle(name.getText().toString());
					TourPersistance.persist(tour);
				}

			}
		}
	}
}
