package com.app.client.investment.manager;

import com.app.client.investment.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

/********
 * @author 明礼 投资管理界面
 */
public class InvestmentManagerActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_investment_manager);

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		mTabHost.addTab(
				mTabHost.newTabSpec("tag1").setIndicator(
						getString(R.string.lable_account_news)),
				FragmentAccountNews.class, null);
		mTabHost.addTab(
				mTabHost.newTabSpec("tag2").setIndicator(
						getString(R.string.lable_account_manager)),
				FragmentAccountManager.class, null);
		mTabHost.addTab(
				mTabHost.newTabSpec("tag3").setIndicator(
						getString(R.string.lable_account_rank)),
				FragmentAccountRank.class, null);
	}
}
