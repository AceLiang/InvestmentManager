/*
   		File: MaxHeightRelativeLayout.java
   		Date			Author      Changes
   		Sep 15  2014 	Matt    	Created  
   		Sep 15  2014 	Matt    	Added new doc conventions
 */
package com.app.client.investment.views;


import com.app.client.investment.R;
import com.app.client.investment.utils.ViewUtils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/*******
 * @author Mattliang@apjcorp.com
 * @date Aug 21, 2014
 * @version 1.0 说明：has maxheight attributes
 */
public class MaxHeightRelativeLayout extends RelativeLayout {

	int maxheight = 0;

	/*****
	 * 说明：constructor
	 * 
	 * @param context
	 */
	public MaxHeightRelativeLayout(Context context) {
		super(context);
		maxheight = ViewUtils.dpToPx(context, 300);
	}

	/*****
	 * 说明：constructor
	 * 
	 * @param context
	 * @param attrs
	 */
	public MaxHeightRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		maxheight = ViewUtils.dpToPx(context, 300);

		// 取得XML的自定义属�??
		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.MaxHeightRelativeLayout, 0, 0);
		maxheight = typedArray.getDimensionPixelSize(
				R.styleable.MaxHeightRelativeLayout_maxHeight, maxheight);
	}

	/*****
	 * 说明：constructor
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public MaxHeightRelativeLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		maxheight = ViewUtils.dpToPx(context, 300);

		// 取得XML的自定义属�??
		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.MaxHeightRelativeLayout, 0, 0);
		maxheight = typedArray.getDimensionPixelSize(
				R.styleable.MaxHeightRelativeLayout_maxHeight, maxheight);
	}

	/******
	 * 说明�? set the max height
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxheight,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}
