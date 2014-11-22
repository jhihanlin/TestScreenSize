package com.myExample.testScreenSize.utils;

import android.R.integer;
import android.content.Context;
import android.util.DisplayMetrics;

public class ResolutionConvertor {
	public static int dpi;

	public static int getResolution(Context context) {
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		dpi = (int) metrics.density;
		return dpi;
	}

	public static int changePixelToDip(int px, int dpi) {
		int dip = px * 160 / dpi;
		return dip;
	}
}
