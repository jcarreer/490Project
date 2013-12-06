package com.joshcarreer.thebreaker;

import com.joshcarreer.thebreaker.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class RoundSelect extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rounds_select);
		// Show the Up button in the action bar.
		setupActionBar();	
		
	}
	
	public void round1(View view){
		MainActivity.Options[2]="1";
		opennextactivity();
	}
	public void round2(View view){
		MainActivity.Options[2]="2";
		opennextactivity();
	}
	public void round3(View view){
		MainActivity.Options[2]="3";
		opennextactivity();
	}
	public void round4(View view){
		MainActivity.Options[2]="4";
		opennextactivity();
	}
	public void opennextactivity(){
		Intent rockpapersci = new Intent (this, RockPaperSci.class);
		Intent dieselect = new Intent (this, DieSelect.class);
		Intent randnumber = new Intent (this, RandNumber.class);
		Intent cointossselect = new Intent (this, CoinTossSelect.class);
		int activity;
		activity = Integer.parseInt(MainActivity.Options[0]);
		if(activity == 0){
			startActivity(rockpapersci);}
		else
		if(activity == 1){
			startActivity(dieselect);}
		else
		if(activity == 2){
			startActivity(randnumber);}
		else
		if(activity == 3){
		startActivity(cointossselect);}

	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rounds_select, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
