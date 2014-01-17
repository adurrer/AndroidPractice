package net.andrewdurrer.userinteractionbasics;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SkyrimHelloWorldFont extends Activity {
	class RenderView extends View {
		Paint paint;
		Typeface font, font2;
		Rect bounds = new Rect();
		
		public RenderView(Context context) {
			super(context);
			paint = new Paint();
			font = Typeface.createFromAsset(context.getAssets(), "Dovahkiin.otf");
			font2 = Typeface.createFromAsset(context.getAssets(), "36daysag.ttf");
		
		}
		
		protected void onDraw(Canvas canvas) {
			canvas.drawRGB(0, 0, 0);
			paint.setColor(Color.GREEN);
			paint.setTypeface(font);
			paint.setTextSize(40);
			paint.setTextAlign(Paint.Align.LEFT);
			canvas.drawText("Hello World!", 50, 100, paint);
			
			
			
			String text = "Hello World in skyrim text";
			paint.setColor(Color.WHITE);
			paint.setTypeface(font2);
			paint.setTextSize(30);
			paint.setTextAlign(Paint.Align.LEFT);
			paint.getTextBounds(text,0, text.length(), bounds);
			canvas.drawText(text, 50, 200, paint);
			invalidate();
			
			
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(new RenderView(this));
	}
}
