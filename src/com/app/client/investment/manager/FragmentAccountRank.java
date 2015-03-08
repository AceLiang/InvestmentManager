package com.app.client.investment.manager;

import com.app.client.investment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/********
 * @author 明礼
 *我的排行
 */
public class FragmentAccountRank extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_account_rank, container, false);
		return root;
	}
}
