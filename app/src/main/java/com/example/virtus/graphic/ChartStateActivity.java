package com.example.virtus.graphic;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ChartStateActivity extends AppCompatActivity {

    private HorizontalBarChart horizontalBarChart_test;
    private PieChart pieChart_test;

    private float[] xData = {5.0f, 10.0f, 15.0f, 30.0f, 40.0f};
    private String[] yData = {"", "", "Алина Ш", "", "Михаил К"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_state);

        setTitle("HorizontalBar PieChart");


        int y = 12;
        Log.d("TEG1", String.valueOf(y));

        horizontalBarChart_test = (HorizontalBarChart) findViewById(R.id.horizontalBarChart_test);
        pieChart_test = (PieChart) findViewById(R.id.pieChart_test);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ HorizontalBarChart
        /*
            1) передаем в BarDataSet список ArrayList<BarEntry>
            2) устанавливаем цвета
            3) добавляем в список ArrayList<IBarDataSet> -> BarDataSet
            4) передаем список ArrayList<IBarDataSet> в BarData
            5) вызываем setDate()
         */
        BarDataSet set1 = new BarDataSet(getDataSet(), "The year 2017");
        set1.setColors(Color.parseColor("#F78B5D"), Color.parseColor("#FCB232"), Color.parseColor("#FDD930"), Color.parseColor("#ADD137"), Color.parseColor("#A0C25A"));
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        // hide Y-axis
        YAxis left = horizontalBarChart_test.getAxisLeft();
        left.setDrawLabels(false);
        // custom X-axis labels
        String[] values = new String[] { "1 star", "2 stars", "3 stars", "4 stars", "5 stars"};
        XAxis xAxis = horizontalBarChart_test.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));
        horizontalBarChart_test.setData(data);
        // custom description
        Description description = new Description();
        description.setText("Rating");
        horizontalBarChart_test.setDescription(description);
        // hide legend
        horizontalBarChart_test.getLegend().setEnabled(false);
        horizontalBarChart_test.animateY(1000);
        horizontalBarChart_test.invalidate();
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PieChart
        // enable hole and configure
        pieChart_test.setDrawHoleEnabled(true);
        pieChart_test.setHoleRadius(7);
        pieChart_test.setTransparentCircleRadius(10);
        // enable rotation of the chart by touch
        pieChart_test.setRotationAngle(0);
        pieChart_test.setRotationEnabled(true);

        pieChart_test.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                if (e == null)
                    return;

                float xf = e.getX();
                float yf = e.getY();

                Toast.makeText(getApplicationContext(), "xf = " + String.valueOf(xf) + ", yf = " + String.valueOf(yf), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() { }
        });
        // add data
        addData();
        // customize legends
        Legend l = pieChart_test.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }

    /**
     * Данные для PieChart
     */
    private void addData() {

        List<PieEntry> pieEntry = new ArrayList<>();
        for (int i = 0; i < yData.length; i++)
            pieEntry.add(new PieEntry(xData[i], yData[i]));


//        ArrayList<String> yVals = new ArrayList<String>();
//        for (int i = 0; i < yData.length; i++)
//            yVals.add(yData[i]);


        // create pie data set
        PieDataSet dataSet = new PieDataSet(pieEntry, ""); // Успеваемость студентов
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);
        // add many colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);

        // instantiate pie data object now
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.GRAY);

        pieChart_test.setData(data);


        // undo all highlights
        pieChart_test.highlightValues(null);
        // update pie chart
        pieChart_test.invalidate();
    }

    /**
     * Возвращает данные для горизонтального графика
     * @return
     */
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


}
