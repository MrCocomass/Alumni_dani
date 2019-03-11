package com.example.alumnos.alumni.Fragments.PanelFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.alumnos.alumni.Adapters.MyAdapter;
import com.example.alumnos.alumni.Api.GlobalRequests;
import com.example.alumnos.alumni.R;


import com.example.alumnos.alumni.Models.Notas;

import java.util.ArrayList;
import com.example.alumnos.alumni.Adapters.NotasListAdapter;



public class Notes_Fragment extends Fragment {

    NotasListAdapter notasListAdapter;

    public Notes_Fragment() {
        // Required empty public constructor
    }

    public static ArrayList<Notas> notasArrayList = new ArrayList<Notas>();
    public static ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        listView = view.findViewById(R.id.listaNotas);
        GlobalRequests globalRequests = new GlobalRequests();
        globalRequests.setNotasListener ( new GlobalRequests.NotasListener () {
            @Override
            public void onGetNotasFinish() {
                notasListAdapter = new NotasListAdapter(getActivity().getApplicationContext(), R.layout.notes_item, notasArrayList);
                listView.setAdapter(notasListAdapter);
            }
        } );
        globalRequests.getlistOfNotas();



        return view;
    }

}
