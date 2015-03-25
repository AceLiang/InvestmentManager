package com.app.client.investment.manager;

import java.util.ArrayList;
import java.util.List;

import com.app.client.investment.R;
import com.app.client.investment.entity.Options;
import com.app.client.investment.utils.FakeListViewAdapter;
import com.opensource.librarys.slideexpandablelistview.ActionSlideExpandableListView;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ActivityTradeRecord extends FragmentActivity implements OnCheckedChangeListener , OnClickListener{
	
	
	private RadioGroup rgTab ;
	private ActionSlideExpandableListView lvTrade ;
	private ListView lvAccount ;

	private RelativeLayout accountArea ;
	private Button btnYinZheng ;
	private Button btnYinqi ;
	
	private DialogOptions dialogOptions ;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		setContentView(R.layout.activity_traderecord);
		
		rgTab = (RadioGroup) findViewById(R.id.rgTab);
		lvTrade = (ActionSlideExpandableListView) findViewById(R.id.lvTrade);
		lvAccount = (ListView) findViewById(R.id.lvAccount);
		btnYinZheng = (Button) findViewById(R.id.btnYinZheng);
		btnYinqi = (Button) findViewById(R.id.btnYinqi);
		accountArea = (RelativeLayout) findViewById(R.id.accountArea);
		
		FakeListViewAdapter adapter = new FakeListViewAdapter(this, R.layout.listview_trade_record, 100);
		lvTrade.setAdapter(adapter);
		
		FakeListViewAdapter adapter2 = new FakeListViewAdapter(this, R.layout.listview_account_item, 100);
		lvAccount.setAdapter(adapter2);
		rgTab.setOnCheckedChangeListener(this);
		rgTab.check(R.id.rbFundTrade);
		
		btnYinZheng.setOnClickListener(this);
		btnYinqi.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "...................", Toast.LENGTH_LONG).show();
		List<Options> options = null ;
		switch (v.getId()) {
		case R.id.btnYinZheng:
			options = new ArrayList<Options>();
			options.add(new Options(1 , "银行转期货"));
			options.add(new Options(2 , "期货转银行"));
			
			break;
		case R.id.btnYinqi:
			options = new ArrayList<Options>();
			options.add(new Options(1 , "银行转证券"));
			options.add(new Options(2 , "证券转银行"));
			break;

		default:
			break;
		}
		
		if (options != null) {
			dialogOptions = new DialogOptions(this, options);
			dialogOptions.show();
		}
		
	}
}
