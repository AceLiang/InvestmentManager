package com.app.client.investment.juxianfang;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.app.client.investment.R;

public class Juxianfangactivity extends FragmentActivity implements OnCheckedChangeListener{

	FrameLayout content ;
	
	RadioGroup tabButtomArea ;
	FragmentManager fragmentManager;
	FragmentForum fragmentForum ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_juxianfang_main);
		
		
		initViews();
		initListener();
		initData();
		
	}
	private void initViews() {
		// TODO Auto-generated method stub
		content = (FrameLayout) findViewById(R.id.content);
		tabButtomArea = (RadioGroup) findViewById(R.id.tabButtomArea);
	}
	private void initListener() {
		// TODO Auto-generated method stub
		tabButtomArea.setOnCheckedChangeListener(this);
	}
	private void initData() {
		// TODO Auto-generated method stub
		fragmentManager = getSupportFragmentManager();
		fragmentForum = new FragmentForum();
		
		
		tabButtomArea.check(R.id.rbForum);
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rbActivity:
			
			break;
		case R.id.rbLibary:
			
			break;
		case R.id.rbForum:
			fragmentManager.beginTransaction().replace(R.id.content, fragmentForum).commit();
			break;

		default:
			break;
		}
	}
}
