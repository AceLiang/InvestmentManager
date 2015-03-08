package com.app.client.investment.fundresearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.client.investment.R;
/**
 * @author ¼ò½¨ºè
 * ¹«Ë¾¼ò½é
 */
public class FragmentCompanyOverView extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_fundresearch_companyoverview, container, false);
		return rootView;
	}

}
