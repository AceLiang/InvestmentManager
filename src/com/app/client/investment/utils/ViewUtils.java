/*
   		File: ViewUtils.java
   		Date			Author      Changes
   		Sep 16  2014 	Matt    	Created  
   		Sep 16  2014 	Matt    	Added new doc conventions
 */
package com.app.client.investment.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/*********
 * @author Mattliang@apjcorp.com
 * @date Jul 11, 2014 
 * @version 1.0
 * 说明：common utils about android.Views
 */
public class ViewUtils {

	/******
	 * 说明：dp转换成在目标设备中对应的像素�?
	 * @param context
	 * @param dp
	 * @return
	 */
	public static int dpToPx(Context context ,float dp) {
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		
		
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, dm);
	}
	
	/********
	 * 说明：convert view into a bitmap。The View is No need to visiable
	 * @param v
	 * @param width
	 * @param height
	 * @return
	 */
	public static Bitmap loadBitmapFromView(View v , int width , int height) {
		 Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);             
		 Canvas c = new Canvas(b);
		 //layout the view with the special width ，height
		 v.layout(v.getLeft(), v.getTop(), width, height);
		 v.draw(c);
		 return b;
	}
	/***
	 * @author Mattliang@apjcorp.com
	 * @version 1.0
	 * @date Jan 9, 2015
	 * 说明：检测一个文本是的后端是否被省略，以后可能有�?
	 * @param textView
	 * @return
	 */
	public static boolean isTextViewShowEllipsis(TextView textView) {
		boolean result = false ;
		Layout layout = textView.getLayout();
		if(layout != null) {
		    int lines = layout.getLineCount();
		    if(lines > 0) {
		        int ellipsisCount = layout.getEllipsisCount(lines-1);
		        if ( ellipsisCount > 0) {
//		            Log.d("0000000000", "Text is ellipsized");
		        	result = true ;
		        } 
		    } 
		}
		
		return result;
	}
	
	
	
	/**
	 * Sets ListView height dynamically based on the height of the items.   
	 *
	 * @param listView to be resized
	 * @return true if the listView is successfully resized, false otherwise
	 */
	public static boolean setListViewHeightBasedOnItems(ListView listView) {

	    ListAdapter listAdapter = listView.getAdapter();
	    if (listAdapter != null) {

	        int numberOfItems = listAdapter.getCount();

	        // Get total height of all items.
	        int totalItemsHeight = 0;
	        for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
	            View item = listAdapter.getView(itemPos, listView.getChildAt(itemPos), listView);
	            item.measure(0, 0);
	            totalItemsHeight += item.getMeasuredHeight();
	        }

	        // Get total height of all item dividers.
	        int totalDividersHeight = listView.getDividerHeight() * 
	                (numberOfItems - 1);

	        // Set list height.
	        ViewGroup.LayoutParams params = listView.getLayoutParams();
	        params.height = totalItemsHeight + totalDividersHeight;
	        listView.setLayoutParams(params);
	        listView.requestLayout();

	        return true;

	    } else {
	        return false;
	    }

	}
	
	
	public static void enableListViewinScrollerView(ListView listView){
		listView.setOnTouchListener(new OnTouchListener() {
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            int action = event.getAction();
	            switch (action) {
	            case MotionEvent.ACTION_DOWN:
	                // Disallow ScrollView to intercept touch events.
	                v.getParent().requestDisallowInterceptTouchEvent(true);
	                break;

	            case MotionEvent.ACTION_UP:
	                // Allow ScrollView to intercept touch events.
	                v.getParent().requestDisallowInterceptTouchEvent(false);
	                break;
	            }

	            // Handle ListView touch events.
	            v.onTouchEvent(event);
	            return true;
	        }
	    });
	}
	
	
	public static View measureView(View v) {
		ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
		if (layoutParams != null) {
			int widthMeasureSpec = layoutParams.width ;
			int heightMeasureSpec = layoutParams.height;
			v.measure(widthMeasureSpec, heightMeasureSpec);
		}
		
		
		return v ;
	}
	
}
