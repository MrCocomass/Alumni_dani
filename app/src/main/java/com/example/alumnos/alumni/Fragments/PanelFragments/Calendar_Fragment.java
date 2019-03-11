package com.example.alumnos.alumni.Fragments.PanelFragments;



import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.alumnos.alumni.Adapters.HwAdapter;
import com.example.alumnos.alumni.HomeCollection;

import com.example.alumnos.alumni.R;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.EventsTypesFragment3.eventDescription;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.EventsTypesFragment3.eventTile;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.EventTypesFragment.idTypeEvent;

public class Calendar_Fragment extends Fragment {
    public GregorianCalendar cal_month, cal_month_copy;
    private HwAdapter hwAdapter;
    private TextView tv_month;
    private String tipo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //switch (idTypeEvent){
          //  case 1: tipo = "Evento";
            //    break;
            //case 2: tipo = "Oferta de trabajo";
              //  break;
            //case 3: tipo = "Notificación";
              //  break;
            //case 4: tipo = "Noticias";
              //  break;
        //}

        View view = inflater.inflate(R.layout.fragment_calendary, container, false);

        HomeCollection.date_collection_arr=new ArrayList<HomeCollection>();
//        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-11" ,"weekly off","Holiday","this is holiday"));
//        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-11" ,"Events","Holiday","this is holiday"));
//        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-11" ,"Dasahara","Holiday","this is holiday"));
          HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-12" ,eventTile,tipo,eventDescription));



        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        hwAdapter = new HwAdapter(this, cal_month, HomeCollection.date_collection_arr);
        tv_month = (TextView) view.findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));


        ImageButton previous = (ImageButton) view.findViewById(R.id.ib_prev);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cal_month.get(GregorianCalendar.MONTH) == 4&&cal_month.get(GregorianCalendar.YEAR)==2017) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);

                }
                else {
                    setPreviousMonth();
                    refreshCalendar();
                }


            }
        });
        ImageButton next = (ImageButton) view.findViewById(R.id.Ib_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cal_month.get(GregorianCalendar.MONTH) == 5&&cal_month.get(GregorianCalendar.YEAR)==2018) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
                }
                else {
                    setNextMonth();
                    refreshCalendar();
                }
            }
        });
        GridView gridview = (GridView) view.findViewById(R.id.gv_calendar);
        gridview.setAdapter(hwAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String selectedGridDate = HwAdapter.day_string.get(position);
                ((HwAdapter) parent.getAdapter()).getPositionList(selectedGridDate, getActivity());
            }

        });
        return view;
    }
    protected void setNextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    protected void setPreviousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) - 1);
        }
    }

    public void refreshCalendar() {
        hwAdapter.refreshDays();
        hwAdapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }
}
