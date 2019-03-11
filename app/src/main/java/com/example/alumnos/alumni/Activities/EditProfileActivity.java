package com.example.alumnos.alumni.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import com.example.alumnos.alumni.Api.ApiAlumni;
import com.example.alumnos.alumni.Fragments.Profile_Fragment;
import com.example.alumnos.alumni.Models.JsonResponse;
import com.example.alumnos.alumni.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import static com.example.alumnos.alumni.Activities.MainActivity.URL;
import android.widget.ImageView;
import android.widget.TextView;
public class EditProfileActivity extends AppCompatActivity {

    ApiAlumni api;

    Integer id;
    EditText email;
    EditText name;
    EditText password;
    EditText phone;
    EditText description;
    Button buttonSave;

    int phoneNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_edit_profile );

        SharedPreferences sp = this.getSharedPreferences("userPrefs",0);
        id = sp.getInt("id", 0);


        email = findViewById(R.id.emailText);
        buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(mCorkyListener);
        name = findViewById(R.id.nameText);
        password = findViewById(R.id.passwordText);
        phone = findViewById(R.id.phoneText);
        description = findViewById(R.id.descriptionText);





        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiAlumni.class);
    }

    private View.OnClickListener mCorkyListener = new View.OnClickListener() {
        public void onClick(View v) {
            goToProfile();
        }
    };

        private void goToProfile()
        {
            if (getFragmentManager().getBackStackEntryCount() != 0) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }

    public void updateUser(View view) {
        final SharedPreferences sp = this.getSharedPreferences("userPrefs",0);
        if(!TextUtils.isEmpty(phone.getText().toString())){
            phoneNum = Integer.parseInt(phone.getText().toString());
        }
        Call<JsonResponse> peticion = api.updateuser(id, description.getText().toString(), name.getText().toString(), password.getText().toString(),phoneNum, email.getText().toString(), "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJhZG1pbkBjZXYuY29tIiwidXNlcm5hbWUiOiJhZG1pbiIsInBhc3N3b3JkIjoiYWRtaW4iLCJpZF9yb2wiOjEsImlkX3ByaXZhY2l0eSI6MSwiZ3JvdXAiOm51bGx9.qhRcT-k8OEUCVFn8vJLapEGUekZGv13YWY90XqW6qCo");
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                Log.d("holi", "Esta es la respuesta" + response);
                Log.d("esto es el telefono", "aqui" +phoneNum);
                Log.d("sin parsear", phone.getText().toString());
                Log.d("este es el pw", password.getText().toString());
                Log.d("esta es la IDE", "hola" +id);
                int code = response.body ().getCode ();
                JsonResponse json = response.body();

                Log.d ( "Respuesta del servidor", response.body ().getMessage () );
                Log.d ( "Respuesta del servidor", " " + code );
                Log.d ( "INTENTANDO....", " "+ json );

                switch (code) {
                    case 200:

                        String message = response.body ().getMessage ();
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("name", name.getText().toString());
                        editor.putString("email", email.getText().toString());
                        editor.putString("pass", password.getText().toString());
                        editor.apply();
                        Log.d ( "KAPACHAO", " "+ message );

                        break;
                    case 400:

                        String errorMessage = response.body ().getMessage ();
                        Toast.makeText ( EditProfileActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                    default:
                        String errrorMessage = response.body ().getMessage ();
                        Toast.makeText ( EditProfileActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                }

            }


            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("Failture message", "FAILTUREEEEEEE CASEEEEEEEEEEEEEEEEEEE");
                String error = "Failtuure :algo ha salido mal al captar code 400:";
                Toast.makeText(EditProfileActivity.this, error, Toast.LENGTH_SHORT).show();
                // Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d ("Failture message",t.getMessage ().toString ());

            }

        });
    }

}

