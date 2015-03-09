package com.app.client.investment.fundresearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.client.investment.R;
import com.app.client.investment.utils.FakeDataFactory;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.PieData;
/**
 * @author 简建鸿
 * 业绩表现
 */
public class FragmentPerFormance extends Fragment {

	private PieChart piechartView;
	private LineChart mChart;
	
	FakeDataFactory factory = new FakeDataFactory() ;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View root = inflater.inflate(R.layout.fragment_fundresearch_performance, container, false);
		
		piechartView = (PieChart) root.findViewById(R.id.fundresearch_performance_piechartView);
		mChart = (LineChart) root.findViewById(R.id.fundresearch_lineChartView);
		
		initViews(root);
		
		return root;
	}

	private void initViews(View root) {
		// TODO Auto-generated method stub
		
		initPieChart();

		initLineChart();

	}
	
	private void initPieChart() {		
		piechartView.setUsePercentValues(true);

		// change the color of the center-hole
		// mChart.setHoleColor(Color.rgb(235, 235, 235));
		piechartView.setHoleColorTransparent(true);
		piechartView.setCenterText("240\n累计收益率排名");

		piechartView.setNoDataText("暂无数据");
		piechartView.setDescription("");
		piechartView.setCenterTextSize(22f);

		// radius of the center hole in percent of maximum radius
		piechartView.setHoleRadius(45f);
		piechartView.setTransparentCircleRadius(50f);
		
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
	}
	
	private void initLineChart() {
		// no description text
        mChart.setDescription("");

        // enable value highlighting
        mChart.setHighlightEnabled(true);

        // enable touch gestures
        mChart.setTouchEnabled(true);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);
        LineData lineData = factory.generateLineChartData(45, 100);
		mChart.setData(lineData);
		mChart.getLegend().setEnabled(false);        
        mChart.animateXY(2000, 2000);
        // dont forget to refresh the drawing
        mChart.invalidate();
	}
}
