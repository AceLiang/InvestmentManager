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
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btnFundManager ;
	private Button btnFundResearch ;
	private Button btnInvestmentManager ;
	private Button btnInvestmentTool ;
	private Button btnForum ;
	private Button btnHelp ;
	private Button btnJuxianyuan ;

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
		btnForum = (Button) findViewById(R.id.btnForum);
		btnHelp = (Button) findViewById(R.id.btnHelp);
		btnJuxianyuan = (Button) findViewById(R.id.btnJuxianyuan);
		
	}

	private void initListener() {
		// TODO Auto-generated method stub
		
		btnFundManager.setOnClickListener(this); 
		btnFundResearch.setOnClickListener(this) ;
		btnInvestmentManager.setOnClickListener(this) ;
		btnInvestmentTool.setOnClickListener(this) ;
		btnForum.setOnClickListener(this);
		btnHelp.setOnClickListener(this);
		btnJuxianyuan.setOnClickListener(this);
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
		case R.id.btnForum:
			gotoForum();
			break ;
		case R.id.btnHelp:
			gotoHelp();
			break ;
		case R.id.btnJuxianyuan:
			gotoJuxianyuan();
			break ;

		default:
			break;
		}
	}
	
	public void gotoForum(){
		Toast.makeText(this, "未实现", Toast.LENGTH_LONG).show();
	}
	
	public void gotoHelp(){
		Toast.makeText(this, "未实现", Toast.LENGTH_LONG).show();
	}
	
	
	public void gotoJuxianyuan(){
		Toast.makeText(this, "未实现", Toast.LENGTH_LONG).show();
	}
	
	public void gotoInvestmentTool(){
		Intent intent = new Intent(this, InvestmentManagerToolActivity.class);
		startActivity(intent);
	}
	
	public void gotoFundManager() {
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
