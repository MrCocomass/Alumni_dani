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

import com.example.alumnos.alumni.Api.ApiAlumni;
import com.example.alumnos.alumni.Models.JsonResponse;
import com.example.alumnos.alumni.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    ApiAlumni api;

    //static String URL_PROD ="http://alumni.vanadis.es/alumni/public/index.php/api/";
    //static String URL_DEV = "http://192.168.6.167/ProyectoAlumni/public/index.php/api/";
    static String URL_LOC = "http://192.168.1.34:8888/ProyectoAlumni/public/index.php/api/";
    EditText email, password;
    Button sendBtn, registerBtn;

    public static String URL = URL_LOC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        email = findViewById(R.id.emailTxt);
        password = findViewById(R.id.passwordText);
        sendBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(mCorkyListener);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiAlumni.class);

        Log.d ( "PREFERENCIAS", "CARGANDO PREFERENCIAAAAAAAAAAAAAAAAAAAAAAAAAS" );
        SharedPreferences prefs = getSharedPreferences("userPrefs", MODE_PRIVATE);
        if(prefs.contains("email") && prefs.contains("pass")&& prefs.contains("token"))
        {
            Log.d ( "ESTADO PREFS:", "EXISITEN PREFERECNIAS" );
            goToMenu();


        }
        else{
            Log.d("ESTADO PREFS:", "NO EXISITEN PREFERECNIAS");
        }
    }



    private View.OnClickListener mCorkyListener = new View.OnClickListener() {
        public void onClick(View v) {
            openRegister();
        }
    };

    public void openRegister()
    {
        Intent intent = new Intent(this,Register_Activity.class);
        startActivity(intent);

    }



    public void login(View view) {

        Call<JsonResponse> peticion = api.login (email.getText().toString(), password.getText().toString());
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                int code = response.body ().getCode ();
                JsonResponse json = response.body();

                Log.d ( "Respuesta del servidor", response.body ().getMessage () );
                Log.d ( "Respuesta del servidor", " " + code );
                Log.d ( "INTENTANDO....", " "+ json );

                switch (code) {
                    case 200:

                        String message = response.body ().getMessage ();

                        String name = response.body ().getData ().getUser ().getName ();
                        String userName = response.body ().getData ().getUser ().getUsername ();
                        String birthday = response.body ().getData ().getUser ().getBirthday ();
                        String description = response.body ().getData ().getUser ().getDescription ();
                        Integer phone = response.body ().getData ().getUser ().getPhone ();
                        String token = response.body ().getData ().getToken ();
                        String email = response.body ().getData ().getUser ().getEmail ();
                        String password = response.body ().getData ().getUser ().getPassword ();
                        Integer id = response.body().getData().getUser().getId();

                        Toast.makeText ( MainActivity.this, message, Toast.LENGTH_SHORT ).show ();
                        Log.d ( "200::", userName );
                        Log.d ( "Preferencias:", "guardando preferencias....." );

                        SharedPreferences sp = getSharedPreferences("userPrefs", 0);
                        SharedPreferences.Editor editor = sp.edit();

                        editor.putString("name", name);
                        editor.putString("username", userName);
                        editor.putString("email", email);
                        editor.putString("pass", password);
                        editor.putString("description", description);
                        editor.putString("birthday", birthday);
                        editor.putString("phone", String.valueOf ( phone ) );
                        editor.putString("token", token);
                        editor.putInt("id", id);
                        editor.apply();
                        Log.d ( "Preferencias:", "preferencias... guardadas" );


                        goToMenu ();

                        break;
                    case 400:

                        String errorMessage = response.body ().getMessage ();
                        Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                    default:
                        String errrorMessage = response.body ().getMessage ();
                        Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                }

            }


            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("Failture message", "FAILTUREEEEEEE CASEEEEEEEEEEEEEEEEEEE");
                String error = "Failtuure :algo ha salido mal al captar code 400:";
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d ("Failture message",t.getMessage ().toString ());

            }

        });
    }

    private void goToMenu()
    {
        Intent intent = new Intent(this,MainMenuActivity.class);
        startActivity(intent);
    }


    public void goRecover(View view) {
        Log.d ("Failture message", "FAILTUREEEEEEE CASEEEEEEEEEEEEEEEEEEE");
        Intent intent = new Intent(this, RecoverActivity.class);
        startActivity(intent);
    }


}
