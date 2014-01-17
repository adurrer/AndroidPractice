package net.andrewdurrer.userinteractionbasics;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AndroidLifeCycle extends Activity {
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	public void log(String text) {
		Log.d("LifeCycleTest", text);
		builder.append(text);
		builder.append('\n');
		textView.setText(builder.toString());
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText(builder.toString());
		setContentView(textView);
		log("created");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		log("resume");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		log("paused");
		
		if(isFinishing()) {
			log("finishing");
		}
	}
}
