package com.app.client.investment.manager;

import java.util.List;

import com.app.client.investment.R;
import com.app.client.investment.entity.Account;
import com.app.client.investment.entity.ChildAccount;
import com.app.client.investment.utils.ViewUtils;
import com.app.client.investment.views.BaseTableMainLayoutAdapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
public class TableMainLayoutAdapter extends BaseTableMainLayoutAdapter{



	private List<Account> accounts;
	
	
	private int padding = 10 ;
	
	private LayoutInflater inflater ;

	public TableMainLayoutAdapter(Context context, String headers[],
			List<Account> accounts) {
		// TODO Auto-generated constructor stub
		super.context = context;
		this.headers = headers;
		this.accounts = accounts;
		inflater = LayoutInflater.from(context) ;
		padding = ViewUtils.dpToPx(context, 10);
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
	public View getCellView(int index  , Object data, TableRow parent) {
		// TODO Auto-generated method stub
		
		Account account = (Account) data;
		
		int position = accounts.indexOf(data);
		
		View view = null ;
		String label = "" ;
		switch (index) {
		case 0:
			label = "" + (position +1) ;
			break;
		case 1:
			label = account.accountName + account.accountNumber ;
			break ;
		case 2:
			label = "" ;
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
		Drawable drawable = getDrawable(R.drawable.cell_group_shape);
		if (index == 1) {
//			LinearLayout layoutWrap = new LinearLayout(context);
//			layoutWrap.setPadding(padding, padding, padding, padding);
//			layoutWrap.setFocusable(false);
//			layoutWrap.setClickable(false);
//			layoutWrap.setGravity(Gravity.CENTER);
//			CheckBox checkBox = new CheckBox(context);
//			checkBox.setText(label);
//			checkBox.setGravity(Gravity.CENTER);
//			checkBox.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
//			checkBox.setButtonDrawable(R.drawable.selector_add_blue);
//			checkBox.setClickable(false);
//			layoutWrap.addView(checkBox);
			view =  inflater.inflate(R.layout.table_cell_index1, parent, false);
			CheckBox box = (CheckBox) view.findViewById(R.id.cb) ;
			box.setText(label);
			
		}else if (index == 7) {
			
//			LinearLayout layout = new LinearLayout(context);
//			layout.setPadding(padding, padding, padding, padding);
//			layout.setGravity(Gravity.CENTER);
//			Button button = new Button(context);
//			button.setText(label);
//			button.setGravity(Gravity.CENTER);
//			button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
//			
//			layout.addView(button);
//			view = layout ;
			view =  inflater.inflate(R.layout.table_cell_index7, parent, false);
		}else {
			TextView bodyTextView = new TextView(this.context);
	        bodyTextView.setText(label);
	        bodyTextView.setGravity(Gravity.CENTER);
	        bodyTextView.setPadding(padding, padding, padding, padding);
	        
	        view = bodyTextView ;
		}
		
		view.setBackgroundDrawable(drawable);
         
        return view;
	}




	@Override
	public View getChildCellView(int index, Object data, TableRow parent) {
		// TODO Auto-generated method stub
		
		ChildAccount account = (ChildAccount) data;
		View view = null;
		if (account != null) {
			
			
			String label = "" ;
			switch (index) {
			case 0:
				label =  account.tradeNumber+"" ;
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
			Drawable drawable = getDrawable(R.drawable.cell_child_shape);
			
			if (index == 0) {
				view = inflater.inflate(R.layout.table_child_cell_index1, null, false);
				
				TextView number = (TextView) view.findViewById(R.id.number);
				number.setText(label);
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
		}
		return view;
	}




	@Override
	public Object getChildItem(int position, int index) {
		// TODO Auto-generated method stub
		
		Account account = accounts.get(position);
		ChildAccount childAccount = account.childAccounts.get(index);
		return childAccount ;
	}




	@Override
	public int getChildCount(int position) {
		// TODO Auto-generated method stub
		Account account = accounts.get(position);
		return account.childAccounts.size();
	}




	@Override
	public int getGroupIndex(int row, int column, Object data) {
		// TODO Auto-generated method stub
		int groupIndex = 0 ;
		for(int i =  0 ;  i < accounts.size() ; i ++){
			if (accounts.get(i).childAccounts.contains(data)) {
				groupIndex = i;
			}
		}
		return groupIndex;
	}

	
	
	public int expandGroup(int groupIndex){
		int length = 0 ;
		
		for(int i = groupIndex ; i >= 0 ; i --){
			Account account = accounts.get(groupIndex);
			int childCount = 0 ;
			if (account.childAccounts != null) {
				childCount = account.childAccounts.size();
			}
			
			length = length + childCount + 1;
		}
		
		Account account = accounts.get(groupIndex);
		int childCount = 0 ;
		if (account.childAccounts != null) {
			childCount = account.childAccounts.size();
		}
		int start = length - childCount  ;
		int end = length - 1;
		
		boolean isExpand = getGroupState(groupIndex);
		Toast.makeText(context, "start:" + start  + " end:" +end, 1000).show();
		if (isExpand) {
			collapse(start, end);
			setGroupState(groupIndex, false);
		}else {
			expand(start, end);
			setGroupState(groupIndex, true);
		}
		return length ;
	}

}
