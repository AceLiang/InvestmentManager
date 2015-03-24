package com.app.client.investment.manager;

import com.app.client.investment.R;
import com.app.client.investment.utils.FakeDataFactory;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.data.LineData;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class ActivityNotificationDetail extends Activity {

	
	private LineChart lineChart ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_detail);
		
		lineChart = (LineChart) findViewById(R.id.lineChart);
		
		// enable value highlighting
				lineChart.setHighlightEnabled(true);

				// enable touch gestures
				lineChart.setTouchEnabled(true);

				// enable scaling and dragging
				lineChart.setDragEnabled(true);
				lineChart.setScaleEnabled(true);
				lineChart.setDrawGridBackground(false);

				// if disabled, scaling can be done on x- and y-axis separately
				lineChart.setPinchZoom(true);

				// set an alternative background color
				lineChart.setBackgroundColor(Color.TRANSPARENT);
				
				XAxis xlLine = lineChart.getXAxis();
				xlLine.setPosition(XAxisPosition.BOTTOM);
				xlLine.setDrawAxisLine(true);
				xlLine.setDrawGridLines(true);
				
				YAxis ylLine = lineChart.getAxisLeft();
				ylLine.setDrawAxisLine(false);
				ylLine.setDrawGridLines(false);
				ylLine.setGridLineWidth(0.3f);
				ylLine.setDrawLabels(false);

				YAxis yrLine = lineChart.getAxisRight();
				yrLine.setDrawAxisLine(false);
				yrLine.setDrawGridLines(true);
				yrLine.setDrawLabels(false);
				
				FakeDataFactory factory = new FakeDataFactory();
				LineData lineData = factory.generateLineChartData();
				lineChart.setData(lineData);
				lineChart.animateXY(1500, 1500);
				lineChart.getLegend().setEnabled(false);
	}
}
