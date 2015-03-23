package com.app.client.investment.manager;

import com.app.client.investment.R;
import com.app.client.investment.utils.ViewUtils;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
/*****
 * 
 * @author 明礼
 *账户管理
 */
public class FragmentAccountManager extends Fragment implements OnClickListener{
	
	private Button btnAddMainAccount ;
	private ListView tableContent ;
	
	private RelativeLayout emptyTable ;
	
	private HorizontalScrollView tableArea ;
	
	private TestAdapter adapter ;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_account_manager, container, false);
		
		initViews(root);
		initListener();
		initData();
		return root;
	}

	private void initViews(View root) {
		// TODO Auto-generated method stub
		tableContent = (ListView) root.findViewById(R.id.tableContent);
		emptyTable = (RelativeLayout) root.findViewById(R.id.emptyTable);
		tableArea = (HorizontalScrollView) root.findViewById(R.id.tableArea);
		btnAddMainAccount =(Button) root.findViewById(R.id.btnAddMainAccount);
	}

	private void initListener() {
		// TODO Auto-generated method stub
		btnAddMainAccount.setOnClickListener(this);
	}

	private void initData() {
		// TODO Auto-generated method stub
		adapter = new TestAdapter();
		MarginLayoutParams layoutParams = (MarginLayoutParams) tableArea.getLayoutParams();
		if (adapter.getCount() > 0) {
			emptyTable.setVisibility(View.GONE);
			layoutParams.bottomMargin = ViewUtils.dpToPx(getActivity(), 60);
		}else {
			emptyTable.setVisibility(View.VISIBLE);
			layoutParams.bottomMargin = 0;
		}
		tableArea.requestLayout();
		tableContent.setAdapter(adapter);
		
		
		
	}
	
	
	
	
	class TestAdapter extends BaseAdapter {
		
		
		private LayoutInflater inflater = null;
		
		
		public TestAdapter() {
			// TODO Auto-generated constructor stub
			inflater = LayoutInflater.from(getActivity());
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, final ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.listview_fund_item, parent, false);
			}
			
			
			CheckBox cbExpand = (CheckBox) convertView .findViewById(R.id.cbExpand);
			final LinearLayout listClassarea = (LinearLayout) convertView.findViewById(R.id.listClassarea);
			
			cbExpand.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if (isChecked) {
						listClassarea.setVisibility(View.GONE);
					}else {
						listClassarea.setVisibility(View.VISIBLE);
					}
					ViewUtils.setListViewHeightBasedOnItems(tableContent);
				}
			});
			return convertView;
		}
		
	}




	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnAddMainAccount:
			Intent intent = new Intent(getActivity(), ActivityAddMainAccount.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	
	
}
