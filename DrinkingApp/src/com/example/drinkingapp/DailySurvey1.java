package com.example.drinkingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;

public class DailySurvey1 extends Activity implements OnClickListener {

	Button yes, no;
	String result;
	Intent goToAssessment;
	private DatabaseHandler db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		db = new DatabaseHandler(this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// full screen
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.dailysurvey1);
		yes = (Button) findViewById(R.id.bDS1Yes);
		no = (Button) findViewById(R.id.bDS1No);
		yes.setOnClickListener(this);
		no.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bDS1Yes:
			result = "yes";
			db.addValue("drank_last_night", "True");
			finish();
			break;
		case R.id.bDS1No:
			result = "no";
			db.addValue("drank_last_night", "False");
			finish();
			break;

		}

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
