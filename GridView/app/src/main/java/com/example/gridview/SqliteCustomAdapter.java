package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SqliteCustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> info,SLNumber;

    public SqliteCustomAdapter(Context context, ArrayList<String> SLNumber, ArrayList<String> info) {
        this.context = context;
        this.info = info;
        this.SLNumber = SLNumber;
    }

    @Override
    public int getCount() {
        return SLNumber.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.part6_sqlite_display_sample_layout,parent,false);
        }
        TextView serial = convertView.findViewById(R.id.part6sqlitedissplayAllIDTextViewId);
        TextView infor = convertView.findViewById(R.id.part6sqlitedissplayAllinfoTextViewId);
        serial.setText(SLNumber.get(position));
        infor.setText(info.get(position));

        return convertView;
    }
}
