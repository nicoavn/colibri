package com.webstore.colibri.view;

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

public class CustomTourSetUp extends Activity {

	private Spinner whereSpinner;
	private Button submit;
	private Intent placesPick;
	private EditText zone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_set_up);

		whereSpinner = (Spinner) findViewById(R.id.col_where);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.where_target_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		whereSpinner.setAdapter(adapter);

		final CheckBox cat_all = (CheckBox) findViewById(R.id.col_category_all);
		final CheckBox cat_cultural = (CheckBox) findViewById(R.id.col_category_cultural);
		final CheckBox cat_eco = (CheckBox) findViewById(R.id.col_category_eco);

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

				Log.i("info", whereSpinner.getSelectedItem().toString());

				startActivity(placesPick);
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
}
