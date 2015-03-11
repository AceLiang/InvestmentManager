package com.app.client.investment.managertool;

import com.app.client.investment.R;
import com.app.client.investment.utils.FakeListViewAdapter;
import com.app.client.investment.utils.ViewUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FragmentWeituoQuery extends Fragment {

	private ListView lv ;
	private FakeListViewAdapter adapter ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_weituo_query, container, false) ;
		lv = (ListView) root.findViewById(R.id.lv);
		ViewUtils.enableListViewinScrollerView(lv);
		adapter = new FakeListViewAdapter(getActivity(), R.layout.listview_weituo_query, 100);
		lv.setAdapter(adapter);
		return root;
	}
}
