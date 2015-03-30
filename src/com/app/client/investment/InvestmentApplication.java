package com.app.client.investment;

import android.app.Application;

import com.app.client.investment.protocol.BaseProtocolManager;
import com.app.client.investment.protocol.InvestmentProtocolmanager;
import com.app.client.investment.utils.ActionBarUtil;

public class InvestmentApplication extends Application {

	
	private BaseProtocolManager protocolManager ;
	private static InvestmentApplication instance;

	@Override
	public void onCreate() {
		super.onCreate();
		protocolManager = new InvestmentProtocolmanager(this);
		instance = this;
		
		ActionBarUtil.setOverflowShowingAlways(this);
	}
	
	
	public BaseProtocolManager getProtocolManager() {
		return protocolManager;
	}
	
	public static InvestmentApplication getInstance() {
		return instance;
	}
}
