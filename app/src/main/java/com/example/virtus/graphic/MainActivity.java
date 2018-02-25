package com.example.virtus.graphic;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("LineChart");

        LineChart chart = (LineChart) findViewById(R.id.chart);
        btn1 = (Button) findViewById(R.id.btn1);

        int[] a = new int[40];
        int value = -20;
        for(int i = 0; i < 40; i++){
            a[i] = value + i;
        }
        List<Entry> entries = new ArrayList<>();
        for(int i : a){
            entries.add(new Entry((float)i, (float)i*i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "Парабола");
        lineDataSet.setColor(Color.MAGENTA);
        LineData data = new LineData(lineDataSet);
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        chart.setData(data);
        chart.invalidate();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), PieChartActivity.class);
                startActivity(intent);
            }
        });
    }
}
