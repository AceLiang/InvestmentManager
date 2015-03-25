package com.app.client.investment.juxianfang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.client.investment.R;
import com.app.client.investment.utils.FakeListViewAdapter;
import com.app.client.investment.utils.ViewUtils;

public class FragmentForumHotspot extends Fragment {
	
	private View rootView;
	private ListView postListView;
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		initView(rootView);
		initData();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_forum_hotspot, container, false);
		return rootView;
	}

	public void initView(View view) {
		postListView = (ListView)view.findViewById(R.id.juxianfang_forum_hotspot_ListView);
	}
	
	public void initData() {
		FakeListViewAdapter adapter = new FakeListViewAdapter(getActivity(), R.layout.listview_fund_form, 5);
		postListView.setAdapter(adapter);
		ViewUtils.enableListViewinScrollerView(postListView);
	}
}
