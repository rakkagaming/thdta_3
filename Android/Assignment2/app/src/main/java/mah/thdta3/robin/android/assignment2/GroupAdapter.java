package mah.thdta3.robin.android.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by robin on 05/10/2017.
 */

public class GroupAdapter extends ArrayAdapter {

    private ArrayList<String> list;
    private LayoutInflater layoutInflater;

    public GroupAdapter(Context context, ArrayList<String> list){
        super(context,R.layout.group_adapter,list);
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder vH;
        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.group_adapter,parent,false);
            vH = new ViewHolder();
            vH.name = (TextView) convertView.findViewById(R.id.groupAdapterName);
            convertView.setTag(vH);
        }else {
            vH = (ViewHolder) convertView.getTag();
        }

        vH.name.setText(String.valueOf(list.get(position)));
        return  convertView;
    }

    public void setGroups(ArrayList<String> list){
        this.list = list;
    }

    class ViewHolder{
        TextView name;
    }
}
