package com.app.client.investment.utils;

import java.lang.reflect.Field;

import com.app.client.investment.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class ActionBarUtil {
	
	
	public static void setOverflowShowingAlways(Context context) {
		try {
			ViewConfiguration config = ViewConfiguration.get(context);
			Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
			menuKeyField.setAccessible(true);
			menuKeyField.setBoolean(config, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static ActionBar initActionbar(Activity activity) {
		ActionBar actionBar = activity.getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setCustomView(R.layout.layout_action_bar_normal);
		return actionBar ;
	}
	
	

}
