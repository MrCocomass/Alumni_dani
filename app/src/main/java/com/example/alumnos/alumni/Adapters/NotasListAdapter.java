package com.example.alumnos.alumni.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnos.alumni.Models.Comments;
import com.example.alumnos.alumni.Models.Notas;
import com.example.alumnos.alumni.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NotasListAdapter extends BaseAdapter{



    private ArrayList<Notas> notas;

    private int layout;

    private Context context;



    public NotasListAdapter(Context context, int layout, ArrayList<Notas> notas){

        this.context = context;
        this.layout = layout;
        this.notas = notas;

    }

    @Override
    public int getCount() {
        return notas.size();
    }

    @Override
    public Notas getItem(int position) { return this.notas.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }


    @SuppressLint("ResourceAsColor")
    public View getView(int position, View convertView, ViewGroup viewGroup) {


        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.notes_item, null);

        String asignatura = String.valueOf(notas.get(position).getAsignatura());
        String comentario = String.valueOf(notas.get(position).getComentario());
        String nota = String.valueOf(notas.get(position).getNota());

        TextView textViewNota = v.findViewById(R.id.textNota);
        TextView textViewComentario = v.findViewById(R.id.textComentario);
        TextView textViewAsignatura= v.findViewById(R.id.textAsignatura);
        ImageView imageNotas = v.findViewById(R.id.imageNotas);
        ImageView imageComentario = v.findViewById(R.id.imageComentario);
        int result = Integer.parseInt(nota);
        if (result < 5) {
            imageNotas.setBackgroundColor(R.color.darkRed);
            imageComentario.setBackgroundColor(R.color.darkRed);
        }

        textViewNota.setText(nota);
        textViewComentario.setText(comentario);
        textViewAsignatura.setText(asignatura);


        return v;
    }
}