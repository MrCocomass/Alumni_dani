package com.example.alumnos.alumni.Fragments.UsersFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alumnos.alumni.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersRequestsFragment extends Fragment {


    public UsersRequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate ( R.layout.fragment_users_requests, container, false );
    }

}
