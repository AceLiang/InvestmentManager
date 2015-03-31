package com.app.client.investment.views;

import com.app.client.investment.R;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;

public class BaseDialog extends Dialog {

	private ImageButton close ;
	private TextView title ;
	private FrameLayout content ;
	private Context context ;
	
	private View customView ;
	
	public BaseDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context ;
		initDialogStyle();
		
		setContentView(R.layout.dialog_layout);
		
		initViews();
		initListener();
	}
	private void initListener() {
		// TODO Auto-generated method stub
		
		close.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
	}
	private void initViews() {
		// TODO Auto-generated method stub
		
		close = (ImageButton) findViewById(R.id.close);
		title = (TextView) findViewById(R.id.title);
		content = (FrameLayout) findViewById(R.id.content);
	}
	private void initDialogStyle() {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
	
	
	
	public void setTitle(int id) {
		String titleString= context.getResources().getString(id);
		title.setText(titleString);
	}
	
	public void setTitle(String titleString) {
		title.setText(titleString);
	}
	
	
	public void setCustomContentView(View view) {
		content.removeAllViews();
		FrameLayout.LayoutParams params = new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
		content.addView(view,params);
		customView = view ;
	}
	
	public void setCustomContentView(int layoutId) {
		content.removeAllViews();
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(layoutId, content, false);
		FrameLayout.LayoutParams params = new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
		content.addView(view,params);
		customView = view ;
	}

}
