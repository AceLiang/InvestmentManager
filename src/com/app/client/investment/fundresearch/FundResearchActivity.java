package com.app.client.investment.fundresearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.app.client.investment.R;
/**
 * 
 * @author 简建鸿
 *基金研究
 */
public class FundResearchActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundresearch_main);
		
		Fragment fragment = new FragmentPerFormance();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();
	}

	public void showPerformance(View view) {
		Fragment fragment = new FragmentPerFormance();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();
	}
	
	public void showFundOverview(View view) {
		Fragment fragment = new FragmentFundOverView();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();	
	}
	
	public void showFundForum(View view) {
		Fragment fragment = new FragmentFundForum();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();
	}
	
	public void showCompanyOverview(View view) {
		Fragment fragment = new FragmentCompanyOverView();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();
	}
}
