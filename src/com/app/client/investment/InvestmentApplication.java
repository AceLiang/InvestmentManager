package com.app.client.investment;

import com.app.client.investment.protocol.BaseProtocolManager;
import com.app.client.investment.protocol.InvestmentProtocolmanager;

import android.app.Application;

public class InvestmentApplication extends Application {

	
	private BaseProtocolManager protocolManager ;

	@Override
	public void onCreate() {
		super.onCreate();
		protocolManager = new InvestmentProtocolmanager(this);
	}
	
	
	public BaseProtocolManager getProtocolManager() {
		return protocolManager;
	}
	
}
