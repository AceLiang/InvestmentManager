package com.app.client.investment.juxianfang;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.client.investment.R;

public class FragmentForum extends Fragment {
	private View rootView;
	private ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;	
	private LinearLayout contentLayout;
	private LinearLayout navLayout;
	
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
	}



	public void initView(View view) {
		mDrawerLayout = (DrawerLayout)view.findViewById(R.id.juxianfang_forum_drawer_layout);
		contentLayout = (LinearLayout)view.findViewById(R.id.juxianfang_forum_content_layout);
		navLayout = (LinearLayout)view.findViewById(R.id.juxianfang_forum_nav_layout);
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
}
