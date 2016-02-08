package com.example.azapriy.list3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by azapriy on 2/7/16.
 */
public class MyListViewAdapter extends BaseAdapter {
    private ArrayList<String> data;
    private Context ctx;
    private LayoutInflater inflater;

    public MyListViewAdapter(Context context, ArrayList<String> data) {
        ctx = context;
        this.data = data;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);
        }
        ((TextView)view.findViewById(R.id.item_text_view)).setText(position + ") " + getItem(position));
        return view;
    }
}
