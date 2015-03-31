package com.app.client.investment.manager;

import com.app.client.investment.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class ActivityZiJinDiaoBo extends Activity implements OnClickListener{
	
	
	LinearLayout btn1 ;
	LinearLayout btn2 ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_zijin_diaobo);
		
		btn1 = (LinearLayout) findViewById(R.id.btn1);
		btn2 = (LinearLayout) findViewById(R.id.btn2);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, ActivityTransferMoney.class);
		startActivity(intent);
		finish();
	}
}
