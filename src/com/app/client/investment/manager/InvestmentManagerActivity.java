package com.app.client.investment.manager;

import com.app.client.investment.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/********
 * @author 明礼 投资管理界面
 */
public class InvestmentManagerActivity extends FragmentActivity implements OnCheckedChangeListener{

	private FragmentTabHost mTabHost;
	
	
	private RadioGroup tabArea ;
	private FrameLayout contentArea ;
	
	
	private FragmentManager fragmentManager ;
	
	private FragmentAccountNews fragmentAccountNews ;
	private FragmentAccountManager fragmentAccountManager ;
	private FragmentAccountRank fragmentAccountRank ;
	
	private ViewStub lazyView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_investment_manager);

		lazyView = (ViewStub) findViewById(R.id.lazyView);
		contentArea = (FrameLayout) findViewById(R.id.contentArea);
		
		fragmentManager = getSupportFragmentManager();
		buildNormalLayout();
		
	}

	

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rbAccountNews:
			fragmentManager.beginTransaction().replace(R.id.contentArea, fragmentAccountNews).commit();
			break;
		case R.id.rbAccountManager:
			fragmentManager.beginTransaction().replace(R.id.contentArea, fragmentAccountManager).commit();
			break ;
		case R.id.rbAccountRank:
			fragmentManager.beginTransaction().replace(R.id.contentArea, fragmentAccountRank).commit();
			break ;

		default:
			break;
		}
		
	}
	
	
	private void buildNormalLayout() {
		lazyView.setLayoutResource(R.layout.normal_user_tab_area);
		View tapAreaView = lazyView.inflate();
		tabArea = (RadioGroup) tapAreaView.findViewById(R.id.tabArea);
		tabArea.setOnCheckedChangeListener(this);
		fragmentAccountNews = new FragmentAccountNews();
		fragmentAccountManager = new FragmentAccountManager();
		fragmentAccountRank = new FragmentAccountRank();
		
		tabArea.check(R.id.rbAccountNews);
		
	}
}
