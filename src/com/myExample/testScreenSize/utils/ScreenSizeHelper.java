package com.myExample.testScreenSize.utils;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

@SuppressLint("NewApi")
public class ScreenSizeHelper {

	public static ScreenSize getScreenSize(Context context) {

		WindowManager wm = (WindowManager) context.getSystemService(
				Context.WINDOW_SERVICE);

		Display display = wm.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();

		display.getMetrics(metrics);

		int width = metrics.widthPixels;
		Log.d("debug", "width" + width);

		int height = metrics.heightPixels;
		Log.d("debug", "height" + height);

		// get action bar height
		final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
				new int[] { android.R.attr.actionBarSize });
		int actionBarSize = (int) styledAttributes.getDimension(0, 0);
		styledAttributes.recycle();
		Log.d("debug", "actionBarSize" + actionBarSize);

		// get status bar height
		int statusBarSize = 0;
		int statusId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (statusId > 0) {
			statusBarSize = context.getResources().getDimensionPixelSize(statusId);
			Log.d("debug", "statusBarSize" + statusBarSize);
		}

		height = height - actionBarSize - statusBarSize;

		ScreenSize screenSize = new ScreenSize();
		screenSize.heightPixels = height;
		screenSize.widthPixels = width;
		screenSize.actionBarSize = actionBarSize;
		screenSize.statusBarSize = statusBarSize;
		return screenSize;
	}

	public static class ScreenSize {
		public int widthPixels;
		public int heightPixels;
		public int actionBarSize;
		public int statusBarSize;
		
	}

	public static ScreenSize getScreenSize2(Activity activity) {
		// current activity view not include action bar and status bar
		View view = activity.getWindow().getDecorView().findViewById(android.R.id.content);
		// include action bar and status bar
		// View view = activity.getWindow().getDecorView().getRootView();
		int height2 = view.getHeight();
		int width2 = view.getWidth();

		ScreenSize screenSize = new ScreenSize();
		screenSize.heightPixels = height2;
		screenSize.widthPixels = width2;
		return screenSize;
	}
}
