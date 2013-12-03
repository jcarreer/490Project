package com.joshcarreer.thebreaker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	public static String[] Options = new String[5];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void rockpapersci(View view){
		Intent playerselect = new Intent (this, PlayerSelect.class);
		Options[0] = "0";
		startActivity(playerselect);
	}
	public void dice(View view){
		Intent playerselect = new Intent (this, PlayerSelect.class);
		Options[0] = "1";
		startActivity(playerselect);
	}
	public void randnumber(View view){
		Intent playerselect = new Intent (this, PlayerSelect.class);
		Options[0] = "2";
		startActivity(playerselect);
	}
}


