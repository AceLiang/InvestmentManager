package com.app.client.investment.assetallocationlab;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.app.client.investment.R;
import com.app.client.investment.fundresearch.Account;
import com.opensource.librarys.roundprogressbar.RoundProgressBar;

public class RiskAnalysisActivity extends Activity {
	
	private RoundProgressBar pogressBar1;
	private RoundProgressBar pogressBar2;
	private RoundProgressBar pogressBar3;
	private RoundProgressBar pogressBar4;
	private ListView riskAnalysisListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_risk_analysis);
		
		pogressBar1 = (RoundProgressBar)findViewById(R.id.progressBar1);
		pogressBar1.setProgress(30);
		
		pogressBar2 = (RoundProgressBar)findViewById(R.id.progressBar2);
		pogressBar2.setProgress(30);
		
		pogressBar3 = (RoundProgressBar)findViewById(R.id.progressBar3);
		pogressBar3.setProgress(30);
		
		pogressBar4 = (RoundProgressBar)findViewById(R.id.progressBar4);
		pogressBar4.setProgress(30);
		
		riskAnalysisListView = (ListView)findViewById(R.id.risk_analysis_listView);
		FundItemAdapter adapter1 = new FundItemAdapter(this, getData());
		riskAnalysisListView.setAdapter(adapter1);

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
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		return accountList;
	}
	
	
}
