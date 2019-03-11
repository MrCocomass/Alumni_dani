package com.example.alumnos.alumni.Fragments.CreateEventsFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.alumnos.alumni.Activities.CreateEventsActivity;
import com.example.alumnos.alumni.Activities.DetailEventActivity;
import com.example.alumnos.alumni.Activities.MainMenuActivity;
import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.R;

import java.util.ArrayList;

import static com.example.alumnos.alumni.Activities.CreateEventsActivity.PlaceholderFragment.newInstance;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventTypesFragment extends Fragment implements View.OnClickListener {


    //public static ArrayList<Event> eventsArrayList = new ArrayList();
    public static Integer idTypeEvent;

    ViewPager mViewPager;
    RadioButton radioButtonNews;
    RadioButton radioButtonWork;
    RadioButton radioButtonNotify;
    RadioButton radioButtonEvents;




    public EventTypesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_types, container, false);

        mViewPager = view.findViewById ( R.id.container);


        radioButtonNews = view.findViewById ( R.id.radioButtonNews );
        radioButtonNews.setOnClickListener(this);

        radioButtonWork = view.findViewById(R.id.radioButtonWorks);
        radioButtonWork.setOnClickListener(this);

        radioButtonNotify = view.findViewById ( R.id.radioButtonNotification);
        radioButtonNotify.setOnClickListener(this);

        radioButtonEvents = view.findViewById ( R.id.radioButtonEventsType);
        radioButtonEvents.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        radioButtonNews.setChecked ( false );
        radioButtonWork.setChecked ( false );
        radioButtonNotify.setChecked ( false );
        radioButtonEvents.setChecked ( false );


        switch (v.getId()) {
            case R.id.radioButtonNews:
                Log.d ( "Noticias","ha echo clock en noticias" );
                radioButtonNews.setChecked ( true );
                idTypeEvent = 1;
                //eventsArrayList.add ( new Event ("","","","","","","","","","","",""));
                break;
            case R.id.radioButtonWorks:
                Log.d ( "trabajo","ha echo clock en event" );
                radioButtonWork.setChecked ( true );
                idTypeEvent = 2;
                break;
            case R.id.radioButtonNotification:
                Log.d ( "notificaciones","ha echo clock en notification" );
                radioButtonNotify.setChecked ( true );
                idTypeEvent = 3;
                break;
            case R.id.radioButtonEventsType:
                Log.d ( "eventos..","ha echo clock en notification" );
                radioButtonEvents.setChecked ( true );
                idTypeEvent = 4;
                break;
        }

    }




}
