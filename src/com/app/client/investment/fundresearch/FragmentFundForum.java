package com.app.client.investment.fundresearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
		container.removeAllViews();
		View rootView = inflater.inflate(R.layout.fragment_fundresearch_fundforum, container, false);
		
		initView(rootView, container, inflater);
		return rootView;
	}
	
	public void initView(View view, final ViewGroup container, final LayoutInflater inflater) {
		listView = (ListView) view.findViewById(R.id.fundresearch_fund_forum_ListView);
		FakeListViewAdapter adapter = new FakeListViewAdapter(getActivity(), R.layout.listview_fund_form, 5);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				container.removeAllViews();
				View detalView = inflater.inflate(R.layout.fragment_forum_detail, container, false);
				ListView replyListView = (ListView) detalView.findViewById(R.id.forum_detail_reply_ListView);
				FakeListViewAdapter replyListViewAdapter = new FakeListViewAdapter(getActivity(), R.layout.listview_forum_reply_item, 5);
				replyListView.setAdapter(replyListViewAdapter);
				ViewUtils.enableListViewinScrollerView(replyListView);
				container.addView(detalView);
			}	
		});
		ViewUtils.enableListViewinScrollerView(listView);
	}
}
