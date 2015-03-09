package com.app.client.investment.manager;

import com.app.client.investment.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
 * @author ����
 *�˻�����
 */
public class FragmentAccountManager extends Fragment {
	
	
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
	}

	private void initListener() {
		// TODO Auto-generated method stub
		
	}

	private void initData() {
		// TODO Auto-generated method stub
		adapter = new TestAdapter();
		
		if (adapter.getCount() > 0) {
			emptyTable.setVisibility(View.GONE);
		}else {
			emptyTable.setVisibility(View.VISIBLE);
		}
		tableContent.setAdapter(adapter);
		
		
	}
	
	/**
	 * Sets ListView height dynamically based on the height of the items.   
	 *
	 * @param listView to be resized
	 * @return true if the listView is successfully resized, false otherwise
	 */
	public static boolean setListViewHeightBasedOnItems(ListView listView) {

	    ListAdapter listAdapter = listView.getAdapter();
	    if (listAdapter != null) {

	        int numberOfItems = listAdapter.getCount();

	        // Get total height of all items.
	        int totalItemsHeight = 0;
	        for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
	            View item = listAdapter.getView(itemPos, listView.getChildAt(itemPos), listView);
	            item.measure(0, 0);
	            totalItemsHeight += item.getMeasuredHeight();
	        }

	        // Get total height of all item dividers.
	        int totalDividersHeight = listView.getDividerHeight() * 
	                (numberOfItems - 1);

	        // Set list height.
	        ViewGroup.LayoutParams params = listView.getLayoutParams();
	        params.height = totalItemsHeight + totalDividersHeight;
	        listView.setLayoutParams(params);
	        listView.requestLayout();

	        return true;

	    } else {
	        return false;
	    }

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
			return 8;
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
					setListViewHeightBasedOnItems(tableContent);
				}
			});
			return convertView;
		}
		
	}
	
	
}