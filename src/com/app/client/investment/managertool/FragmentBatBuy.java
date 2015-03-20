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

public class FragmentBatBuy extends Fragment {
	
	ListView lvBatBuyInDetail ;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_bat_buy, container, false) ;
		lvBatBuyInDetail = (ListView) root.findViewById(R.id.lvBatBuyInDetail);
		FakeListViewAdapter adapter = new FakeListViewAdapter(getActivity(), R.layout.item_batbuyin_detail, 100);
		lvBatBuyInDetail.setAdapter(adapter);
		ViewUtils.enableListViewinScrollerView(lvBatBuyInDetail);
		return root;
	}
}
