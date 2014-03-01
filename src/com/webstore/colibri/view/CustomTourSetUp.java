package com.webstore.colibri.view;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.webstore.colibri.R;
import com.webstore.colibri.model.Category;

public class CustomTourSetUp extends Activity {

	private Spinner whereSpinner;
	private Button submit;
	private Intent placesPick;

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

		CheckBox cat_all = (CheckBox) findViewById(R.id.col_category_all);
		CheckBox cat_cultural = (CheckBox) findViewById(R.id.col_category_cultural);
		CheckBox cat_echo = (CheckBox) findViewById(R.id.col_category_eco);

		submit = (Button) findViewById(R.id.custom_tour_submit);
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				ArrayList<Category> choosenCategories = new ArrayList<Category>();
				data.putExtra("Categories", choosenCategories);

				placesPick = new Intent(CustomTourSetUp.this,
						GMapActivity.class);
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

		cat_echo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}
}
