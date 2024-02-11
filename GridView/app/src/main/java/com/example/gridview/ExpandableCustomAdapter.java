package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpandableCustomAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<String> headetText;
    HashMap<String,ArrayList<String>> childText;
    public ExpandableCustomAdapter(Context context, ArrayList<String> headetText, HashMap<String, ArrayList<String>> childText) {
        this.context = context;
        this.headetText = headetText;
        this.childText = childText;
    }


    @Override
    public int getGroupCount() {
        return headetText.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childText.get(headetText.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headetText.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childText.get(headetText.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.header_sample_layout,parent,false);
        }
        TextView header = convertView.findViewById(R.id.headerTextViewId);
        header.setText(headetText.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_sample_layout,parent,false);
        }
        TextView child = convertView.findViewById(R.id.childTextViewId);
        child.setText(childText.get(headetText.get(groupPosition)).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
