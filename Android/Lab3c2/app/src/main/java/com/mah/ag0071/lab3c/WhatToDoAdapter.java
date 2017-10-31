package com.mah.ag0071.lab3c;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by User on 2017-09-17.
 */

public class WhatToDoAdapter extends ArrayAdapter<String> {

    private LayoutInflater layoutInflater;

    public WhatToDoAdapter(@NonNull Context context,String[] strings) {
        super(context, R.layout.listview_layout,strings);
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        TextView tvList;
        if(convertView == null){
            convertView = (LinearLayout) layoutInflater.inflate(R.layout.listview_layout,parent,false);
        }
        tvList = (TextView) convertView.findViewById(R.id.tvListview);
        tvList.setText(this.getItem(position));
        return convertView;
    }
}
