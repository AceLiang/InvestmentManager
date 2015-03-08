package com.app.client.investment.manager;

import java.util.ArrayList;

import com.app.client.investment.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
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
	private HorizontalBarChart barChartBounceRate ;

	// private Typeface tf;

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
		
		
		barChartBounceRate = (HorizontalBarChart) root.findViewById(R.id.barChartBounceRate);
		
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
		PieData data = generatePieData();
		piechartView.setData(data);

		// undo all highlights
		piechartView.highlightValues(null);

		piechartView.invalidate();
		piechartView.animateXY(1500, 1500);
		// 必须要在设置数据之后调用
		Legend l = piechartView.getLegend();
		l.setPosition(LegendPosition.RIGHT_OF_CHART);
		l.setXOffset(-15);
		
		
		
		BarData barData = generateBarChartData(3, 50);
		barChartBounceRate.setData(barData);
		barChartBounceRate.animateXY(1500, 1500);
		Legend barChartL = barChartBounceRate.getLegend();
		barChartL.setEnabled(false);
		
	}
	
	
	
	private BarData generateBarChartData(int count, float range) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add("白石投资");
        }

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < count; i++) {
            float mult = (range + 1);
            float val = (float) (Math.random() * mult);
            
            if( i == 2){
            	val = - val ;
            }
            yVals1.add(new BarEntry(val, i));
        }

        BarDataSet set1 = new BarDataSet(yVals1, "DataSet");
        set1.setBarSpacePercent(35f);

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(10f);

        return data ;
    }

	/**
	 * generates less data (1 DataSet, 4 values)
	 * 
	 * @return
	 */
	protected PieData generatePieData() {

		int count = 4;

		ArrayList<Entry> entries1 = new ArrayList<Entry>();
		ArrayList<String> xVals = new ArrayList<String>();

		xVals.add("Quarter 1");
		xVals.add("Quarter 2");
		xVals.add("Quarter 3");
		xVals.add("Quarter 4");

		for (int i = 0; i < count; i++) {
			xVals.add("entry" + (i + 1));

			entries1.add(new Entry((float) (Math.random() * 60) + 40, i));
		}

		PieDataSet ds1 = new PieDataSet(entries1, "Quarterly Revenues 2014");
		ds1.setColors(ColorTemplate.VORDIPLOM_COLORS);
		ds1.setSliceSpace(2f);

		PieData d = new PieData(xVals, ds1);
		// d.setValueTypeface(tf);
		return d;
	}
}
