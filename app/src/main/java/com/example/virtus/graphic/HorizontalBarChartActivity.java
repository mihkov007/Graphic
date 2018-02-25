package com.example.virtus.graphic;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


class MyXAxisValueFormatter implements IAxisValueFormatter {

    private String[] mValues;



    public MyXAxisValueFormatter(String[] values) {
        this.mValues = values;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mValues[(int) value];
    }

}

public class HorizontalBarChartActivity extends AppCompatActivity {

    private Button btn3;
    private HorizontalBarChart horizontalBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_bar_chart);

        horizontalBarChart = (HorizontalBarChart) findViewById(R.id.horizontalBarChart);


        btn3 = (Button) findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), ChartStateActivity.class);
                startActivity(intent);
            }
        });

        BarDataSet set1;
        set1 = new BarDataSet(getDataSet(), "The year 2017");

        set1.setColors(Color.parseColor("#F78B5D"), Color.parseColor("#FCB232"), Color.parseColor("#FDD930"), Color.parseColor("#ADD137"), Color.parseColor("#A0C25A"));

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);

        // hide Y-axis
        YAxis left = horizontalBarChart.getAxisLeft();
        left.setDrawLabels(false);

        // custom X-axis labels
        String[] values = new String[] { "1 star", "2 stars", "3 stars", "4 stars", "5 stars"};
        XAxis xAxis = horizontalBarChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));

        horizontalBarChart.setData(data);

        // custom description
        Description description = new Description();
        description.setText("Rating");
        horizontalBarChart.setDescription(description);

        // hide legend
        horizontalBarChart.getLegend().setEnabled(false);

        horizontalBarChart.animateY(1000);
        horizontalBarChart.invalidate();











        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // scaling can now only be done on x- and y-axis separately
////        horizontalBarChart.setPinchZoom(false);
        // draw shadows for each bar that show the maximum value
        // mChart.setDrawBarShadow(true);
////        horizontalBarChart.setDrawGridBackground(false);

        // draw shadows for each bar that show the maximum value
        // mChart.setDrawBarShadow(true);

 ///       horizontalBarChart.setDrawGridBackground(false);

//        XAxis xl = horizontalBarChart.getXAxis();
//        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xl.setDrawAxisLine(true);
//        xl.setDrawGridLines(false);
//        xl.setGranularity(10f);
//
//        YAxis yl = horizontalBarChart.getAxisLeft();
//        yl.setDrawAxisLine(true);
//        yl.setDrawGridLines(true);
//        yl.setAxisMinimum(0f); // this replaces setStartAtZero(true)
////        yl.setInverted(true);
//
//        YAxis yr = horizontalBarChart.getAxisRight();
//        yr.setDrawAxisLine(true);
//        yr.setDrawGridLines(false);
//        yr.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//        yr.setInverted(true);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        /*
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();

        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);
        BarEntry test = new BarEntry(70.00f, 7);
        valueSet1.add(test);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");

        barDataSet1.setColor(Color.rgb(0, 155, 0));

        BarData data = new BarData(barDataSet1); // BarData(barDataSet1);


        String[] values = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Test"};
        XAxis xAxis = horizontalBarChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));

        horizontalBarChart.setData(data);
        Description desc = new Description();
        desc.setText("Успеваемость студентов");
        horizontalBarChart.setDescription(desc);
        horizontalBarChart.animateXY(2000, 2000);
        horizontalBarChart.invalidate();

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        Legend l = horizontalBarChart.getLegend();
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
//        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
//        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//        l.setDrawInside(false);
//        l.setFormSize(8f);
//        l.setXEntrySpace(4f);
*/
    }

    private ArrayList<BarEntry> getDataSet() {

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();

        BarEntry v1e2 = new BarEntry(1, 4341f);
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(2, 3121f);
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(3, 5521f);
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(4, 10421f);
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(5, 27934f);
        valueSet1.add(v1e6);

        return valueSet1;
    }

    private ArrayList<String> getXAxisValues() {

        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }

    private void setData(int count, float range) {

        float barWidth = 9f;
        float spaceForBar = 10f;
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

//        for (int i = 0; i < count; i++) {
//            float val = (float) (Math.random() * range);
//            yVals1.add(new BarEntry(i * spaceForBar, val,
//                    getResources().getDrawable(R.drawable.star)));
//        }

        BarDataSet set1;

        if (horizontalBarChart.getData() != null &&
                horizontalBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet)horizontalBarChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            horizontalBarChart.getData().notifyDataChanged();
            horizontalBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "DataSet 1");

            set1.setDrawIcons(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(barWidth);
            horizontalBarChart.setData(data);
        }
    }


//    private ArrayList<BarDataSet> getDataSet(){
//
//        ArrayList<BarDataSet> dataSets = null;
//
//        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
//        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
//        valueSet1.add(v1e1);
//        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
//        valueSet1.add(v1e2);
//        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
//        valueSet1.add(v1e3);
//        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
//        valueSet1.add(v1e4);
//        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
//        valueSet1.add(v1e5);
//        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
//        valueSet1.add(v1e6);
//
////        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
////        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
////        valueSet2.add(v2e1);
////        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
////        valueSet2.add(v2e2);
////        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
////        valueSet2.add(v2e3);
////        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
////        valueSet2.add(v2e4);
////        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
////        valueSet2.add(v2e5);
////        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
////        valueSet2.add(v2e6);
//
//        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
//        barDataSet1.setColor(Color.rgb(0, 155, 0));
//        //BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
//        //barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
//
//        dataSets = new ArrayList<>();
//        dataSets.add(barDataSet1);
//        //dataSets.add(barDataSet2);
//        return dataSets;
//    }
}
