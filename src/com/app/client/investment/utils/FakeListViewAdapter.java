package com.app.client.investment.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FakeListViewAdapter extends BaseAdapter {

	
	private Context context ;
	private int layoutId ;
	private int itemCount ;
	private LayoutInflater inflater ;
	public FakeListViewAdapter(Context context , int layoutId , int itemCount) {
		this.context = context ;
		this.layoutId = layoutId ;
		this.itemCount = itemCount ;
		inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemCount;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
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
			convertView = inflater.inflate(layoutId, parent, false);
		}
		return convertView;
	}

}
