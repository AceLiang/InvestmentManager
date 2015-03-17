package com.app.client.investment.protocol;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;

import android.content.Context;

public class InvestmentProtocolmanager extends BaseProtocolManager {

	public InvestmentProtocolmanager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	public void doLoginRequest(final IResponseListener responseListener) {
		LoginRequest request = new LoginRequest(Method.POST, "http://xxxx.com", new Response.Listener<String>() {

			@Override
			public void onResponse(String string) {
				responseListener.onSuccessful(string);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				responseListener.onFailed(error);
			}
		});
		//÷¥––«Î«Û
		addRequest(request);
	}
}
