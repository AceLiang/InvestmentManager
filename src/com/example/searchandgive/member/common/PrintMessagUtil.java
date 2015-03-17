package com.example.searchandgive.member.common;

import android.content.Context;
import android.widget.Toast;

public class PrintMessagUtil {

	public static void showToast(Context context,String value) {
		Toast.makeText(context, value ,Toast.LENGTH_SHORT).show();
	}
}
