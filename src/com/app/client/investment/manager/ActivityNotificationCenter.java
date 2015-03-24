package com.app.client.investment.manager;

import com.app.client.investment.R;
import com.app.client.investment.utils.FakeListViewAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ActivityNotificationCenter extends Activity implements OnItemClickListener{

	
	private ListView lv ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_notification_center);
		
		lv = (ListView) findViewById(R.id.lv);
		
		FakeListViewAdapter adapter = new FakeListViewAdapter(this, R.layout.listview_notify_center, 100);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, ActivityNotificationDetail.class);
		startActivity(intent);
	}
}
