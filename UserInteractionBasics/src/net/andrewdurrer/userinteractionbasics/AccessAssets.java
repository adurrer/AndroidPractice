package net.andrewdurrer.userinteractionbasics;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccessAssets extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		
		AssetManager assetManager = getAssets();
		InputStream is = null;
		try{
			is = assetManager.open("textietexttext.txt");
			String text = loadTextFile(is);
			textView.setText(text);
		} catch (IOException e) {
			textView.setText("Could not load text file");
		} finally {
			if( is != null){
				try {
					is.close();
				} catch (IOException ee){
					textView.setText("Could not close the text file");
				}
			}
		}
	}
	
	public String loadTextFile(InputStream is) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		byte[] bytes = new byte[4096];
		int len = 0;
		while((len = is.read(bytes)) > 0)
			byteStream.write(bytes, 0 , len);
		return new String(byteStream.toByteArray(), "UTF8");
	}
}
