package com.example.alumnos.alumni.Fragments.CreateEventsFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsTypesFragment3 extends Fragment {

    public static String eventTile;
    public static String eventDescription;

     static EditText editTitle;
     static EditText editDesc;


    public EventsTypesFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events_types_fragment3, container, false);

        Log.d ( "TITULO","SE ESTA LANZADO EL TITULO DEL EVENTO" );
        editTitle = view.findViewById ( R.id.titleEditText);
        editDesc = view.findViewById ( R.id.descriptionEditText );
        return view;
    }

    public static void keepAllDates()
    {
        Log.d ( "TITULO", "GUARANDO DATOS" );
        eventTile = editTitle.getText ().toString ();
        eventDescription = editDesc.getText ().toString ();
    }


    public static void checkAlldates()
    {

    }


}
