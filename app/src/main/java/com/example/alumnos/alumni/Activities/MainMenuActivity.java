package com.example.alumnos.alumni.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.alumnos.alumni.Fragments.CreateEventsFragments.Events_fragment;
import com.example.alumnos.alumni.Fragments.PanelFragments.Panel_Fragment;
import com.example.alumnos.alumni.Fragments.Profile_Fragment;
import com.example.alumnos.alumni.Fragments.UsersFragment.UsersFragment;
import com.example.alumnos.alumni.R;


public class MainMenuActivity extends AppCompatActivity {

    Panel_Fragment fragmentPanel;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            boolean fragmentTransaction = false;
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_events:
                    fragment =  new Events_fragment();
                    fragmentTransaction = true;
                    fragmentPanel.destroy();


                    break;
                case R.id.navigation_panel:

                    fragment = fragmentPanel;
                    fragmentTransaction = true;
                    Log.d("****", "NAVIGATION PANEL");
                    break;
                case R.id.navigation_profile:

                    fragment =  new Profile_Fragment();
                    fragmentTransaction = true;
                    fragmentPanel.destroy();

                    break;

                case R.id.navigation_users:

                    Log.d ( "4:", "Intentando usuarios......" );
                    fragment =  new UsersFragment ();

                    fragment =  new UsersFragment();
                    fragmentTransaction = true;
                    fragmentPanel.destroy();



                    break;
            }

            if (fragmentTransaction)
            {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();
                item.setChecked(true);
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment fragment = null;
        fragment =  new Events_fragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        fragmentPanel=new Panel_Fragment();

    }



}
