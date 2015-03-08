package com.app.client.investment.manager;

import java.util.ArrayList;

import android.graphics.Color;

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

public class FakeDataFactory {

	
	public LineData generateLineChartData() {
		int count = 20 ;
		int range = 30 ;
		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			xVals.add((i) + "");
		}

		ArrayList<Entry> yVals1 = new ArrayList<Entry>();

		for (int i = 0; i < count; i++) {
			float mult = range / 2f;
			float val = (float) (Math.random() * mult) + 50;// + (float)
															// ((mult *
															// 0.1) / 10);
			yVals1.add(new Entry(val, i));
		}

		// create a dataset and give it a type
		LineDataSet set1 = new LineDataSet(yVals1, "DataSet 1");
		set1.setAxisDependency(AxisDependency.LEFT);
		set1.setColor(ColorTemplate.getHoloBlue());
		set1.setCircleColor(ColorTemplate.getHoloBlue());
		set1.setLineWidth(2f);
		set1.setCircleSize(4f);
		set1.setFillAlpha(65);
		set1.setFillColor(ColorTemplate.getHoloBlue());
		set1.setHighLightColor(Color.rgb(244, 117, 117));
		set1.setDrawFilled(true);
        set1.setDrawCircles(false);
		ArrayList<Entry> yVals2 = new ArrayList<Entry>();

		for (int i = 0; i < count; i++) {
			float mult = range;
			float val = (float) (Math.random() * mult) + 450;// + (float)
																// ((mult *
																// 0.1) / 10);
			yVals2.add(new Entry(val, i));
		}

		ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
		dataSets.add(set1);

		// create a data object with the datasets
		LineData data = new LineData(xVals, dataSets);
		data.setValueTextColor(Color.BLACK);
		data.setValueTextSize(9f);

		return data;
	}

	public BarData generateBarChartData(int count, float range) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			xVals.add("°×Ê¯Í¶×Ê");
		}

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

		for (int i = 0; i < count; i++) {
			float mult = (range + 1);
			float val = (float) (Math.random() * mult);

			if (i == 2) {
				val = -val;
			}
			yVals1.add(new BarEntry(val, i));
		}

		BarDataSet set1 = new BarDataSet(yVals1, "DataSet");
		set1.setBarSpacePercent(35f);

		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);

		BarData data = new BarData(xVals, dataSets);
		data.setValueTextSize(10f);

		return data;
	}

	/**
	 * generates less data (1 DataSet, 4 values)
	 * 
	 * @return
	 */
	public PieData generatePieData() {

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
	
	public LineData generateLineChartData(int count, float range) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add((1990 +i) + "");
        }

        ArrayList<Entry> vals1 = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float mult = (range + 1);
            float val = (float) (Math.random() * mult) + 20;// + (float)
                                                           // ((mult *
                                                           // 0.1) / 10);
            vals1.add(new Entry(val, i));
        }
        
        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(vals1, "DataSet 1");
        set1.setDrawCubic(true);
        set1.setCubicIntensity(0.2f);
        set1.setDrawFilled(true);
        set1.setDrawCircles(false); 
        set1.setLineWidth(2f);
        set1.setCircleSize(5f);
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setColor(Color.rgb(104, 241, 175));
        set1.setFillColor(ColorTemplate.getHoloBlue());

        // create a data object with the datasets
        LineData data = new LineData(xVals, set1);
        data.setValueTextSize(9f);
        data.setDrawValues(false);

        return data;
    }
}
