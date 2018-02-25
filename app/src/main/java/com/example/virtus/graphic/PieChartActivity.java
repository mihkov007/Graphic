package com.example.virtus.graphic;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

public class PieChartActivity extends AppCompatActivity {

    private PieChart mChart;

    private float[] xData = {5.0f, 10.0f, 15.0f, 30.0f, 40.0f};
    private String[] yData = {"", "", "Алина Ш", "", "Михаил К"};

    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        setTitle("PieChart");
        btn2 = (Button) findViewById(R.id.btn2);
        mChart = (PieChart) findViewById(R.id.chart1);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), HorizontalBarChartActivity.class);
                startActivity(intent);
            }
        });

        // enable hole and configure
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleRadius(7);
        mChart.setTransparentCircleRadius(10);

        // enable rotation of the chart by touch
        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                if (e == null)
                    return;

                float xf = e.getX();
                float yf = e.getY();

                Toast.makeText(getApplicationContext(), "xf = " + String.valueOf(xf) + ", yf = " + String.valueOf(yf), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        // add data
        addData();

        // customize legends
        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);

    }

    private void addData() {

        List<PieEntry> pieEntry = new ArrayList<PieEntry>();
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

        mChart.setData(data);


        // undo all highlights
        mChart.highlightValues(null);
        // update pie chart
        mChart.invalidate();
    }

}
