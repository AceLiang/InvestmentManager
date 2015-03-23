package com.app.client.investment.manager;

import com.app.client.investment.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityAddMainAccount extends Activity implements OnClickListener{
	
	Button btnSelectFundCompany ;
	Button btnSelectCompany ;
	
	boolean isClickCompany = false ;
	boolean isClickFundCompany = false ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_addmain_account);
		
		initViews();
		initListener();
		initData();
	}
	
	private void initViews() {
		// TODO Auto-generated method stub
		btnSelectFundCompany = (Button) findViewById(R.id.btnSelectFundCompany);
		btnSelectCompany = (Button) findViewById(R.id.btnSelectCompany);
	}

	private void initListener() {
		// TODO Auto-generated method stub
		btnSelectFundCompany.setOnClickListener(this);
		btnSelectCompany.setOnClickListener(this);
	}

	private void initData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.btnSelectFundCompany:
			isClickFundCompany = true ;
			intent.setClass(this, ActivitySelectCompany.class);
			break;
		case R.id.btnSelectCompany:
			intent.setClass(this, ActivitySelectCompany.class);
			isClickCompany = true ;
			break ;

		default:
			break;
		}
		
		startActivityForResult(intent, 1);
	}

	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == 1 && resultCode == Activity.RESULT_OK){
			String name = data.getStringExtra("name");
			
			if(isClickFundCompany){
				isClickFundCompany = false ;
				btnSelectFundCompany.setText(name);
			}
			
			if(isClickCompany){
				isClickCompany = false ;
				btnSelectCompany.setText(name);
			}
			
			
		}
	}
}
