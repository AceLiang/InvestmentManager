package com.app.client.investment.manager;

import com.app.client.investment.R;
import com.app.client.investment.utils.FakeListViewAdapter;
import com.opensource.librarys.slideexpandablelistview.ActionSlideExpandableListView;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ActivityTradeRecord extends FragmentActivity implements OnCheckedChangeListener{
	
	
	private RadioGroup rgTab ;
	private ActionSlideExpandableListView lvTrade ;
	private ListView lvAccount ;

	private RelativeLayout accountArea ;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		setContentView(R.layout.activity_traderecord);
		
		rgTab = (RadioGroup) findViewById(R.id.rgTab);
		lvTrade = (ActionSlideExpandableListView) findViewById(R.id.lvTrade);
		lvAccount = (ListView) findViewById(R.id.lvAccount);
		accountArea = (RelativeLayout) findViewById(R.id.accountArea);
		
		FakeListViewAdapter adapter = new FakeListViewAdapter(this, R.layout.listview_trade_record, 100);
		lvTrade.setAdapter(adapter);
		
		FakeListViewAdapter adapter2 = new FakeListViewAdapter(this, R.layout.listview_account_item, 100);
		lvAccount.setAdapter(adapter2);
		rgTab.setOnCheckedChangeListener(this);
		rgTab.check(R.id.rbFundTrade);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rbFundTrade:
			lvTrade.setVisibility(View.VISIBLE);
			accountArea.setVisibility(View.GONE);
			break;
		case R.id.rbYinzhengqi:
			accountArea.setVisibility(View.VISIBLE);
			lvTrade.setVisibility(View.GONE);
			break ;

		default:
			break;
		}
	}
}
