package com.app.client.investment.utils;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public class IndicatorHelper {
	
	
	private View indicator ;
	int step ;
	int maxTab = 0 ;

	public IndicatorHelper( View indicator , final View defauleView, int maxTab) {
		// TODO Auto-generated constructor stub
		this.indicator = indicator ;
		this.maxTab = maxTab ;
		defauleView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				// TODO Auto-generated method stub
				defauleView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				step = defauleView.getWidth();
				IndicatorHelper.this.indicator.getLayoutParams().width = step ;
				IndicatorHelper.this.indicator.requestLayout();
				IndicatorHelper.this.indicator.setVisibility(View.VISIBLE);
			}
		});
	}
	
	
	
	public int getStep() {
		return step ;
	}
	
	
	public void moveTo(int pos) {
		if (pos < maxTab) {
			MarginLayoutParams marginLayoutParams = (MarginLayoutParams) indicator.getLayoutParams();
			marginLayoutParams.leftMargin = pos * step ;
			indicator.requestLayout();
		}
	}
	
}
