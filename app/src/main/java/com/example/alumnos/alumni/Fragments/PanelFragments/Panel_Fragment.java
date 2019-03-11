package com.example.alumnos.alumni.Fragments.PanelFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alumnos.alumni.Adapters.ViewPageAdapter;
import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Panel_Fragment extends Fragment {

    public static ArrayList <Fragment> fragmentsList = new ArrayList();


    public Panel_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_panel_, container, false);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        setUpViewPager(viewPager);

        TabLayout tabs = view.findViewById(R.id.tabPanel);
        tabs.setupWithViewPager(viewPager);
        Log.d("****", "PANEL CREATE");


        return view;
    }


    private void setUpViewPager(ViewPager viewPager)
    {

        fragmentsList.add(new Calendar_Fragment());
        fragmentsList.add(new Asistance_Fragment());
        fragmentsList.add(new Notes_Fragment());

        ViewPageAdapter adapter = new ViewPageAdapter(getFragmentManager());
        adapter.addFragment(fragmentsList.get(0),"CALENDARIO");
        adapter.addFragment(fragmentsList.get(1),"ASISTENCIA");
        adapter.addFragment(fragmentsList.get(2),"NOTAS");
        viewPager.setAdapter(adapter);

    }

    public void destroy(){
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().remove(fragmentsList.get(0)).commit();
            getFragmentManager().beginTransaction().remove(fragmentsList.get(1)).commit();
            getFragmentManager().beginTransaction().remove(fragmentsList.get(2)).commit();
        }


    }



}

