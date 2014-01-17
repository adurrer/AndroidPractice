package net.andrewdurrer.userinteractionbasics;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class RenderPlanetBitmap extends Activity {
	class RenderView extends View {
		Bitmap bigPlanet;
		Bitmap smallPlanet;
		Rect dst = new Rect();
		
		public RenderView(Context context) {
			super(context);
			
			try {
				AssetManager AM = context.getAssets();
				InputStream is = AM.open("quom_400.jpg");
				bigPlanet = BitmapFactory.decodeStream(is);
				is.close();
				Log.d("BitMapText", "quom_400.jpg format: " + bigPlanet.getConfig());
				
				is = AM.open("quom_400.jpg");
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inPreferredConfig = Bitmap.Config.ARGB_4444;
				smallPlanet = BitmapFactory.decodeStream(is,null,options);
				is.close();
				Log.d("BitmapText", "quom_400.jpg format: " + smallPlanet.getConfig());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		protected void onDraw(Canvas canvas) {
			canvas.drawRGB(0, 0, 0);
			dst.set(50,50,350,350);
			canvas.drawBitmap(bigPlanet, null, dst, null);
			canvas.drawBitmap(smallPlanet, 300, 100, null);
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
