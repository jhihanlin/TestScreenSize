package com.myExample.testScreenSize.activity;

import com.myExample.testScreenSize.utils.ResolutionConvertor;
import com.myExample.testScreenSize.utils.ScreenSizeHelper;
import com.myExample.testScreenSize.utils.ScreenSizeHelper.ScreenSize;
import com.myexcample.testscreensize.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ScreenSize screenSize = ScreenSizeHelper.getScreenSize(this);
		int heightPixels = screenSize.heightPixels;
		Log.d("debug", "height:" + heightPixels);
		int widthPixels = screenSize.widthPixels;
		Log.d("debug", "width:" + widthPixels);

		int dpi = ResolutionConvertor.getResolution(this);
		Log.d("debug", "dpi:" + dpi);
		int heightDip = ResolutionConvertor.changePixelToDip(heightPixels, dpi);
		Log.d("debug", "heightDip:" + heightDip);
		int widthDip = ResolutionConvertor.changePixelToDip(widthPixels, dpi);
		Log.d("debug", "widthDip:" + widthDip);

		TextView showHeightPixel = (TextView) findViewById(R.id.showHeightPixel);
		TextView showWidthPixel = (TextView) findViewById(R.id.showWidthPixel);
		TextView showHeightDip = (TextView) findViewById(R.id.showHeightDip);
		TextView showWidthDip = (TextView) findViewById(R.id.showWidthDip);
		showHeightPixel.setText("Height: " + heightPixels + "(px)\t");
		showWidthPixel.setText("Width: " + widthPixels + "(px)\t");
		showHeightDip.setText("Height: " + heightDip + "(dp)\t");
		showWidthDip.setText("Width: " + widthDip + "(dp)\t");
		
		int changedHeightPixel = ResolutionConvertor.ChangeDipToPixel(this, heightDip);
		int changedWidthPixel = ResolutionConvertor.ChangeDipToPixel(this, widthDip);

		TextView HeightDipToPixel = (TextView) findViewById(R.id.HeightDipToPixel);
		TextView WidthDipToPixel = (TextView) findViewById(R.id.WidthDipToPixel);

		HeightDipToPixel.setText("Height Dip convert to Pixel: " + changedHeightPixel + "(px)\t");
		WidthDipToPixel.setText("Width Dip convert to Pixel: " + changedWidthPixel + "(px)\t");

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		updateSizeInfo();

	}

	private void updateSizeInfo() {
		ScreenSize screenSize2 = ScreenSizeHelper.getScreenSize2(this);
		int heightPixels2 = screenSize2.heightPixels;
		Log.d("debug", "height2:" + heightPixels2);
		int widthPixels2 = screenSize2.widthPixels;
		Log.d("debug", "width2:" + widthPixels2);
	}
}