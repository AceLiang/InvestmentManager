package com.app.client.investment.manager;

import com.app.client.investment.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ActivityNotificationCenter extends Activity {

	
	private ListView lv ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_notification_center);
		
		lv = (ListView) findViewById(R.id.lv);
	}
}
