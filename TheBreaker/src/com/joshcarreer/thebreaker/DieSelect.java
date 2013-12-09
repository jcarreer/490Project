package com.joshcarreer.thebreaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.joshcarreer.thebreaker.R;

public class DieSelect extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_die_select);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	public void die4(View view){
		Intent diceroll = new Intent (this, DiceRoll.class);
		MainActivity.Options[3] = "0";
		startActivity(diceroll);
	}
	public void die6(View view){
		Intent diceroll = new Intent (this, DiceRoll.class);
		MainActivity.Options[3] = "1";
		startActivity(diceroll);
	}
	public void die12(View view){
		Intent diceroll = new Intent (this, DiceRoll.class);
		MainActivity.Options[3] = "2";
		startActivity(diceroll);
	}
	public void die20(View view){
		Intent diceroll = new Intent (this, DiceRoll.class);
		MainActivity.Options[3] = "3";
		startActivity(diceroll);
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.die_select, menu);
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
