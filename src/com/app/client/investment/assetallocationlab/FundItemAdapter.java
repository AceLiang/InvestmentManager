package com.app.client.investment.assetallocationlab;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.client.investment.R;
import com.app.client.investment.fundresearch.Account;
import com.app.client.investment.utils.CollectionUtil;

public class FundItemAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private List<Account> accountList;
	
	public FundItemAdapter(Context c, List<Account> accountList) {
		this.mContext = c;
		this.mInflater = LayoutInflater.from(c); 
		this.accountList = accountList;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(CollectionUtil.isNotEmpty(accountList)) {
			return accountList.size();
		}else {
			return 0;
		}
		
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if(CollectionUtil.isNotEmpty(accountList)) {
			return accountList.get(position);
		}else {
			return null;
		}		
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = mInflater.inflate(R.layout.listview_risk_analysis_fund, null);

		TextView textView1 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text1);
		TextView textView2 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text2);
		TextView textView3 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text3);
		TextView textView4 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text4);
		//TextView textView5 = (TextView) convertView.findViewById(R.id.listView_risk_analysis_fund_text5);
		
		Account account = accountList.get(position);
		textView1.setText(account.getCode());
		textView2.setText(account.getName());
		textView3.setText(account.getDay());
		textView4.setText(account.getPerformance());
		//textView5.setText(account.getAvePerformance());
		
		return convertView;
	}

}
