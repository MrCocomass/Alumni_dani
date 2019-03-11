package com.example.alumnos.alumni.Fragments.PanelFragments;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alumnos.alumni.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Asistance_Fragment extends Fragment {

    private static String TAG = "Asistance_Fragment";


    //porcentaje de asistencia que recibimos
    private float[] yData = {64.6f, 26.4f, 9f};

    //tipo de asistencia
    private String[] xData = {"Si", "No", "Tarde"};

    PieChart pieChart;

    View view;



    public Asistance_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_asistance, container, false);


        initFragment();
        return  view;

    }




    public void initFragment()
    {
        pieChart = view.findViewById(R.id.idPieChart);
        pieChart.setDescription("Asistencia ");
        //rotación del PieChart
        pieChart.setRotationEnabled(true);
        //porcentaje del centro que ocupa el texto
        pieChart.setCenterTextRadiusPercent(60);
        //radio del círculo central
        pieChart.setHoleRadius(45);
        //pieChart.setTransparentCircleAlpha(0);

        //título central
        pieChart.setCenterText("ASISTENCIA ALUMNOS");
        //tamaño del título central
        pieChart.setCenterTextSize(10);

        //pieChart.setDrawEntryLabels(true);

        addDataSet();
    }

    private void addDataSet() {ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for (int i = 0; i < yData.length; i++){
            yEntrys.add(new PieEntry(yData[i],i));
        }

        for (int i = 1; i < xData.length; i++){
            xEntrys.add(xData[i]);
        }

        //created the data set

        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Asistencia");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(20);



        //add colors to dataset

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(61, 163, 107));
        colors.add(Color.rgb(208, 12, 36));
        colors.add(Color.rgb(242, 131, 25));

        pieDataSet.setColors(colors);

        //add legend to chart - - - - - Leyenda de colores
        //Legend legend = pieChart.getLegend();
        //legend.setForm(Legend.LegendForm.CIRCLE);
        //legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object


        PieData pieData = new PieData(pieDataSet);
        pieData.setValueFormatter(new PercentFormatter(new DecimalFormat("0.#")));
        pieChart.setData(pieData);
        pieChart.invalidate();



    }



}
