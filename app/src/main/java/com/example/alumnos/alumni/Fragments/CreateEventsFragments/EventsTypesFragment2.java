package com.example.alumnos.alumni.Fragments.CreateEventsFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsTypesFragment2 extends Fragment implements View.OnClickListener {


    public static Integer id_group ;

    RadioButton radioButtonTeachers;
    RadioButton radioButtonCordinators;
    RadioButton radioButtonAlumnos;
    RadioButton radioButtonExstudents;



    public EventsTypesFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.events_types_fragment2, container, false);

        radioButtonTeachers = view.findViewById ( R.id.radioButtonProfesores);
        radioButtonTeachers.setOnClickListener(this);

        radioButtonCordinators = view.findViewById ( R.id.radioButtonCoordinadores);
        radioButtonCordinators.setOnClickListener(this);

        radioButtonAlumnos = view.findViewById ( R.id.radioButtonAlumnos);
        radioButtonAlumnos.setOnClickListener(this);

        radioButtonExstudents = view.findViewById ( R.id.radioButtonExAlumnos);
        radioButtonExstudents.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.radioButtonProfesores:
                Log.d ( "Noticias","ha echo clock en profesores" );
                radioButtonTeachers.setChecked (true);
                id_group = 1;
                break;
            case R.id.radioButtonCoordinadores:
                Log.d ( "trabajo","ha echo clock en cordinadores" );
                radioButtonCordinators.setChecked ( true );
                id_group = 2;
                break;
            case R.id.radioButtonAlumnos:
                Log.d ( "notificaciones","ha echo clock en alumnos" );
                radioButtonAlumnos.setChecked ( true );
                id_group = 3;
                break;
            case R.id.radioButtonExAlumnos:
                Log.d ( "eventos..","ha echo clock en exestudiantes" );
                radioButtonExstudents.setChecked ( true );
                id_group = 4;
                break;
        }




    }
}
