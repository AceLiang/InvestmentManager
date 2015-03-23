package com.app.client.investment.juxianfang;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.client.investment.R;

public class FragmentForum extends Fragment implements OnClickListener {
	private View rootView;
	private ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;	
	private LinearLayout contentLayout;
	private LinearLayout navLayout;
	
	private TextView classifyTextView;
	private TextView hotspotTextView;
	private TextView module1TextView;
	private TextView module2TextView;
	private TextView module3TextView;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		rootView = inflater.inflate(R.layout.fragment_juxianfang_forum, container, false);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		initView(rootView);
		initData();
	}

	public void initView(View view) {
		mDrawerLayout = (DrawerLayout)view.findViewById(R.id.juxianfang_forum_drawer_layout);
		contentLayout = (LinearLayout)view.findViewById(R.id.juxianfang_forum_content_layout);
		navLayout = (LinearLayout)view.findViewById(R.id.juxianfang_forum_nav_layout);
		
		classifyTextView = (TextView)view.findViewById(R.id.forum_nav_classify);
		hotspotTextView = (TextView)view.findViewById(R.id.forum_nav_hotspot);
		module1TextView = (TextView)view.findViewById(R.id.forum_nav_module1);
		module2TextView = (TextView)view.findViewById(R.id.forum_nav_module2);
		module3TextView = (TextView)view.findViewById(R.id.forum_nav_module3);
		
	}
	
	public void initData() {
		classifyTextView.setOnClickListener(this);
		hotspotTextView.setOnClickListener(this);
		module1TextView.setOnClickListener(this);
		module2TextView.setOnClickListener(this);
		module3TextView.setOnClickListener(this);
		classifyTextView.performClick();
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.forum_nav_classify:
			showForumClassify();
			break ;
		case R.id.forum_nav_hotspot:
			showForumHotspot();
			break;
		case R.id.forum_nav_module1:
			showForumModule1();
			break ;
		case R.id.forum_nav_module2:
			showForumModule2();
			break;
		case R.id.forum_nav_module3:
			showForumModule3();
			break ;
		
		default:
			break;
		}
	}

	public void showForumClassify() {
		clearNavSelect();
		classifyTextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		classifyTextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
	}
	
	public void showForumHotspot() {
		clearNavSelect();
		hotspotTextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		hotspotTextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
	}
	
	public void showForumModule1() {
		clearNavSelect();
		module1TextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		module1TextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
	}
	
	public void showForumModule2() {
		clearNavSelect();
		module2TextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		module2TextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
	}
	
	public void showForumModule3() {
		clearNavSelect();
		module3TextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_select_backgound));
		module3TextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_select_textColor));
	}
	
	public void initDrawer() {
		mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
            	//getActionBar().setTitle(mTitle);        	            	
            }

            public void onDrawerOpened(View drawerView) {
            	//getActionBar().setTitle(mDrawerTitle);                       
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
	}
	
	public void clearNavSelect() {
		classifyTextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_backgound));
		hotspotTextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_backgound));
		module1TextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_backgound));
		module2TextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_backgound));
		module3TextView.setBackgroundColor(this.getResources().getColor(R.color.fundresearch_nav_backgound));
		
		classifyTextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_textColor));
		hotspotTextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_textColor));
		module1TextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_textColor));
		module2TextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_textColor));
		module3TextView.setTextColor(this.getResources().getColor(R.color.fundresearch_nav_textColor));
	}
}
