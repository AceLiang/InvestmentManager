package com.app.client.investment.managertool;

import java.lang.reflect.Field;

import com.app.client.investment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class FragmentBuyin extends Fragment implements
		RadioGroup.OnCheckedChangeListener {

	RadioGroup tabBuyArea;

	FragmentManager fragmentManager;

	FragmentNormalBuy normalBuy;
	FragmentBatBuy batBuy;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_buyin, container, false);
		tabBuyArea = (RadioGroup) root.findViewById(R.id.tabBuyArea);

		fragmentManager = getChildFragmentManager();
		normalBuy = new FragmentNormalBuy();
		batBuy = new FragmentBatBuy();
		tabBuyArea.setOnCheckedChangeListener(this);
		tabBuyArea.check(R.id.rbNormalBuy);
		return root;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rbNormalBuy:
			fragmentManager.beginTransaction().replace(R.id.buyArea, normalBuy)
					.commit();
			break;
		case R.id.rbBatBuy:
			fragmentManager.beginTransaction().replace(R.id.buyArea, batBuy)
					.commit();
			break;

		default:
			break;
		}
	}

	/****
	 * Getting the error ¡°Java.lang.IllegalStateException Activity has been
	 * destroyed¡± when using getChildFragmentManager
	 */
	@Override
	public void onDetach() {
		super.onDetach();

		try {
			Field childFragmentManager = Fragment.class
					.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);

		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
