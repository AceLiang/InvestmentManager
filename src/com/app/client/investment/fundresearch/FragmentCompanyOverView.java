package com.app.client.investment.fundresearch;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.client.investment.R;
/**
 * @author 简建鸿
 * 公司简介
 */
public class FragmentCompanyOverView extends Fragment {

	//private ListView selfAccountListView;
	//private ListView otherAccountListView;
	private LinearLayout selfAccountLinearLayout;
	private LinearLayout otherAccountLinearLayout;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_fundresearch_companyoverview, container, false);
		
		initView(rootView, inflater);
				
		return rootView;
	}

	public void initView (View rootView, LayoutInflater inflater) {
		selfAccountLinearLayout = (LinearLayout) rootView.findViewById(R.id.fundresearch_company_selfAccount_linearLayout);
		otherAccountLinearLayout = (LinearLayout) rootView.findViewById(R.id.fundresearch_company_otherAccount_linearLayout);
		
		for(Account account : getData()) {
			View convertView = inflater.inflate(R.layout.listview_fundresearch_company_account, null);
			TextView textView1 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text1);
			TextView textView2 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text2);
			TextView textView3 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text3);
			TextView textView4 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text4);
			TextView textView5 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text5);
			textView1.setText(account.getCode());
			textView2.setText(account.getName());
			textView3.setText(account.getDay());
			textView4.setText(account.getPerformance());
			textView5.setText(account.getAvePerformance());
			
			selfAccountLinearLayout.addView(convertView);
		}
		
		for(Account account : getData()) {
			View convertView = inflater.inflate(R.layout.listview_fundresearch_company_account, null);
			TextView textView1 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text1);
			TextView textView2 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text2);
			TextView textView3 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text3);
			TextView textView4 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text4);
			TextView textView5 = (TextView) convertView.findViewById(R.id.listView_fundresearch_company_account_text5);
			textView1.setText(account.getCode());
			textView2.setText(account.getName());
			textView3.setText(account.getDay());
			textView4.setText(account.getPerformance());
			textView5.setText(account.getAvePerformance());
			
			otherAccountLinearLayout.addView(convertView);
		}
		
		/*selfAccountListView = (ListView) rootView.findViewById(R.id.fundresearch_company_selfAccount_listView);
		AccountAdapter adapter1 = new AccountAdapter(getActivity(), getData());
		selfAccountListView.setAdapter(adapter1);
		
		otherAccountListView = (ListView) rootView.findViewById(R.id.fundresearch_company_otherAccount_listView);
		otherAccountListView.setAdapter(adapter1);*/
	}
	
	public List<Account> getData() {
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account("00021", "宝盈核心游戏混合大方的发的发嘎嘎发噶地方噶风格的法国的非官方的个法国风格的非官方", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "宝盈核心游戏混合", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "宝盈核心游戏混合", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "宝盈核心游戏混合", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "宝盈核心游戏混合", "65", "5.6", "15.6"));
		return accountList;
	}
	
}
