package com.joshcarreer.thebreaker;

import java.util.Random;

import com.joshcarreer.thebreaker.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class CoinToss extends Activity {


	// Set max number of wins to victory
	int rounds = Integer.valueOf(MainActivity.Options[2]);

	int p1wins = 0;
	int p2wins = 0;
	String coinchoice;
	String coinoutcome;
	Random random1 = new Random();
	int rand1;
	
	Button round;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coin_toss);
		// Show the Up button in the action bar.
		setupActionBar();
		
		TextView coinchoiceview = new TextView(this);
		coinchoiceview = (TextView) findViewById(R.id.player1choice);
		if (MainActivity.Options[3]=="0"){
			coinchoice = "Heads";
		}else coinchoice = "Tails";
		coinchoiceview.setText(coinchoice);
		
		round = (Button) findViewById(R.id.button_round);
		round.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (p1wins == rounds) {
					MainActivity.Options[4] = "0";
					victory();
				} else if (p2wins == rounds) {
					MainActivity.Options[4] = "1";
					victory();
				}else round();
			}
		});
	}

	public void round() {

		// Make Random numbers for 2 players
		rand1 = random1.nextInt(2 - 0);
		if(rand1==0){
			coinoutcome = "Heads";
		}else coinoutcome = "Tails";
		
		checkwin();
	}

	public void checkwin() {

		if (rand1 == Integer.valueOf(MainActivity.Options[3])) {
			p1wins += 1;
		} else p2wins += 1;

		updateView();
	}

	public void updateView() {
		TextView tvp1wins = new TextView(this);
		tvp1wins = (TextView) findViewById(R.id.player1wins);
		TextView tvp2wins = new TextView(this);
		tvp2wins = (TextView) findViewById(R.id.player2wins);
		TextView coinoutcomeview = new TextView(this);
		coinoutcomeview = (TextView) findViewById(R.id.outcome);
		tvp1wins.setText("" + p1wins);
		tvp2wins.setText("" + p2wins);
		coinoutcomeview.setText(coinoutcome);


		

	}

	public void victory(){
		// Make Victory Instance
				Intent govictory = new Intent(this, VictoryScreen.class);
				startActivity(govictory);
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
		getMenuInflater().inflate(R.menu.coin_toss, menu);
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
