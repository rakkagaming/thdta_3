package mah.thdta3.robin.android.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by robin on 04/10/2017.
 */

public class MemberAdapter extends ArrayAdapter{

    private LayoutInflater layoutInflater;
    private ArrayList<Member> list;

    public MemberAdapter(Context context, ArrayList<Member> list){
        super(context,R.layout.member_adapter,list);
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder vH;
        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.member_adapter,parent,false);
            vH = new ViewHolder();
            vH.name = (TextView) convertView.findViewById(R.id.memberNameText);
            convertView.setTag(vH);
        }else {
            vH = (ViewHolder) convertView.getTag();
        }

        vH.name.setText(String.valueOf(list.get(position).getName()));
        return  convertView;
    }

    class ViewHolder{
        TextView name, id;
    }

}
