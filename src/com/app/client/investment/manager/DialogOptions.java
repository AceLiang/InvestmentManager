package com.app.client.investment.manager;


import java.util.List;
import com.app.client.investment.R;
import com.app.client.investment.entity.Options;
import com.app.client.investment.utils.ViewUtils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DialogOptions extends Dialog implements OnItemClickListener{
	
	private Window mWindow ;
	private Context context ;
	
	private List<Options> options ;
	
	private ListView lv ;
	
	private LayoutInflater inflater ;
	
	
	private MyAdapter adapter ;

	public DialogOptions(Context context , List<Options> options) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context ;
		inflater = LayoutInflater.from(context);
		initDialogStyle();
		
		setContentView(R.layout.dialog_option);
		this.options = options ;
		
		initViews();
		initListener();
		initData();
	}
	
	private void initViews() {
		// TODO Auto-generated method stub
		lv = (ListView) findViewById(R.id.lv);
	}

	private void initListener() {
		// TODO Auto-generated method stub
		lv.setOnItemClickListener(this);
	}

	private void initData() {
		// TODO Auto-generated method stub
		adapter = new MyAdapter();
		lv.setAdapter(adapter);
	}

	private void initDialogStyle() {
		mWindow = this.getWindow();
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Making dialog content transparent.
//		mWindow.setBackgroundDrawable(
//				new ColorDrawable(Color.TRANSPARENT));
		// Removing window dim normally visible when dialog are shown.
//		mWindow.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

		// //设置显示动画
		mWindow.setWindowAnimations(R.style.DialogDownToUpAnimation);
		WindowManager.LayoutParams wl = mWindow.getAttributes();
		wl.gravity = Gravity.BOTTOM;
		// 设置显示位置
		mWindow.setAttributes(wl);
		mWindow.setLayout(ViewUtils.dpToPx(context, 300), WindowManager.LayoutParams.WRAP_CONTENT);
		// 设置点击外围解散
//		setCanceledOnTouchOutside(true);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
//		mWindow.setLayout(ViewUtils.dpToPx(context, 300), WindowManager.LayoutParams.WRAP_CONTENT);

		mWindow.setLayout(ViewUtils.dpToPx(context, 300), WindowManager.LayoutParams.WRAP_CONTENT);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		this.dismiss();
		
		
		Intent intent = new Intent(context, ActivityTransferMoney.class);
		context.startActivity(intent);
	}
	
	
	
	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return options.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return options.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.listview_text_single, parent, false);
			}
			
			TextView tv = (TextView) convertView ;
			tv.setText(options.get(position).optionName);
			return convertView;
		}
		
	}

}
