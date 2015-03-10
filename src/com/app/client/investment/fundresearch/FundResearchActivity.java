package com.app.client.investment.fundresearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import com.app.client.investment.R;
/**
 * 
 * @author 简建鸿
 *基金研究
 */
/**
 * 
 * @author 简建鸿
 *基金研究
 */
public class FundResearchActivity extends FragmentActivity {

	private TextView textView1;
	private TextView textView2;
	private TextView textView3;
	private TextView textView4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundresearch_main);
		
		initView();
		initData();
				
	}
	
	public void initView() {
		textView1 = (TextView) findViewById(R.id.fundresearch_nav_performance);
		textView2 = (TextView) findViewById(R.id.fundresearch_nav_fundOverview);
		textView3 = (TextView) findViewById(R.id.fundresearch_nav_fundForum);
		textView4 = (TextView) findViewById(R.id.fundresearch_nav_companyOverview);
	}
	
	public void initData() {
		clearNavSelect();
		textView1.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		textView1.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
		
		Fragment fragment = new FragmentPerFormance();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();
	}

	public void showPerformance(View view) {
		clearNavSelect();
		textView1.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		textView1.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
		
		Fragment fragment = new FragmentPerFormance();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();
	}
	
	public void showFundOverview(View view) {
		clearNavSelect();
		textView2.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		textView2.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
		
		Fragment fragment = new FragmentFundOverView();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();	
	}
	
	public void showFundForum(View view) {
		clearNavSelect();
		textView3.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		textView3.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
		
		Fragment fragment = new FragmentFundForum();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();
	}
	
	public void showCompanyOverview(View view) {
		clearNavSelect();
		textView4.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		textView4.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
		
		Fragment fragment = new FragmentCompanyOverView();
		FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_fund_content, fragment).commit();
	}
	
	public void clearNavSelect() {
		textView1.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_backgound));
		textView2.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_backgound));
		textView3.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_backgound));
		textView4.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_backgound));
		
		textView1.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_textColor));
		textView2.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_textColor));
		textView3.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_textColor));
		textView4.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_textColor));
	}
}
