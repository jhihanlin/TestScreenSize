package com.myExample.testScreenSize.activity;

import com.myExample.testScreenSize.utils.ScreenSizeHelper;
import com.myExample.testScreenSize.utils.ScreenSizeHelper.ScreenSize;
import com.myexcample.testscreensize.R;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ScreenSize screenSize = ScreenSizeHelper.getScreenSize(this);
		int height = screenSize.heightPixels;
		Log.d("debug", "height:" + height);
		int width = screenSize.widthPixels;
		Log.d("debug", "width:" + width);

		ScreenSize screenSize2 = ScreenSizeHelper.getScreenSize2(this);
		int height2 = screenSize.heightPixels;
		Log.d("debug", "height2:" + height2);
		int width2 = screenSize.widthPixels;
		Log.d("debug", "width2:" + width2);

		TextView textView = (TextView) findViewById(R.id.textView1);

		RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) textView.getLayoutParams();
		layoutParams.topMargin = height / 2;

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		updateSizeInfo();
	}

	private void updateSizeInfo() {
		RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout1);
		int w = relativeLayout.getWidth();
		int h = relativeLayout.getHeight();
		Log.d("debug", "height" + h);
	}
}