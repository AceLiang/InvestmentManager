package com.app.client.investment.manager;


import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import com.app.client.investment.R;
import com.app.client.investment.entity.Account;
import com.app.client.investment.entity.ChildAccount;
import com.app.client.investment.utils.ViewUtils;
import com.app.client.investment.views.BaseTableMainLayoutAdapter;

public class TableMainLayoutAdapter2 extends BaseTableMainLayoutAdapter {

	private List<Account> accounts;
	
	private int padding = 10 ;
	
	private LayoutInflater inflater ;
	
	public TableMainLayoutAdapter2(Context context, String headers[],
			List<Account> accounts) {
		// TODO Auto-generated constructor stub
		super.context = context;
		this.headers = headers;
		this.accounts = accounts;
		padding = ViewUtils.dpToPx(context, 10);
		inflater = LayoutInflater.from(context) ;
	}

	@Override
	public int getFixHeaderColumn() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public View getHeaderCellView(int index , String label , TableRow parent) {
		// TODO Auto-generated method stub
		TextView headerTextView = new TextView(this.context);
		
		Drawable drawable = getDrawable(R.drawable.cell_header_shape);
//		headerTextView.setBackgroundColor(Color.WHITE);
		headerTextView.setBackgroundDrawable(drawable);
		headerTextView.setText(label);
		headerTextView.setGravity(Gravity.CENTER);
		
		headerTextView.setTextColor(Color.WHITE);

		if (index == 1) {
			headerTextView.setPadding(padding * 3, padding, padding * 3, padding);
		}else if (index == 7) {
			headerTextView.setPadding(padding * 3, padding, padding * 3, padding);
		}else{
			headerTextView.setPadding(padding , padding, padding, padding);
		}
		return headerTextView;
	}

	@Override
	public View getCellView(int index  , Object data, TableRow parent) {
		// TODO Auto-generated method stub
		
		ChildAccount account = (ChildAccount) data;
		
		View view = null;
		String label = "" ;
		switch (index) {
		case 0:
			label = account.tradeNumber +"";
			break;
		case 1:
//			label = account.accountName + account.accountNumber ;
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
		
		Drawable drawable = getDrawable(R.drawable.cell_child_shape);
		
		if (index == 0) {
			view = inflater.inflate(R.layout.table_child_cell_index1, null, false);
			
			TextView number = (TextView) view.findViewById(R.id.number);
			number.setText(label);
		}else if (index == 1) {
			view = inflater.inflate(R.layout.table_child_cell_index11, null, false);
			TextView tvAccountName = (TextView) view.findViewById(R.id.tvAccountName);
			TextView tvAccountNumber = (TextView) view.findViewById(R.id.tvAccountNumber);
			tvAccountName.setText(account.accountName);
			tvAccountNumber.setText(account.accountNumber);
		}else if (index == 7) {
			view =  inflater.inflate(R.layout.table_cell_index7, parent, false);
		}else {
			TextView bodyTextView = new TextView(this.context);
	        bodyTextView.setText(label);
	        bodyTextView.setGravity(Gravity.CENTER);
	        bodyTextView.setPadding(padding, padding, padding, padding);
	         
	        view = bodyTextView ;
		}
		
		view.setBackgroundDrawable(drawable);
		
		return view ;
	}

	@Override
	public View getChildCellView(int index, Object data, TableRow parent) {
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
