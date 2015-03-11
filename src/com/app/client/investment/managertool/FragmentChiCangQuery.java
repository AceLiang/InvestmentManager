package com.app.client.investment.managertool;

import com.app.client.investment.R;
import com.app.client.investment.utils.FakeListViewAdapter;
import com.app.client.investment.utils.ViewUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListView;

public class FragmentChiCangQuery extends Fragment {
	
	
	private ListView lv ;
	private FakeListViewAdapter adapter ;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_shicang_query, container, false) ;
		lv = (ListView) root.findViewById(R.id.lv);
		ViewUtils.enableListViewinScrollerView(lv);
		adapter = new FakeListViewAdapter(getActivity(), R.layout.listview_shicang_query_item, 100);
		lv.setAdapter(adapter);
		return root;
	}

	
	
}
