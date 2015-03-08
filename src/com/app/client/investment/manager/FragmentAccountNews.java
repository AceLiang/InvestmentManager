package com.app.client.investment.manager;

import java.util.ArrayList;

import com.app.client.investment.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.PercentFormatter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/********
 * 
 * @author 明礼 账户动态
 */
public class FragmentAccountNews extends Fragment {

	private Button btnWeekChart;
	private Button btnMonthChart;
	private Button btnAllChart;

	private PieChart piechartView;
	private HorizontalBarChart barChartBounceRate;
	private LineChart lineChart;

	// private Typeface tf;
	
	FakeDataFactory factory = new FakeDataFactory() ;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// tf = Typeface.DEFAULT ;
		View root = inflater.inflate(R.layout.fragment_account_new, container,
				false);

		initViews(root);
		initListener();
		initData();

		return root;
	}

	private void initViews(View root) {
		// TODO Auto-generated method stub
		btnWeekChart = (Button) root.findViewById(R.id.btnWeekChart);
		btnMonthChart = (Button) root.findViewById(R.id.btnMonthChart);
		btnAllChart = (Button) root.findViewById(R.id.btnAllChart);

		piechartView = (PieChart) root.findViewById(R.id.piechartView);
		piechartView.setUsePercentValues(true);

		// change the color of the center-hole
		// mChart.setHoleColor(Color.rgb(235, 235, 235));
		piechartView.setHoleColorTransparent(true);
		piechartView.setCenterText("22222\n总资产");

		piechartView.setNoDataText("暂无数据");
		piechartView.setDescription("");
		piechartView.setCenterTextSize(22f);

		// radius of the center hole in percent of maximum radius
		piechartView.setHoleRadius(45f);
		piechartView.setTransparentCircleRadius(50f);

		barChartBounceRate = (HorizontalBarChart) root
				.findViewById(R.id.barChartBounceRate);

		barChartBounceRate.setDrawBarShadow(false);

		barChartBounceRate.setDrawValueAboveBar(true);

		barChartBounceRate.setDescription("");

		// if more than 60 entries are displayed in the chart, no values will be
		// drawn
		barChartBounceRate.setMaxVisibleValueCount(60);

		// scaling can now only be done on x- and y-axis separately
		barChartBounceRate.setPinchZoom(false);

		// draw shadows for each bar that show the maximum value
		// mChart.setDrawBarShadow(true);

		// mChart.setDrawXLabels(false);

		barChartBounceRate.setDrawGridBackground(false);

		// mChart.setDrawYLabels(false);

		XAxis xl = barChartBounceRate.getXAxis();
		xl.setPosition(XAxisPosition.BOTTOM);
		xl.setDrawAxisLine(false);
		xl.setDrawGridLines(false);
		xl.setGridLineWidth(0.3f);
		// xl.setEnabled(false);

		YAxis yl = barChartBounceRate.getAxisLeft();
		yl.setDrawAxisLine(false);
		yl.setDrawGridLines(false);
		yl.setGridLineWidth(0.3f);
		yl.setStartAtZero(false);
		yl.setDrawLabels(false);

		YAxis yr = barChartBounceRate.getAxisRight();
		yr.setDrawAxisLine(false);
		yr.setDrawGridLines(false);
		yr.setStartAtZero(false);
		yr.setDrawLabels(false);

		lineChart = (LineChart) root.findViewById(R.id.lineChart);

		// no description text
		lineChart.setDescription("");
		lineChart
				.setNoDataTextDescription("You need to provide data for the chart.");

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

	}

	private void initListener() {
		// TODO Auto-generated method stub
		btnWeekChart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				initData();
			}
		});

		btnMonthChart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				initData();
			}
		});

		btnAllChart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				initData();
			}
		});
	}

	private void initData() {
		// TODO Auto-generated method stub
		PieData data = factory.generatePieData();
		piechartView.setData(data);

		// undo all highlights
		piechartView.highlightValues(null);

		piechartView.invalidate();
		piechartView.animateXY(1500, 1500);
		// 必须要在设置数据之后调用
		Legend l = piechartView.getLegend();
		l.setPosition(LegendPosition.RIGHT_OF_CHART);
		l.setXOffset(-15);

		BarData barData = factory.generateBarChartData(3, 50);
		barChartBounceRate.setData(barData);
		barChartBounceRate.animateXY(1500, 1500);
		Legend barChartL = barChartBounceRate.getLegend();
		barChartL.setEnabled(false);
		
		
		LineData lineData = factory.generateLineChartData();
		lineChart.setData(lineData);
		lineChart.animateXY(1500, 1500);
		lineChart.getLegend().setEnabled(false);

	}

	
}
