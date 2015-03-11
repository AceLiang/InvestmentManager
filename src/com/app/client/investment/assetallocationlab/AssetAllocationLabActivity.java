package com.app.client.investment.assetallocationlab;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.client.investment.R;

public class AssetAllocationLabActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_assetallocationlab);
	}

	public void toRisKAnalysis(View view) {
		Intent intent = new Intent(this, RiskAnalysisActivity.class);
		startActivity(intent);
	}
}
