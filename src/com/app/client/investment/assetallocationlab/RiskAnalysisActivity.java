package com.app.client.investment.assetallocationlab;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.client.investment.R;
import com.app.client.investment.fundresearch.Account;
import com.opensource.librarys.roundprogressbar.RoundProgressBar;

public class RiskAnalysisActivity extends Activity {
	
	private RoundProgressBar pogressBar1;
	private RoundProgressBar pogressBar2;
	private RoundProgressBar pogressBar3;
	private RoundProgressBar pogressBar4;
	//private ListView riskAnalysisListView;
	private LinearLayout riskAnalysisLinearLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_risk_analysis);
		
		initView();
	}
	
	public void initView() {
		pogressBar1 = (RoundProgressBar)findViewById(R.id.progressBar1);
		pogressBar1.setProgress(30);
		
		pogressBar2 = (RoundProgressBar)findViewById(R.id.progressBar2);
		pogressBar2.setProgress(30);
		
		pogressBar3 = (RoundProgressBar)findViewById(R.id.progressBar3);
		pogressBar3.setProgress(30);
		
		pogressBar4 = (RoundProgressBar)findViewById(R.id.progressBar4);
		pogressBar4.setProgress(30);
		
		riskAnalysisLinearLayout = (LinearLayout) findViewById(R.id.risk_analysis_linearLayout);
		LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for(Account account : getData()) {
			View convertView = inflater.inflate(R.layout.listview_risk_analysis_fund, null);

			TextView textView1 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text1);
			TextView textView2 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text2);
			TextView textView3 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text3);
			TextView textView4 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text4);

			textView1.setText(account.getCode());
			textView2.setText(account.getName());
			textView3.setText(account.getDay());
			textView4.setText(account.getPerformance());
			
			convertView.setBackgroundDrawable(getResources().getDrawable(R.drawable.listview_riskanalysis_selecter1));
			riskAnalysisLinearLayout.addView(convertView);
			
			LinearLayout mlineLayout = new LinearLayout(this);
			mlineLayout.setOrientation(LinearLayout.HORIZONTAL);
			mlineLayout.setBackgroundColor(getResources().getColor(R.color.white));
			LinearLayout.LayoutParams layoutForInner = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
			mlineLayout.setLayoutParams(layoutForInner);
			riskAnalysisLinearLayout.addView(mlineLayout);
		}

		for(Account account : getData()) {
			View convertView = inflater.inflate(R.layout.listview_risk_analysis_fund, null);

			TextView textView1 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text1);
			TextView textView2 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text2);
			TextView textView3 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text3);
			TextView textView4 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text4);

			textView1.setText(account.getCode());
			textView2.setText(account.getName());
			textView3.setText(account.getDay());
			textView4.setText(account.getPerformance());
			
			convertView.setBackgroundDrawable(getResources().getDrawable(R.drawable.listview_riskanalysis_selecter2));
			riskAnalysisLinearLayout.addView(convertView);
			
			LinearLayout mlineLayout = new LinearLayout(this);
			mlineLayout.setOrientation(LinearLayout.HORIZONTAL);
			mlineLayout.setBackgroundColor(getResources().getColor(R.color.white));
			LinearLayout.LayoutParams layoutForInner = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
			mlineLayout.setLayoutParams(layoutForInner);
			riskAnalysisLinearLayout.addView(mlineLayout);
		}
		
		for(Account account : getData()) {
			View convertView = inflater.inflate(R.layout.listview_risk_analysis_fund, null);

			TextView textView1 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text1);
			TextView textView2 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text2);
			TextView textView3 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text3);
			TextView textView4 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text4);

			textView1.setText(account.getCode());
			textView2.setText(account.getName());
			textView3.setText(account.getDay());
			textView4.setText(account.getPerformance());
			
			convertView.setBackgroundDrawable(getResources().getDrawable(R.drawable.listview_riskanalysis_selecter3));
			riskAnalysisLinearLayout.addView(convertView);
			
			LinearLayout mlineLayout = new LinearLayout(this);
			mlineLayout.setOrientation(LinearLayout.HORIZONTAL);
			mlineLayout.setBackgroundColor(getResources().getColor(R.color.white));
			LinearLayout.LayoutParams layoutForInner = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
			mlineLayout.setLayoutParams(layoutForInner);
			riskAnalysisLinearLayout.addView(mlineLayout);
		}
	}
	
	public List<Account> getData() {
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		return accountList;
	}
	
	
}
