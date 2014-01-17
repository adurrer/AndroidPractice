package net.andrewdurrer.userinteractionbasics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class DrawShapes extends Activity {
	class RenderView extends View {
		Paint paint;
		
		public RenderView(Context context) {
			super(context);
			paint = new Paint();
		}
		
		protected void onDraw(Canvas canvas) {
			canvas.drawRGB(240, 235, 200);
			paint.setColor(Color.BLUE);
			canvas.drawLine(0, 0, canvas.getWidth() - 1, canvas.getHeight() - 1, paint);
			
			paint.setStyle(Style.STROKE);
			paint.setColor(0xff005300);
			canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 50, paint);
			
			paint.setStyle(Style.FILL);
			paint.setColor(Color.GREEN);
			canvas.drawRect(100, 100, 200, 200, paint);
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
