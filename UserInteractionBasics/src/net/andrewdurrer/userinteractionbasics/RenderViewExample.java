package net.andrewdurrer.userinteractionbasics;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class RenderViewExample extends Activity {
	class RenderView extends View {
		Random rand = new Random();
		
		public RenderView(Context context){
			super(context);
		}
		
		protected void onDraw(Canvas canvas) {
			canvas.drawRGB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			invalidate();
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(new RenderView(this));
	}
}
