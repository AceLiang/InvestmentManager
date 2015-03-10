package com.app.client.investment.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class VerticalTextView extends TextView {
	
	
	public VerticalTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		
		initText();
	}
	
	private void initText() {
		CharSequence text = this.getText();
		StringBuilder sb = new StringBuilder() ;
		if(text != null && text.length() > 0){
			for(int i = 0 ; i < text.length() - 1; i ++){
				sb.append(text.charAt(i) + "\n");
			}
			sb.append(text.charAt(text.length() - 1));
			setText(sb.toString());
		}
	}

	public VerticalTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initText();
	}

	public VerticalTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initText();
	}
	

}
