package com.app.client.investment.protocol;

import java.util.HashMap;
import java.util.Map;


import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;

public class LoginRequest extends StringRequest {
	
	private Map<String, String> mParams;

	public LoginRequest(int type , String url, Listener<String> listener,
			ErrorListener errorListener) {
		super(type , url, listener, errorListener);
//		Method.POST
        mParams = new HashMap<String, String>() ;
        mParams.put("paramOne", "");
        mParams.put("paramTwo", "");
	}

	
	@Override
    public Map<String, String> getParams() {
        return mParams;
    }


}
