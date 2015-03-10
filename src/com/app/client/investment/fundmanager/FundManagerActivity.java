package com.app.client.investment.fundmanager;

import com.app.client.investment.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;


public class FundManagerActivity extends Activity {

	private ListView lv ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_fund_manager);
		
		lv = (ListView) findViewById(R.id.lv);
		
		TestAdapter adapter = new TestAdapter() ;
		lv.setAdapter(adapter);
		
	}
	
	
	class TestAdapter extends BaseAdapter {

		private LayoutInflater inflater ;
		public TestAdapter() {
			// TODO Auto-generated constructor stub
			inflater = LayoutInflater.from(FundManagerActivity.this);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 10;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			if(convertView == null){
				convertView = inflater.inflate(R.layout.listview_fund_manager_item, parent,false);
			}
			return convertView;
		}
		
	}
}
