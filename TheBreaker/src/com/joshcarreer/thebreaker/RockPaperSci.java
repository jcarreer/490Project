package com.joshcarreer.thebreaker;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.joshcarreer.thebreaker.MainActivity;
import com.joshcarreer.thebreaker.R;

public class RockPaperSci extends Activity {

	// Set max number of wins to victory
	int rounds = Integer.valueOf(MainActivity.Options[2]);

	// Declare number of players
	int playernumber = Integer.valueOf(MainActivity.Options[1]);



	int p1wins = 0;
	int p2wins = 0;
	int p3wins = 0;
	int p4wins = 0;
	String p1res;
	String p2res;
	String p3res;
	String p4res;

	Random random1 = new Random();
	Random random2 = new Random();
	Random random3 = new Random();
	Random random4 = new Random();
	int rand1;
	int rand2;
	int rand3;
	int rand4;

	Button round;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rock_paper_sci);
		// Show the Up button in the action bar.
		setupActionBar();
		

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
				} else if (p3wins == rounds) {
					MainActivity.Options[4] = "2";
					victory();
				} else if (p4wins == rounds) {
					MainActivity.Options[4] = "3";
					victory();
				}else round();
			}
		});
	}
	public void round() {

		// Make Random numbers for 4 players
		rand1 = random1.nextInt(3 - 0);
		rand2 = random2.nextInt(3 - 0);
		rand3 = random3.nextInt(3 - 0);
		rand4 = random4.nextInt(3 - 0);
		checkwin();
	}

	public void checkwin() {

		// Turn off non-players
		if (playernumber == 4) {
		} else if (playernumber == 2) {
			rand3 = 4;
			rand4 = 4;
		} else if (playernumber == 3) {
			rand4 = 4;
		}

		if (rand1 == 0 && rand2 == 2 && (rand3 == 2 || rand3 == 4)
				&& (rand4 == 2 || rand4 == 4)) {
			p1wins += 1;
			p1res = "Rock";
			p2res = "Scissors";
			p3res = "Scissors";
			p4res = "Scissors";
		} else if (rand2 == 0 && rand1 == 2 && (rand3 == 2 || rand3 == 4)
				&& (rand4 == 2 || rand4 == 4)) {
			p2wins += 1;
			p2res = "Rock";
			p1res = "Scissors";
			p3res = "Scissors";
			p4res = "Scissors";
		} else if (rand3 == 0 && rand2 == 2 && rand1 == 2
				&& (rand4 == 2 || rand4 == 4)) {
			p3wins += 1;
			p3res = "Rock";
			p2res = "Scissors";
			p1res = "Scissors";
			p4res = "Scissors";
		} else if (rand4 == 0 && rand2 == 2 && (rand3 == 2 || rand3 == 4)
				&& rand1 == 2) {
			p4wins += 1;
			p4res = "Rock";
			p2res = "Scissors";
			p3res = "Scissors";
			p1res = "Scissors";
		} else if (rand1 == 1 && rand2 == 0 && (rand3 == 0 || rand3 == 4)
				&& (rand4 == 0 || rand4 == 4)) {
			p1wins += 1;
			p1res = "Paper";
			p2res = "Rock";
			p3res = "Rock";
			p4res = "Rock";
		} else if (rand2 == 1 && rand1 == 0 && (rand3 == 0 || rand3 == 4)
				&& (rand4 == 0 || rand4 == 4)) {
			p2wins += 1;
			p2res = "Paper";
			p1res = "Rock";
			p3res = "Rock";
			p4res = "Rock";
		} else if (rand3 == 1 && rand2 == 0 && rand1 == 0
				&& (rand4 == 0 || rand4 == 4)) {
			p3wins += 1;
			p3res = "Paper";
			p2res = "Rock";
			p1res = "Rock";
			p4res = "Rock";
		} else if (rand4 == 1 && rand2 == 0 && (rand3 == 0 || rand3 == 4)
				&& rand1 == 0) {
			p4wins += 1;
			p4res = "Paper";
			p2res = "Rock";
			p3res = "Rock";
			p1res = "Rock";
		} else if (rand1 == 2 && rand2 == 1 && (rand3 == 1 || rand3 == 4)
				&& (rand4 == 1 || rand4 == 4)) {
			p1wins += 1;
			p1res = "Scissors";
			p2res = "Paper";
			p3res = "Paper";
			p4res = "Paper";
		} else if (rand2 == 2 && rand1 == 1 && (rand3 == 1 || rand3 == 4)
				&& (rand4 == 1 || rand4 == 4)) {
			p2wins += 1;
			p2res = "Scissors";
			p1res = "Paper";
			p3res = "Paper";
			p4res = "Paper";
		} else if (rand3 == 2 && rand2 == 1 && rand1 == 1
				&& (rand4 == 1 || rand4 == 4)) {
			p3wins += 1;
			p3res = "Scissors";
			p2res = "Paper";
			p1res = "Paper";
			p4res = "Paper";
		} else if (rand4 == 2 && rand2 == 1 && (rand3 == 1 || rand3 == 4)
				&& rand1 == 1) {
			p4wins += 1;
			p4res = "Scissors";
			p2res = "Paper";
			p3res = "Paper";
			p1res = "Paper";
		} else
			//round(findViewById(R.id.button_round_rps));
			round();

		// Declare Non-Players
		if (playernumber == 2) {
			p3res = "Not Playing";
			p4res = "Not Playing";
			updateView();
			
		} else if (playernumber == 3) {
			p4res = "Not Playing";
			updateView();
		} else updateView();
	}

	public void updateView() {
		TextView tvp1wins = new TextView(this);
		tvp1wins = (TextView) findViewById(R.id.player1wins);
		TextView tvp2wins = new TextView(this);
		tvp2wins = (TextView) findViewById(R.id.player2wins);
		TextView tvp3wins = new TextView(this);
		tvp3wins = (TextView) findViewById(R.id.player3wins);
		TextView tvp4wins = new TextView(this);
		tvp4wins = (TextView) findViewById(R.id.player4wins);
		TextView tvp1res = new TextView(this);
		tvp1res = (TextView) findViewById(R.id.player1result);
		TextView tvp2res = new TextView(this);
		tvp2res = (TextView) findViewById(R.id.player2result);
		TextView tvp3res = new TextView(this);
		tvp3res = (TextView) findViewById(R.id.player3result);
		TextView tvp4res = new TextView(this);
		tvp4res = (TextView) findViewById(R.id.player4result);

		tvp1wins.setText("" + p1wins);
		tvp2wins.setText("" + p2wins);
		tvp3wins.setText("" + p3wins);
		tvp4wins.setText("" + p4wins);
		tvp1res.setText(p1res);
		tvp2res.setText(p2res);
		tvp3res.setText(p3res);
		tvp4res.setText(p4res);

		

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
		getMenuInflater().inflate(R.menu.rock_paper_sci, menu);
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