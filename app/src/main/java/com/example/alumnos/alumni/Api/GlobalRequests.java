package com.example.alumnos.alumni.Api;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.alumnos.alumni.Models.Comments;
import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.Models.JsonResponse;
import com.example.alumnos.alumni.Models.Notas;

import android.net.Uri;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.github.mikephil.charting.utils.FileUtils;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Multipart;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.alumnos.alumni.Activities.DetailEventActivity.idEvent;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.EventsTypesFragment4.imageUri;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.Events_fragment.search;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.Events_fragment.type;

import static com.example.alumnos.alumni.Activities.ViewCommentsActivity.commentsArrayList;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.EventTypesFragment.idTypeEvent;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.EventsTypesFragment2.id_group;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.EventsTypesFragment3.eventDescription;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.EventsTypesFragment3.eventTile;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.EventsTypesFragment3.keepAllDates;
import static com.example.alumnos.alumni.Fragments.CreateEventsFragments.Events_fragment.eventsArrayList;
import static com.example.alumnos.alumni.Activities.MainActivity.URL;
import static com.example.alumnos.alumni.Activities.ViewCommentsActivity.keepCommentText;
import static com.example.alumnos.alumni.Activities.ViewCommentsActivity.textComment;
import static com.example.alumnos.alumni.Fragments.PanelFragments.Notes_Fragment.notasArrayList;


public class GlobalRequests {

    ApiAlumni api;
    Retrofit retrofit;
    private SharedPreferences prefs;
    List<Comments> arrayComments = new ArrayList<>();
    String tokenHc = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJhZG1pbkBjZXYuY29tIiwidXNlcm5hbWUiOiJhZG1pbiIsInBhc3N3b3JkIjoiYWRtaW4iLCJpZF9yb2wiOjEsImlkX3ByaXZhY2l0eSI6MSwiZ3JvdXAiOm51bGx9.qhRcT-k8OEUCVFn8vJLapEGUekZGv13YWY90XqW6qCo";

    private MyRequestListener listener;

    private CommentsListener listenerComments;

    private NotasListener notasListener;


    public interface MyRequestListener
    {
        public void onGetEventsFinish();

    }

    public interface NotasListener
    {
        public void onGetNotasFinish();
    }


    public interface CommentsListener
    {
        public void onGetCommentsFinish();

    }

    public void setGlobalRequestsListener(MyRequestListener listener) {
        this.listener = listener;
    }



    public void setCommentsListener(CommentsListener listenerComments){
        this.listenerComments = listenerComments;
    }

    public void setNotasListener(NotasListener notasListener){
        this.notasListener = notasListener;
    }

    public GlobalRequests() {

        this.listener = null;
        this.listenerComments = null;
        this.notasListener = null;

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiAlumni.class);
    }



    public void CreateEvent(){

        keepAllDates();

        File imagefile  = new File(imageUri.getPath());

        RequestBody image = RequestBody.create(MediaType.parse("image/*"), String.valueOf(imageUri));
        Log.d("CreateEvent", String.valueOf(image));
        Log.d("CreateEvent", String.valueOf(imageUri));


        RequestBody title = RequestBody.create(MediaType.parse("text/plain"),eventTile);
        RequestBody description = RequestBody.create(MediaType.parse("text/plain"),eventDescription);
        RequestBody idEvent = RequestBody.create(MediaType.parse("text/plain"),idTypeEvent.toString());
        RequestBody idgroup = RequestBody.create(MediaType.parse("text/plain"),id_group.toString());
        // RequestBody token = RequestBody.create(MediaType.parse("text/plain"),tokenHc.toString());






        Call<JsonResponse> peticion = (Call<JsonResponse>) api.createEvent (title,description,idEvent,idgroup,image,tokenHc);
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                int code = response.body().getCode();
                JsonResponse json = response.body();
                Log.d ( "Respuesta del servidor", response.body ().getMessage () );

                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", message);
                        Log.d ( "REQUEST STATE", "FIN DE LA PETICION");

                        //listener.onGetEventsFinish ();

                        break;
                    case 400:
                        // Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                        String errorMessage = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", errorMessage);
                        break;

                    default:
                        //Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                        String defaultmsg = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", defaultmsg);
                }

            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("Failture message", "ON FAILTUREEEEEEEEEEE");
                Log.d ("EL FALLO ES", String.valueOf(t));

            }

        });
    }



    public void getlistOfEvents()
    {

        Call<JsonResponse> peticion = api.getEventsList (type,tokenHc);
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                int code = response.body().getCode();
                JsonResponse json = response.body();
                Log.d ( "Respuesta del servidor", response.body ().getMessage () );

                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        eventsArrayList = (ArrayList<Event>) response.body().getData().getEvent();
                        Integer size = eventsArrayList.size();

                        Collections.reverse(eventsArrayList);
                        listener.onGetEventsFinish ();

                        break;
                    case 400:
                        // Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                        String errorMessage = response.body ().getMessage ();
                        break;

                    default:
                        //Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                        String defaultmsg = response.body ().getMessage ();
                }

            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("EL FALLO ES", String.valueOf(t));

            }

        });

    }

    public void deleteEvent()
    {

        Call<JsonResponse> peticion = api.delete (idEvent,tokenHc);
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                int code = response.body().getCode();
                JsonResponse json = response.body();
                Log.d ( "Respuesta del servidor", response.body ().getMessage () );

                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", message);
                        Log.d ( "REQUEST STATE", "FIN DE LA PETICION");

                        //listener.onGetEventsFinish ();

                        break;
                    case 400:
                        // Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                        String errorMessage = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", errorMessage);
                        break;

                    default:
                        //Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                        String defaultmsg = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", defaultmsg);
                }

            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("Failture message", "ON FAILTUREEEEEEEEEEE");
                Log.d ("EL FALLO ES", String.valueOf(t));

            }

        });

    }

    public void getlistOfComments()
    {
        Log.d("****", "ID EVENTO"+idEvent);

        Call<JsonResponse> peticion = api.getCommentList (idEvent,tokenHc);
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                int code = response.body().getCode();
                Log.d("holi", "holi" + code);
                JsonResponse json = response.body();
                Log.d ( "Respuesta del ES", response.body ().getMessage () );

                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        Log.d("RESPUESTA 200::", message);

                        commentsArrayList = (ArrayList<Comments>) response.body().getData().getComments();


                        listenerComments.onGetCommentsFinish();
                        Collections.reverse(commentsArrayList);

                        break;
                    case 400:
                        // Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                        String errorMessage = response.body ().getMessage ();
                        Log.d("RESPUESTA 400::", errorMessage);
                        break;

                    default:
                        //Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                        String defaultmsg = response.body ().getMessage ();
                        Log.d("RESOUESTA DEFAULT::", defaultmsg);
                }

            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("Failture message", "ON FAILTUREEEEEEEEEEE");
                Log.d ("EL FALLO ES", String.valueOf(t));

            }

        });


    }
    public void searchEvent()
    {

        Call<JsonResponse> peticion = api.searchEvent (search,0, tokenHc);
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                Log.d("respuesta", response.body().getMessage());

                int code = response.body().getCode();
                JsonResponse json = response.body();
                Log.d ( "Respuesta del servidor", response.body ().getMessage () );

                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        eventsArrayList = (ArrayList<Event>) response.body().getData().getEvent();
                        Integer size = eventsArrayList.size();

                        Collections.reverse(eventsArrayList);
                        listener.onGetEventsFinish ();

                        break;
                    case 400:
                        // Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                        String errorMessage = response.body ().getMessage ();
                        break;

                    default:
                        //Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                        String defaultmsg = response.body ().getMessage ();
                }

            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("EL FALLO ES", String.valueOf(t));

            }

        });

    }


    public void createComment(){
        keepCommentText();
        Call<JsonResponse> peticion = api.createComment("Titulo", textComment, idEvent, tokenHc);
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                int code = response.body().getCode();
                JsonResponse json = response.body();
                Log.d ( "Respuesta del servidor", response.body ().getMessage () );
                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        Log.d("200 CREAR COMENTARIO:", message);
                        Log.d ( "STATE CREAR COMENTARIO", "FIN DE LA PETICION");
                        break;
                    case 400:
                        String errorMessage = response.body ().getMessage ();
                        Log.d("400 CREAR COMENTARIO::", errorMessage);
                        break;
                    default:
                        String defaultmsg = response.body ().getMessage ();
                        Log.d("DEFAULT CREAR COMMENT::", defaultmsg);
                }

            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d ("Failure CRCOMENT", "ON FAILTUREEEEEEEEEEE");
                Log.d ("EL FALLO EN CRCOMENT", String.valueOf(t));
            }
        });
    }

    public void getlistOfNotas()
    {

        Call<JsonResponse> peticion = api.getNotasList (tokenHc);
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                int code = response.body().getCode();
                JsonResponse json = response.body();
                Log.d ( "Respuesta del servidor", response.body ().getMessage () );

                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        notasArrayList = (ArrayList<Notas>) response.body().getData().getNota();
                        Integer size = notasArrayList.size();

                        notasListener.onGetNotasFinish();

                        break;
                    case 400:
                        // Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                        String errorMessage = response.body ().getMessage ();
                        break;

                    default:
                        //Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                        String defaultmsg = response.body ().getMessage ();
                }

            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("EL FALLO ES", String.valueOf(t));

            }

        });

    }
}