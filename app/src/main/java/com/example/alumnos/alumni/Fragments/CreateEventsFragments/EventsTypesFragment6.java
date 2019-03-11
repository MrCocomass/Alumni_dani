package com.example.alumnos.alumni.Fragments.CreateEventsFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alumnos.alumni.Api.GlobalRequests;
import com.example.alumnos.alumni.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsTypesFragment6 extends Fragment implements View.OnClickListener {



    Button buttonCreateEvent;
    GlobalRequests globalRequests;

    public EventsTypesFragment6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d ( "hola que ase","EVENTS TYPES FRAGMENT 6" );

        View view = inflater.inflate(R.layout.events_types_fragment6, container, false);

        buttonCreateEvent = view.findViewById ( R.id.botonCrearEvento);
        buttonCreateEvent.setOnClickListener (this);

         globalRequests = new GlobalRequests ();


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonCrearEvento:
                Log.d ( "CREAR EVENT","SE VA A CREAR EL EVENTO" );

                globalRequests.CreateEvent ();

                break;
        }
    }
}
