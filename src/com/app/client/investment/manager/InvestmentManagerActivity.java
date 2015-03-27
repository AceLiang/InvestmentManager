package com.app.client.investment.manager;

import com.app.client.investment.R;
import com.app.client.investment.utils.IndicatorHelper;
import com.app.client.investment.utils.ViewUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

/********
 * @author 明礼 投资管理界面
 */
public class InvestmentManagerActivity extends FragmentActivity implements
		OnCheckedChangeListener, OnClickListener {

	private DrawerLayout drawer_layout;
	private LinearLayout llTradeRecord;
	private LinearLayout llNotificationCenter;
	private FragmentTabHost mTabHost;

	private RadioGroup tabArea;
	private RadioButton rbAccountNews ;
	private RadioButton rbAccountManager ;
	private RadioButton rbAccountRank ;
	
	private FrameLayout contentArea;

	private FragmentManager fragmentManager;

	private FragmentAccountNews fragmentAccountNews;
	private FragmentAccountManager fragmentAccountManager;
	private FragmentAccountRank fragmentAccountRank;

	private View indicator;

	private IndicatorHelper indicatorHelper ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_investment_manager);

		drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
		llTradeRecord = (LinearLayout) findViewById(R.id.llTradeRecord);
		llNotificationCenter = (LinearLayout) findViewById(R.id.llNotificationCenter);
		contentArea = (FrameLayout) findViewById(R.id.contentArea);

		rbAccountNews = (RadioButton) findViewById(R.id.rbAccountNews);
		rbAccountManager = (RadioButton) findViewById(R.id.rbAccountManager);
		rbAccountRank = (RadioButton) findViewById(R.id.rbAccountRank);
		
		fragmentManager = getSupportFragmentManager();
		tabArea = (RadioGroup) findViewById(R.id.tabArea);
		tabArea.setOnCheckedChangeListener(this);
		fragmentAccountNews = new FragmentAccountNews();
		fragmentAccountManager = new FragmentAccountManager();
		fragmentAccountRank = new FragmentAccountRank();
		indicator = findViewById(R.id.indicator);
		tabArea.check(R.id.rbAccountNews);

		indicatorHelper = new IndicatorHelper(indicator, rbAccountNews, 3);
		llTradeRecord.setOnClickListener(this);
		llNotificationCenter.setOnClickListener(this);
		

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub

		switch (checkedId) {
		case R.id.rbAccountNews:
			fragmentManager.beginTransaction()
					.replace(R.id.contentArea, fragmentAccountNews).commit();
			indicatorHelper.moveTo(0);
			break;
		case R.id.rbAccountManager:
			fragmentManager.beginTransaction()
					.replace(R.id.contentArea, fragmentAccountManager).commit();
			indicatorHelper.moveTo(1);
			break;
		case R.id.rbAccountRank:
			fragmentManager.beginTransaction()
					.replace(R.id.contentArea, fragmentAccountRank).commit();
			indicatorHelper.moveTo(2);
			break;

		default:
			break;
		}

		indicator.requestLayout();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.llTradeRecord:

			Intent intent = new Intent(this, ActivityTradeRecord.class);

			startActivity(intent);
			break;
		case R.id.llNotificationCenter:
			Intent intent2 = new Intent(this, ActivityNotificationCenter.class);
			startActivity(intent2);
			break;

		default:
			break;
		}
	}
	
	
	
}
