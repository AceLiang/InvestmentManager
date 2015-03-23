package com.app.client.investment.managertool;

import java.util.ArrayList;
import java.util.List;

import com.app.client.investment.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
/******
 * @author Mattliang@apjcorp.com
 * @date Mar 11, 2015 
 * @version 1.0
 * 说明：智能投资工具
 */
public class InvestmentManagerToolActivity extends FragmentActivity implements OnCheckedChangeListener {
	
	
	private Spinner spinnerAccount ;
	private RadioGroup tabArea ;
	private RadioGroup tabQueryArea ;
	
	private FragmentManager fragmentManager ;
	
	private FragmentBuyin fragmentBuyin ;
	private FragmentFinancingBuyin fragmentFinancingBuyin ;
	private FragmentSaleOut fragmentSaleOut;
	private FragmentBalanceSheet fragmentBalanceSheet ;
	
	
	private FragmentChiCangQuery fragmentChiCangQuery ;
	private FragmentWeituoQuery fragmentWeituoQuery ;
	private FragmentChengJiaoQuery fragmentChengJiaoQuery ;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_investment_manager_tool);
		initViews();
		initListener();
		initData();
		
		
		
		
		
		tabArea.check(R.id.rbBuyIn);
		tabQueryArea.check(R.id.rbChicangQuery);
	}

	private void initViews() {
		// TODO Auto-generated method stub
		tabArea = (RadioGroup) findViewById(R.id.tabArea);
		tabQueryArea = (RadioGroup) findViewById(R.id.tabQueryArea);
		spinnerAccount = (Spinner) findViewById(R.id.spinnerAccount);
	}

	private void initListener() {
		// TODO Auto-generated method stub
		tabArea.setOnCheckedChangeListener(this);
		tabQueryArea.setOnCheckedChangeListener(this);
	}

	private void initData() {
		// TODO Auto-generated method stub
		fragmentManager = getSupportFragmentManager();
		fragmentBuyin = new FragmentBuyin();
		fragmentFinancingBuyin = new FragmentFinancingBuyin();
		fragmentSaleOut = new FragmentSaleOut();
		fragmentBalanceSheet = new FragmentBalanceSheet();
		
		
		fragmentChengJiaoQuery = new FragmentChengJiaoQuery();
		fragmentChiCangQuery = new FragmentChiCangQuery();
		fragmentWeituoQuery = new FragmentWeituoQuery();
		
		tabArea.check(R.id.rbBuyIn);
		tabQueryArea.check(R.id.rbChicangQuery);
		
		List<String> mTitles = new ArrayList<String>();
		mTitles.add("申银万国证券账户");
		mTitles.add("申银万国证券账户");
		mTitles.add("申银万国证券账户");
		ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mTitles);
		
		spinnerAccount.setAdapter(arrayAdapter);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rbBuyIn:
			fragmentManager.beginTransaction().replace(R.id.busnissArea, fragmentBuyin).commit();
			break;
		case R.id.rbFinancingBuyIn:
			fragmentManager.beginTransaction().replace(R.id.busnissArea, fragmentFinancingBuyin).commit();
			break;
		case R.id.rbSaleOut:
			fragmentManager.beginTransaction().replace(R.id.busnissArea, fragmentSaleOut).commit();
			break;
		case R.id.rbBalanceSheet:
			fragmentManager.beginTransaction().replace(R.id.busnissArea, fragmentBalanceSheet).commit();
			break;
			
			
			
		case R.id.rbChicangQuery:
			fragmentManager.beginTransaction().replace(R.id.queryArea, fragmentChiCangQuery).commit();
			break;
		case R.id.rbWeituoQuery:
			fragmentManager.beginTransaction().replace(R.id.queryArea, fragmentWeituoQuery).commit();
			break;
		case R.id.rbChengjiaoQuery:
			fragmentManager.beginTransaction().replace(R.id.queryArea, fragmentChengJiaoQuery).commit();
			break;

		default:
			break;
		}
	};
}
