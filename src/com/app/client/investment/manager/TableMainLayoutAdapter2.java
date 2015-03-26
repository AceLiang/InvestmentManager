package com.app.client.investment.manager;


import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.app.client.investment.entity.Account;
import com.app.client.investment.entity.ChildAccount;
import com.app.client.investment.views.BaseTableMainLayoutAdapter;

public class TableMainLayoutAdapter2 extends BaseTableMainLayoutAdapter {

	private List<Account> accounts;
	
	
	public TableMainLayoutAdapter2(Context context, String headers[],
			List<Account> accounts) {
		// TODO Auto-generated constructor stub
		super.context = context;
		this.headers = headers;
		this.accounts = accounts;
	}

	@Override
	public int getFixHeaderColumn() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public View getHeaderCellView(int index , String label) {
		// TODO Auto-generated method stub
		TextView headerTextView = new TextView(this.context);
		headerTextView.setBackgroundColor(Color.WHITE);
		headerTextView.setText(label);
		headerTextView.setGravity(Gravity.CENTER);
		headerTextView.setPadding(10, 10, 10, 10);

		return headerTextView;
	}

	@Override
	public View getCellView(int index  , Object data) {
		// TODO Auto-generated method stub
		
		ChildAccount account = (ChildAccount) data;
		
		
		String label = "" ;
		switch (index) {
		case 0:
			label = account.tradeState + account.tradeNumber ;
			break;
		case 1:
			label = account.accountName + account.accountNumber ;
			break ;
		case 2:
			label = account.investState ;
			break ;
		case 3 :
			label = account.currentEquity + "" ;
			break ;
		case 4 :
			label = account.nowMoney + "" ;
			break ;
		case 5 :
			label = account.currentValue + "" ;
			break ;
		case 6 :
			label = account.allBounce + "" ;
			break ;
		case 7 :
			label="²Ù×÷" ;
			break ;
		case 8 :
			label=account.accountState ;
			break ;

		default:
			break;
		}
		
		TextView bodyTextView = new TextView(this.context);
        bodyTextView.setBackgroundColor(Color.WHITE);
        bodyTextView.setText(label);
        bodyTextView.setGravity(Gravity.CENTER);
        bodyTextView.setPadding(5, 5, 5, 5);
         
        return bodyTextView;
	}

	@Override
	public View getChildCellView(int index, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return accounts.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return accounts.get(position);
	}

	@Override
	public int getChildCount(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getChildItem(int position, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupIndex(int row, int column, Object data) {
		return row;
	}


}
