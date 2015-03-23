package com.app.client.investment.fundresearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.client.investment.R;
import com.app.client.investment.utils.FakeListViewAdapter;
import com.app.client.investment.utils.ViewUtils;
/**
 * @author 简建鸿
 * 基金论坛
 */
public class FragmentFundForum extends Fragment {

	private ListView listView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_fundresearch_fundforum, container, false);
		
		initView(rootView);
		
		return rootView;
	}
	
	public void initView(View view) {
		listView = (ListView) view.findViewById(R.id.fundresearch_fund_forum_ListView);
		FakeListViewAdapter adapter = new FakeListViewAdapter(getActivity(), R.layout.listview_fund_form, 5);
		listView.setAdapter(adapter);
		ViewUtils.enableListViewinScrollerView(listView);
	}
}
