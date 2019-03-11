package com.example.alumnos.alumni.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alumnos.alumni.R;

import java.util.List;

public  class UsersListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public UsersListAdapter(Context context, int layout, List<String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.users_item, null);

        String currentName = names.get(position);
        currentName = (String) getItem(position);
        TextView itemUser = (TextView)v.findViewById(R.id.listUsername);

        itemUser.setText(currentName);

        return v;
    }
}
