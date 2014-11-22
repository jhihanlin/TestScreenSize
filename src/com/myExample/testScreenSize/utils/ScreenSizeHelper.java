package com.myExample.testScreenSize.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

@SuppressLint("NewApi")
public class ScreenSizeHelper {
	Context context;

	public static int widthPixels;
	public static int heightPixels;
	private static int mActionBarSize;
	private static int mStatusBarSize;

	public static int getScreenSize(Context context) {
		WindowManager wm = (WindowManager) context.getSystemService(
				Context.WINDOW_SERVICE);

		Display display = wm.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		widthPixels = metrics.widthPixels;
		heightPixels = metrics.heightPixels;
		Log.d("debug", "widthPixels" + widthPixels);
		Log.d("debug", "heightPixels" + heightPixels);

		// get action bar height
		final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
				new int[] { android.R.attr.actionBarSize });
		mActionBarSize = (int) styledAttributes.getDimension(0, 0);
		styledAttributes.recycle();
		Log.d("debug", "mActionBarSize" + mActionBarSize);

		// get status bar height
		int mStatusBarSize = 0;
		int statusId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (statusId > 0) {
			mStatusBarSize = context.getResources().getDimensionPixelSize(statusId);
			Log.d("debug", "mStatusBarSize" + mStatusBarSize);
		}
		heightPixels = heightPixels - mActionBarSize - mStatusBarSize;
		return heightPixels;
	}
}
