package com.app.client.investment.manager;

import java.io.File;

import com.app.client.investment.R;
import com.app.client.investment.utils.ActionBarUtil;
import com.app.client.investment.utils.IndicatorHelper;
import com.app.client.investment.utils.ViewUtils;
import com.app.client.investment.views.TabRadioGroup;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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

	private TabRadioGroup tabArea;
	private RadioButton rbAccountNews ;
	private RadioButton rbAccountManager ;
	private RadioButton rbAccountRank ;
	
	private FrameLayout contentArea;

	private FragmentManager fragmentManager;

	private FragmentAccountNews fragmentAccountNews;
	private FragmentAccountManager fragmentAccountManager;
	private FragmentAccountRank fragmentAccountRank;

	
	private ActionBar actionBar ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		actionBar = ActionBarUtil.initActionbar(this);
		setContentView(R.layout.activity_investment_manager);

		drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
		llTradeRecord = (LinearLayout) findViewById(R.id.llTradeRecord);
		llNotificationCenter = (LinearLayout) findViewById(R.id.llNotificationCenter);
		contentArea = (FrameLayout) findViewById(R.id.contentArea);

		rbAccountNews = (RadioButton) findViewById(R.id.rbAccountNews);
		rbAccountManager = (RadioButton) findViewById(R.id.rbAccountManager);
		rbAccountRank = (RadioButton) findViewById(R.id.rbAccountRank);
		
		fragmentManager = getSupportFragmentManager();
		tabArea = (TabRadioGroup) findViewById(R.id.tabArea);
		tabArea.setChangeListener(this);
		fragmentAccountNews = new FragmentAccountNews();
		fragmentAccountManager = new FragmentAccountManager();
		fragmentAccountRank = new FragmentAccountRank();
		tabArea.check(R.id.rbAccountNews);

		tabArea.setTabColor(Color.parseColor("#FCB55B"));
		llTradeRecord.setOnClickListener(this);
		llNotificationCenter.setOnClickListener(this);
		

		View actionbarView = actionBar.getCustomView();
		ImageButton back = (ImageButton) actionbarView.findViewById(R.id.back);
		ImageButton menu = (ImageButton) actionbarView.findViewById(R.id.menu);
		TextView title = (TextView) actionbarView.findViewById(R.id.title);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (drawer_layout.isDrawerOpen(GravityCompat.START) 
						|| drawer_layout.isDrawerOpen(GravityCompat.END)) {
					drawer_layout.closeDrawers();
				}else {
					finish();
				}
			}
		});
		
		menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (drawer_layout.isDrawerOpen(GravityCompat.START) 
						|| drawer_layout.isDrawerOpen(GravityCompat.END)) {
					drawer_layout.closeDrawers();
				}else {
					drawer_layout.openDrawer(GravityCompat.END);
				}
			}
		});
		title.setText(R.string.actionbar_invest_manager);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub

		switch (checkedId) {
		case R.id.rbAccountNews:
			fragmentManager.beginTransaction()
					.replace(R.id.contentArea, fragmentAccountNews).commit();
			break;
		case R.id.rbAccountManager:
			fragmentManager.beginTransaction()
					.replace(R.id.contentArea, fragmentAccountManager).commit();
			break;
		case R.id.rbAccountRank:
			fragmentManager.beginTransaction()
					.replace(R.id.contentArea, fragmentAccountRank).commit();
			break;

		default:
			break;
		}

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
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
//		inflater.inflate(R.menu.menu_record_data, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}
}
