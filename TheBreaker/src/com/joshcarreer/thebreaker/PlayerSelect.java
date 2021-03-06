package com.joshcarreer.thebreaker;

import com.joshcarreer.thebreaker.MainActivity;
import com.joshcarreer.thebreaker.R;
import com.joshcarreer.thebreaker.RoundSelect;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PlayerSelect extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_select);
		// Show the Up button in the action bar.
		setupActionBar();
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
		getMenuInflater().inflate(R.menu.player_select, menu);
		return true;
	}

	public void twoplayer(View view){
		MainActivity.Options[1]="2";
		playerselect();
	}
	public void threeplayer(View view){
		MainActivity.Options[1]="3";
		playerselect();
	}
	public void fourplayer(View view){
		MainActivity.Options[1]="4";
		playerselect();
	}
	
	public void playerselect(){
		Intent roundsselect = new Intent (this, RoundSelect.class);
		startActivity(roundsselect);
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

