package com.app.client.investment.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;

public class CustomDialogBuider extends Dialog {
	
	private Context mContext;
	
	private View customTitleView;
	private View customContentView;

	public CustomDialogBuider(Context context) {
		super(context);
		mContext = context;
	}
	
	public CustomDialogBuider(Context context, int theme) {
		super(context, theme);
		mContext = context;
	}
	
	public AlertDialog create() {
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		builder.setCustomTitle(customTitleView);		
		builder.setView(customContentView);
		
		return builder.create();
	}
	
	public View getCustomTitleView() {
		return customTitleView;
	}
	
	public void setCustomTitleView(View customTitleView) {
		this.customTitleView = customTitleView;
	}
	
	public View getCustomContentView() {
		return customContentView;
	}
	
	public void setCustomContentView(View customContentView) {
		this.customContentView = customContentView;
	}	
}
