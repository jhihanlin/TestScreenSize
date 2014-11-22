package com.myExample.testScreenSize.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class ResolutionConvertor {
	public static int dpi;

	public static int getResolution(Context context) {
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		dpi = (int) metrics.density;
		return dpi;
	}

	public static int changePixelToDip(int px, int dpi) {
		int dip = px / dpi;
		return dip;
	}

	public static int ChangeDipToPixel(Context context, int dip) {
		int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip,
				context.getResources().getDisplayMetrics());
		return px;
	}
}
