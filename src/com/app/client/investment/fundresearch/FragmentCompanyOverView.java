package com.app.client.investment.fundresearch;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.client.investment.R;
/**
 * @author ¼ò½¨ºè
 * ¹«Ë¾¼ò½é
 */
public class FragmentCompanyOverView extends Fragment {

	private ListView selfAccountListView;
	private ListView otherAccountListView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_fundresearch_companyoverview, container, false);
		
		selfAccountListView = (ListView) rootView.findViewById(R.id.fundresearch_company_selfAccount_listView);
		AccountAdapter adapter1 = new AccountAdapter(getActivity(), getData());
		selfAccountListView.setAdapter(adapter1);
		
		otherAccountListView = (ListView) rootView.findViewById(R.id.fundresearch_company_otherAccount_listView);
		otherAccountListView.setAdapter(adapter1);
		
		return rootView;
	}

	public List<Account> getData() {
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		accountList.add(new Account("00021", "±¦Ó¯ºËÐÄÓÎÏ·»ìºÏ", "65", "5.6", "15.6"));
		return accountList;
	}
	
	class Account{
		private String code;
		private String name;
		private String day;
		private String performance;
		private String avePerformance;
		
		public Account(String code, String name, String day, String performance, String aveP) {
			this.code = code;
			this.name = name;
			this.day = day;
			this.performance = performance;
			this.avePerformance = aveP;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		public String getPerformance() {
			return performance;
		}

		public void setPerformance(String performance) {
			this.performance = performance;
		}

		public String getAvePerformance() {
			return avePerformance;
		}

		public void setAvePerformance(String avePerformance) {
			this.avePerformance = avePerformance;
		}
		
	}
}
