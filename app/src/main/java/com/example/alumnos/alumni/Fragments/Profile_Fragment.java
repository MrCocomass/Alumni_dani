package com.example.alumnos.alumni.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumnos.alumni.Activities.EditProfileActivity;
import com.example.alumnos.alumni.Activities.MainActivity;
import com.example.alumnos.alumni.Activities.MainMenuActivity;
import com.example.alumnos.alumni.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_Fragment extends Fragment implements View.OnClickListener {



    Button editProfileBtn, logoutbtn;
    String name;
    String userName;
    Integer phoneNumber;
    String description;
    String email;



    TextView textViewname;
    TextView textViewusername;

    TextView textViewDescription;
    TextView textViewPhone;

    TextView textViewMail;



    public Profile_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_, container, false);
        SharedPreferences sp = getActivity().getSharedPreferences("userPrefs",0);


        name = sp.getString("name","");
        userName = sp.getString("username","");
        description = sp.getString("description","");
        //phoneNumber = Integer.valueOf ( sp.getString("phone","") );
        email = sp.getString("email","");

        editProfileBtn = view.findViewById ( R.id.editProfileBtn );
        editProfileBtn.setOnClickListener (this);

        logoutbtn = view.findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener (this);

        textViewname = view.findViewById ( R.id.studentname );
        textViewusername = view.findViewById ( R.id.username);
        textViewDescription = view.findViewById ( R.id.studentDescription );
        textViewMail = view.findViewById ( R.id.studentmail );
        textViewPhone = view.findViewById ( R.id.studentPhone );

        textViewname.setText ( name );
        textViewusername.setText ( userName );
        // textViewMail.setText ( email );
        // textViewDescription.setText ( description );
        //textViewPhone.setText ( phoneNumber );

        Log.d ( "preferences",name + "nombre real del usuario" );
        Log.d ( "preferences",userName + "nombre del usuario en la app" );

        return view;

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.editProfileBtn:
                Log.d ( "perfil","editando perfil" );
                goToEditProfile ();
                break;
        }

        switch (v.getId()) {
            case R.id.logoutbtn:
                Log.d ( "log out","¡hasta luego!" );
                logout ();
                break;
        }
    }

    void goToEditProfile()
    {
        Intent intent = new Intent(getActivity (),EditProfileActivity.class);
        startActivity(intent);
    }


    public void logout()
    {
        SharedPreferences sp = getActivity().getSharedPreferences("userPrefs",0);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        edit.commit();
        Intent intent = new Intent(getActivity (),MainActivity.class);
        startActivity(intent);
    }
}
