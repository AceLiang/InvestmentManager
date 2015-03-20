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

public class FragmentNormalBuy extends Fragment {
	
	
	ListView lvBuyInDetail ;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_normal_buy, container, false) ;
		lvBuyInDetail = (ListView) root.findViewById(R.id.lvBuyInDetail);
		FakeListViewAdapter adapter = new FakeListViewAdapter(getActivity(), R.layout.listview_item_buyin_detal, 100);
		lvBuyInDetail.setAdapter(adapter);
		ViewUtils.enableListViewinScrollerView(lvBuyInDetail);
		return root;
	}
}
