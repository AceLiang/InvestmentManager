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

public class ActivitySelectCompany extends Activity implements OnItemClickListener{

	
	private ListView lvCompany ;
	FakeListViewAdapter adapter ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_selectcompany);
		
		lvCompany = (ListView) findViewById(R.id.lvCompany);
		adapter = new FakeListViewAdapter(this, R.layout.listview_select_company, 80);
		lvCompany.setOnItemClickListener(this);
		lvCompany.setAdapter(adapter);
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Intent data = new Intent() ;
		data.putExtra("name", "º£Í¨Ö¤È¯");
		setResult(Activity.RESULT_OK, data);
		finish();
	}
}
