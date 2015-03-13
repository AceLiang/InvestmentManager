package com.app.client.investment.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public abstract class BaseLinearLayoutAdapter {
	
	Context context;
	LayoutInflater inflater;
	LinearLayout parent;
	int layoutId ;
	
	
	public BaseLinearLayoutAdapter(Context context , LinearLayout parent , int layoutId) {
		this.context = context ;
		this.parent = parent ;
		this.layoutId = layoutId ;
		inflater = LayoutInflater.from(context);
		
		initViews();
	}

	public abstract int getCount() ;
	
	public abstract void bindDataToView(int position , View view);
	
	
	public View getView(int position) {
		// TODO Auto-generated method stub
		View view = null;
		if (position < parent.getChildCount()) {
			view = parent.getChildAt(position);
		}

		if (view == null) {
			view = inflater.inflate(layoutId, parent, false);
			parent.addView(view, position);
		}

		return view;
	}
	
	
	public void initViews(){
		// TODO Auto-generated method stub
		int size = getCount() ;
		
		for(int i = 0; i < size ; i ++ ){
			View view = getView(i);
			bindDataToView(i , view);
		}
	}
	
	
	
	
	public void notifycationDataSetChange() {
		initViews() ;
	}
}
