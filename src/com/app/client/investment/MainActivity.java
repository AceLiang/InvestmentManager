package com.app.client.investment;


import com.app.client.investment.fundmanager.FundManagerActivity;
import com.app.client.investment.fundresearch.FundResearchActivity;
import com.app.client.investment.manager.InvestmentManagerActivity;
import com.app.client.investment.managertool.InvestmentManagerToolActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btnFundManager ;
	private Button btnFundResearch ;
	private Button btnInvestmentManager ;
	private Button btnInvestmentTool ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
		initListener();
		initData();
		
		
	}

	private void initViews() {
		// TODO Auto-generated method stub
		btnFundManager = (Button) findViewById(R.id.btnFundManager);
		btnFundResearch = (Button) findViewById(R.id.btnFundResearch);
		btnInvestmentManager = (Button) findViewById(R.id.btnInvestmentManager);
		btnInvestmentTool = (Button) findViewById(R.id.btnInvestmentTool);
		
	}

	private void initListener() {
		// TODO Auto-generated method stub
		
		btnFundManager.setOnClickListener(this); 
		btnFundResearch.setOnClickListener(this) ;
		btnInvestmentManager.setOnClickListener(this) ;
		btnInvestmentTool.setOnClickListener(this) ;
		
	}

	private void initData() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnFundManager:
			gotoFundManager();
			break ;
		case R.id.btnInvestmentManager:
			gotoInvestmentManager();
			break;
		case R.id.btnFundResearch:
			gotoFundResearch();
			break ;
		case R.id.btnInvestmentTool:
			gotoInvestmentTool();
			break;

		default:
			break;
		}
	}
	
	public void gotoInvestmentTool(){
		Intent intent = new Intent(this, InvestmentManagerToolActivity.class);
		startActivity(intent);
	}
	
	private void gotoFundManager() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, FundManagerActivity.class);
		startActivity(intent);
	}

	public void gotoInvestmentManager(){
		Intent intent = new Intent(this, InvestmentManagerActivity.class);
		startActivity(intent);
	}
	
	
	public void gotoFundResearch(){
		Intent intent = new Intent(this, FundResearchActivity.class);
		startActivity(intent);
	}
}
