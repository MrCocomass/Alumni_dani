package com.example.alumnos.alumni.Fragments.CreateEventsFragments;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.alumnos.alumni.R;

import java.io.File;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsTypesFragment4 extends Fragment implements View.OnClickListener {


    Button uploadImagaBtn;
    ImageView imageViewEvent;
    private  static  int PICK_IMAGE = 100;

    public static Uri imageUri;



    public EventsTypesFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_events_types_fragment4, container, false);

        imageViewEvent = v.findViewById(R.id.imageEventype);

        uploadImagaBtn = v.findViewById(R.id.uploadImageBtn);
        uploadImagaBtn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.uploadImageBtn:
                Log.d ( "imagen","subiendo imagen  " );
                openGalery();
                checkPhoto();

                break;
        }

    }



    public void openGalery()
    {

        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode,resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){

            Uri pacienteO = data.getData();
            //imageUri = data.getData();
            imageUri = Uri.fromFile(new File(getRealPathFromURI(pacienteO)));

            imageViewEvent.setImageURI(pacienteO);
        }

    }


    public static void checkPhoto()
    {
        Log.d("Photo", String.valueOf(imageUri));
    }



    private String getRealPathFromURI(Uri contentURI)
    {

        String result;
        Cursor cursor = getActivity().getApplicationContext().getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }






    @Override
    public void onResume() {
        super.onResume();
        imageViewEvent.setImageURI(imageUri);

        Log.d("imagen uri", String.valueOf(imageUri));


    }
}