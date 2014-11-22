package com.myExample.testScreenSize.activity;

import com.myExample.testScreenSize.utils.ScreenSizeHelper;
import com.myexcample.testscreensize.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ScreenSizeHelper screenSizeHelper = new ScreenSizeHelper();
		int height = screenSizeHelper.getScreenSize(this);
		TextView textView = (TextView) findViewById(R.id.textView1);

		RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) textView.getLayoutParams();
		layoutParams.topMargin = height / 2;
	}
}
