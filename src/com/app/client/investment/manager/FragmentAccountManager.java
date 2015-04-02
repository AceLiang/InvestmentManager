package com.app.client.investment.manager;

import java.util.ArrayList;
import java.util.List;

import com.app.client.investment.R;
import com.app.client.investment.entity.Account;
import com.app.client.investment.entity.ChildAccount;
import com.app.client.investment.utils.CustomDialogBuider;
import com.app.client.investment.utils.ViewUtils;
import com.app.client.investment.views.BaseDialog;
import com.app.client.investment.views.BaseTableMainLayoutAdapter.IonCellClickListener;
import com.app.client.investment.views.TableMainLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/*****
 * 
 * @author 明礼 账户管理
 */
public class FragmentAccountManager extends Fragment implements OnClickListener {

	private Button btnAddMainAccount;

	private RelativeLayout emptyTable;
	
	private TableMainLayout tableAccount;
	
	private TableMainLayoutAdapter adapter ;
	
	private LinearLayout tableArea ;
	
	 String headers[] = {
		        "序号",
		        "账户类型",
		        "投资状态",
		        "当前权益(万元)",
		        "剩余资金(万元)",
		        "单位净值(万元)",
		        "总回报率(元)",
		        "账户操作",
		        "账户状态"
		    };
	 List<Account> accounts ;

	 
	 
	 private TableMainLayout tableAccount2 ;
	 
	 private TableMainLayoutAdapter2 adapter2 ;
	 List<Account> accounts2 ;
	 
	 private LinearLayout table2Area ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_account_manager,
				container, false);

		initViews(root);
		initListener();
		initData();
		return root;
	}

	private void initViews(View root) {
		// TODO Auto-generated method stub
		Drawable divider = getActivity().getResources().getDrawable(R.drawable.separator_table);
		emptyTable = (RelativeLayout) root.findViewById(R.id.emptyTable);
		btnAddMainAccount = (Button) root.findViewById(R.id.btnAddMainAccount);
		tableAccount = (TableMainLayout) root.findViewById(R.id.tableAccount);
		
		tableArea = (LinearLayout) root.findViewById(R.id.tableArea);
		
		tableAccount2 = (TableMainLayout) root.findViewById(R.id.tableAccount2);
		table2Area = (LinearLayout) root.findViewById(R.id.table2Area);
		
	}

	private void initListener() {
		// TODO Auto-generated method stub
		btnAddMainAccount.setOnClickListener(this);
	}

	private void initData() {
		// TODO Auto-generated method stub

		accounts = new ArrayList<Account>();
		
		for(int i =0 ; i < 3 ; i ++){
			Account account = new Account() ;
			account.accountName = "申银万国证券" ;
			account.accountNumber = "100001" ;
			account.currentEquity = 200 ;
			account.nowMoney = 300 ;
			account.currentValue = 400 ;
			account.allBounce = 200 ;
			account.accountState = "与服务器断开" ;
			accounts.add(account);
			account.childAccounts = new ArrayList<ChildAccount>();
			for(int j = 0 ; j < 3; j ++){
				ChildAccount childAccount = new ChildAccount();
				childAccount.accountName = "子账户" ;
				childAccount.accountNumber = "100001" ;
				childAccount.currentEquity = 200 ;
				childAccount.nowMoney = 300 ;
				childAccount.currentValue = 400 ;
				childAccount.allBounce = 200 ;
				childAccount.accountState = "我是子账户" ;
				childAccount.tradeState = "对冲交易" ;
				childAccount.investState = "交易状态" ;
				childAccount.tradeNumber = 3 ;
				account.childAccounts.add(childAccount);
			}
		}
		adapter = new TableMainLayoutAdapter(getActivity(), headers, accounts);
		adapter.setCellClickListener(new IonCellClickListener() {
			
			@Override
			public void onCellClickListener(int column, int row, View view,
					boolean isChildView, Object data) {
				// TODO Auto-generated method stub
				if (isChildView == false && column == 1) {
					
					if (column == 1) {
						CheckBox box =(CheckBox) view.findViewById(R.id.cb);
						box.setChecked(!box.isChecked());
					}
					adapter.expandGroup(row);
					
				}
				
				
				 if (column == 7) {
					showOperationDialog(isChildView);
				 }
			}
		});
		tableAccount.setAdapter(adapter);
		
		
		accounts2 = new ArrayList<Account>();
		for(int i =0 ; i < 3 ; i ++){
			ChildAccount childAccount = new ChildAccount();
			childAccount.accountName = "子账户" ;
			childAccount.accountNumber = "100001" ;
			childAccount.currentEquity = 200 ;
			childAccount.nowMoney = 300 ;
			childAccount.currentValue = 400 ;
			childAccount.allBounce = 200 ;
			childAccount.accountState = "我是子账户" ;
			childAccount.tradeState = "对冲交易" ;
			childAccount.investState = "交易状态" ;
			childAccount.tradeNumber = 3 ;
			accounts2.add(childAccount);
		}
		
		adapter2 = new TableMainLayoutAdapter2(getActivity(), headers, accounts2);
		tableAccount2.setAdapter(adapter2);
		MarginLayoutParams layoutParams = (MarginLayoutParams) tableArea.getLayoutParams();
		if (accounts.size() == 0) {
			emptyTable.setVisibility(View.VISIBLE);
			layoutParams.bottomMargin = 0;
		}else {
			emptyTable.setVisibility(View.GONE);
			layoutParams.bottomMargin = ViewUtils.dpToPx(getActivity(), 60);
		}
		
		tableArea.requestLayout();
		
		
		
	}

	protected void showOperationDialog(boolean isChildView) {
		// TODO Auto-generated method stub
		BaseDialog dialog = new BaseDialog(getActivity());
		dialog.setTitle("选择操作");
		
		ListView listView = null ;
		if (isChildView) {
			listView = buildChildAccountListView( dialog);
		}else {
			listView = buildMainAccountListView( dialog);
		}
		
		dialog.setCustomContentView(listView);
		dialog.show();
	}

	private ListView buildMainAccountListView(final BaseDialog dialog) {
		// TODO Auto-generated method stub
		List<String> objects = new ArrayList<String>();
		objects.add("拆分");
		objects.add("资金调拨");
		objects.add("曲线图");
		objects.add("银证转账");
		objects.add("证银转账");
		
		ListView listView = new ListView(getActivity());
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Intent intent = null;
				switch (position) {
				case 0:
					intent = new Intent(getActivity(), SplitChildAccount.class);
					break;
				case 1:
					intent = new Intent(getActivity(), ActivityZiJinDiaoBo.class);
					break;
				case 2:
					intent = new Intent(getActivity(), ActivityJingZhengChart.class);
					break;
				case 3:
					break;
				case 4:
					
					break;

				default:
					break;
				}
				
				if (intent != null) {
					getActivity().startActivity(intent);
				}
				dialog.dismiss();
			}
		});
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.item_text, R.id.tv,objects);
		listView.setAdapter(adapter);
		return listView;
	}

	private ListView buildChildAccountListView(final BaseDialog dialog) {
		// TODO Auto-generated method stub
		List<String> objects = new ArrayList<String>();
		objects.add("申请终止交易");
		objects.add("合并");
		objects.add("曲线图");
		objects.add("选择结算方式");
		objects.add("结算继续购买");
		objects.add("卖出");
		objects.add("去交易");
		objects.add("成交记录");
		
		ListView listView = new ListView(getActivity());
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					
					break;
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;

				default:
					break;
				}
				dialog.dismiss();
			}
		});
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.item_text, R.id.tv,objects);
		listView.setAdapter(adapter);
		return listView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnAddMainAccount:
			Intent intent = new Intent(getActivity(),
					ActivityAddMainAccount.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
