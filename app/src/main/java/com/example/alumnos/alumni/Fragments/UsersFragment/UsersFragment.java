package com.example.alumnos.alumni.Fragments.UsersFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alumnos.alumni.Activities.MainMenuActivity;
import com.example.alumnos.alumni.Activities.ProfileDetailActivity;
import com.example.alumnos.alumni.Adapters.MyAdapter;
import com.example.alumnos.alumni.Adapters.UsersListAdapter;
import com.example.alumnos.alumni.Adapters.ViewPageAdapter;
import com.example.alumnos.alumni.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment implements View.OnClickListener {

    public ListView usersListView;
    public List<String> names;

    public List<String> groups;
    public List<String> amigos;
    public List<String> solicitudes;

    Button allUsersBtn;
    Button usersGroupsBtn;
    Button friendsBtn;
    Button usersRequestsBtn;

    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_users, container, false);
        hardcodearDatos();

        allUsersBtn = view.findViewById(R.id.topBtnAllusers);
        allUsersBtn.setOnClickListener(this);

        usersGroupsBtn = view.findViewById(R.id.topBtnUserGroups);
        usersGroupsBtn.setOnClickListener(this);

        friendsBtn = view.findViewById(R.id.topBtnFriends);
        friendsBtn.setOnClickListener(this);

        usersRequestsBtn = view.findViewById(R.id.topBtnUserRequests);
        usersRequestsBtn.setOnClickListener(this);

        usersListView = view.findViewById(R.id.usersListview);
        //Datos para mostrar hardocedados
        names = new ArrayList<String>();
        names.add("Jeff");
        names.add("Miguel");
        names.add("JuanmAH");
        names.add("Jeff");
        names.add("Miguel");
        names.add("JuanmAH");
        names.add("Jeff");
        names.add("Miguel");
        names.add("JuanmAH");

        UsersListAdapter usersListAdapter = new UsersListAdapter(getActivity().getApplicationContext(), R.layout.users_item, names);
        usersListView.setAdapter(usersListAdapter);



        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int position, long id) {

                Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                gotoDetailProfile();



            }
        });


        return view;
    }

    public void gotoDetailProfile()
    {
        Intent intent = new Intent(getActivity().getApplicationContext(),ProfileDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.topBtnAllusers:
                Log.d ( "A","A" );

                UsersListAdapter usersListAdapter = new UsersListAdapter(getActivity().getApplicationContext(), R.layout.users_item, names);
                usersListView.setAdapter(usersListAdapter);

                break;
            case R.id.topBtnFriends:
                Log.d ( "B","B" );
                UsersListAdapter usersListAdapter1 = new UsersListAdapter(getActivity().getApplicationContext(), R.layout.users_item, groups);
                usersListView.setAdapter(usersListAdapter1);

                break;
            case R.id.topBtnUserGroups:
                Log.d ( "C","C" );
                UsersListAdapter usersListAdapter2 = new UsersListAdapter(getActivity().getApplicationContext(), R.layout.users_item, amigos);
                usersListView.setAdapter(usersListAdapter2);

                break;
            case R.id.topBtnUserRequests:
                Log.d ( "SB","SB" );
                UsersListAdapter usersListAdapter3 = new UsersListAdapter(getActivity().getApplicationContext(), R.layout.users_item, solicitudes);
                usersListView.setAdapter(usersListAdapter3);

                break;
        }

    }




    public void hardcodearDatos()
    {

        groups = new ArrayList<String>();
        groups.add("Jeff");
        groups.add("Miguel");

        amigos = new ArrayList<String>();
        amigos.add("Jeff");
        amigos.add("Miguel");
        amigos.add("Jeff");

        solicitudes = new ArrayList<String>();
        solicitudes.add("Jeff");
        solicitudes.add("Miguel");
        solicitudes.add("Jeff");
        solicitudes.add("Jeff");


    }
}

