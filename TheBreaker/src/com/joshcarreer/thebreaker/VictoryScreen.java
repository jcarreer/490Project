package com.joshcarreer.thebreaker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.joshcarreer.thebreaker.R;

public class VictoryScreen extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_victory_screen);
		// Show the Up button in the action bar.
		setupActionBar();
		String activity, winner;
		if(MainActivity.Options[4] == "0"){
			winner = "Player 1";
		}else if(MainActivity.Options[4] == "1"){
			winner = "Player 2";
		}else if(MainActivity.Options[4] == "2"){
			winner = "Player 3";
		}else winner = "Player 4";
		
		if(MainActivity.Options[0]=="0"){
			activity = "Rock Paper Scissors";
		}else if(MainActivity.Options[0]=="1"){
			activity = "Dice Roll";
		}else if(MainActivity.Options[0]=="2"){
			activity = "Random Number";
		}else activity = "Coin Flip";
		
		TextView victoryp = new TextView(this);
		victoryp = (TextView) findViewById(R.id.victoryplayer);
		victoryp.setText(winner + " wins the");
		
		TextView victorya = new TextView(this);
		victorya = (TextView) findViewById(R.id.victoryactivity);
		victorya.setText(activity + " challenge!");
		
		
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
		getMenuInflater().inflate(R.menu.victory_screen, menu);
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