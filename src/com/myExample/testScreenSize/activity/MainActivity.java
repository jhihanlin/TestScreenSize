package com.myExample.testScreenSize.activity;

import com.myExample.testScreenSize.utils.ResolutionConvertor;
import com.myExample.testScreenSize.utils.ScreenSizeHelper;
import com.myExample.testScreenSize.utils.ScreenSizeHelper.ScreenSize;
import com.myexcample.testscreensize.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

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