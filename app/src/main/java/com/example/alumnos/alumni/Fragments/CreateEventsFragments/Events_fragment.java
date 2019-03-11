package com.example.alumnos.alumni.Fragments.CreateEventsFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alumnos.alumni.Activities.CreateEventsActivity;
import com.example.alumnos.alumni.Activities.DetailEventActivity;
import com.example.alumnos.alumni.Adapters.MyAdapter;
import com.example.alumnos.alumni.Api.GlobalRequests;
import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.R;

import java.util.ArrayList;

import static com.example.alumnos.alumni.Activities.DetailEventActivity.eventsRecibed;

/**
 * A simple {@link Fragment} subclass.
 */
public class Events_fragment extends Fragment implements View.OnClickListener {

    MyAdapter myAdapter;

    ImageView imageEvent;

    EditText theFilter;

    LinearLayout typesView;

    Button openTypes;

    Button closeTypes;

    Button allTypes;

    Button notifTypes;

    Button eventTypes;

    Button offerTypes;

    Button newsTypes;




    public static String search;

    public static Integer type;




    public static ArrayList<Event> eventsArrayList = new ArrayList<Event>();
    public static ListView listView;
    private FloatingActionButton addEventBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_events_fragment, container, false);
        // Inflate the layout for this fragment
        type = 0;

        allTypes = view.findViewById(R.id.allTypes);
        newsTypes = view.findViewById(R.id.newsTypes);
        notifTypes = view.findViewById(R.id.notifTypes);
        offerTypes = view.findViewById(R.id.offerTypes);
        eventTypes = view.findViewById(R.id.eventTypes);
        theFilter = view.findViewById(R.id.searchFilter);
        typesView = view.findViewById(R.id.typesView);
        openTypes = view.findViewById(R.id.openTypes);
        closeTypes = view.findViewById(R.id.closeTypes);
        closeTypes.setOnClickListener(this);
        newsTypes.setOnClickListener(this);
        allTypes.setOnClickListener(this);
        notifTypes.setOnClickListener(this);
        offerTypes.setOnClickListener(this);
        eventTypes.setOnClickListener(this);
        openTypes.setOnClickListener(this);
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search = theFilter.getText().toString();
                Log.d("el texto es", search);

                if(theFilter.getText().toString().trim().length() == 0){
                    GlobalRequests globalRequests = new GlobalRequests();
                    globalRequests.setGlobalRequestsListener ( new GlobalRequests.MyRequestListener () {
                        @Override
                        public void onGetEventsFinish() {
                            myAdapter = new MyAdapter(getActivity().getApplicationContext(), R.layout.list_item, eventsArrayList);
                            listView.setAdapter(myAdapter);
                        }
                    } );

                    globalRequests.getlistOfEvents();
                    addEventBtn = getView().findViewById(R.id.floatBtn);
                    addEventBtn.setOnClickListener(myEventListener);
                    listView = (ListView) getView().findViewById(R.id.eventsListView);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                            Integer idEvent = Integer.valueOf(eventsArrayList.get(position).getId());
                            String currentName = String.valueOf(eventsArrayList.get(position));
                            String description = String.valueOf(eventsArrayList.get(position).getDescription());
                            String date =  String.valueOf(eventsArrayList.get(position).getDate ());
                            Event eventSended  = eventsArrayList.get (position);
                            eventsRecibed.add(0, eventSended);
                            Toast.makeText(getActivity().getApplicationContext(), "evento enviado!", Toast.LENGTH_SHORT).show();
                            goToDetailEvent();

                        }
                    });

                }



                GlobalRequests globalRequests = new GlobalRequests();
                globalRequests.setGlobalRequestsListener ( new GlobalRequests.MyRequestListener () {
                    @Override
                    public void onGetEventsFinish() {
                        myAdapter = new MyAdapter(getActivity().getApplicationContext(), R.layout.list_item, eventsArrayList);
                        listView.setAdapter(myAdapter);
                    }
                } );

                globalRequests.searchEvent();
                addEventBtn = getView().findViewById(R.id.floatBtn);
                addEventBtn.setOnClickListener(myEventListener);
                listView = (ListView) getView().findViewById(R.id.eventsListView);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        Integer idEvent = Integer.valueOf(eventsArrayList.get(position).getId());
                        String currentName = String.valueOf(eventsArrayList.get(position));
                        String description = String.valueOf(eventsArrayList.get(position).getDescription());
                        String date =  String.valueOf(eventsArrayList.get(position).getDate ());
                        Event eventSended  = eventsArrayList.get (position);
                        eventsRecibed.add(0, eventSended);
                        Toast.makeText(getActivity().getApplicationContext(), "evento enviado!", Toast.LENGTH_SHORT).show();
                        goToDetailEvent();

                    }

                });
            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


        GlobalRequests globalRequests = new GlobalRequests();
        globalRequests.setGlobalRequestsListener ( new GlobalRequests.MyRequestListener () {
            @Override
            public void onGetEventsFinish() {
                myAdapter = new MyAdapter(getActivity().getApplicationContext(), R.layout.list_item, eventsArrayList);
                listView.setAdapter(myAdapter);
            }
        } );

        globalRequests.getlistOfEvents();
        addEventBtn = getView().findViewById(R.id.floatBtn);
        addEventBtn.setOnClickListener(myEventListener);
        listView = (ListView) getView().findViewById(R.id.eventsListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                Integer idEvent = Integer.valueOf(eventsArrayList.get(position).getId());
                String currentName = String.valueOf(eventsArrayList.get(position));
                String description = String.valueOf(eventsArrayList.get(position).getDescription());
                String date =  String.valueOf(eventsArrayList.get(position).getDate ());
                Event eventSended  = eventsArrayList.get (position);
                eventsRecibed.add(0, eventSended);
                Toast.makeText(getActivity().getApplicationContext(), "evento enviado!", Toast.LENGTH_SHORT).show();
                goToDetailEvent();

            }
        });


        }

    private View.OnClickListener myEventListener = new View.OnClickListener() {
        public void onClick(View v) {
            //Toast.makeText(getActivity().getApplicationContext(), "CLICK!", Toast.LENGTH_SHORT).show();
            goToCreateEventActivity();
        }
    };


    private void goToCreateEventActivity()
    {
        Intent intent = new Intent(getActivity().getApplicationContext(),CreateEventsActivity.class);
        startActivity(intent);
    }

    private void goToDetailEvent()
    {
        Intent intent = new Intent(getActivity().getApplicationContext(),DetailEventActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.searchFilter:
                Log.d ( "perfil","editando perfil" );
                searchEvent ();
                break;
            case R.id.openTypes:
                typesView.setVisibility(View.VISIBLE);
                break;
            case R.id.closeTypes:
                typesView.setVisibility(View.GONE);
                break;
            case R.id.allTypes:
                type = 0;
                sendRequest();
                typesView.setVisibility(View.GONE);
                break;
            case R.id.offerTypes:
                type = 2;
                sendRequest();
                typesView.setVisibility(View.GONE);
                break;
            case R.id.newsTypes:
                type = 4;
                sendRequest();
                typesView.setVisibility(View.GONE);
                break;
            case R.id.eventTypes:
                type = 1;
                sendRequest();
                typesView.setVisibility(View.GONE);
                break;
            case R.id.notifTypes:
                type = 3;
                sendRequest();
                typesView.setVisibility(View.GONE);
                break;
        }


    }

    private void searchEvent() {

        String ed_text = theFilter.getText().toString().trim();


        if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
        {
            Log.d("Hola", "estoy vacio por dentro");
        }
        else
        {
            Log.d("hola", "me rellenaron el ano");
        }

    }




    private void sendRequest(){
        GlobalRequests globalRequests = new GlobalRequests();
        globalRequests.setGlobalRequestsListener ( new GlobalRequests.MyRequestListener () {
            @Override
            public void onGetEventsFinish() {
                myAdapter = new MyAdapter(getActivity().getApplicationContext(), R.layout.list_item, eventsArrayList);
                listView.setAdapter(myAdapter);
            }
        } );

        globalRequests.getlistOfEvents();
        addEventBtn = getView().findViewById(R.id.floatBtn);
        addEventBtn.setOnClickListener(myEventListener);
        listView = (ListView) getView().findViewById(R.id.eventsListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                Integer idEvent = Integer.valueOf(eventsArrayList.get(position).getId());
                String currentName = String.valueOf(eventsArrayList.get(position));
                String description = String.valueOf(eventsArrayList.get(position).getDescription());
                String date =  String.valueOf(eventsArrayList.get(position).getDate ());
                Event eventSended  = eventsArrayList.get (position);
                eventsRecibed.add(0, eventSended);
                Toast.makeText(getActivity().getApplicationContext(), "evento enviado!", Toast.LENGTH_SHORT).show();
                goToDetailEvent();

            }
        });
    }
}

