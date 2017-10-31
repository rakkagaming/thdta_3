package mah.thdta3.robin.android.assignment1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by robin on 18/09/2017.
 */

public class TransactionHistoryAdapter extends ArrayAdapter{
        private LayoutInflater layoutInflater;

    private ImageView iconIV;
    private TextView titleTxt, amountTxt, categoryTxt,dateTxt;
    private ArrayList<Transaction> transaction;


    public TransactionHistoryAdapter(Context context, ArrayList<Transaction> transaction){
        super(context,R.layout.layout_adapter,transaction);
        this.transaction = transaction;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position,View convertView, ViewGroup parent){
        ViewHolder vH;
        if (convertView==null) {
            convertView =layoutInflater.inflate(R.layout.layout_adapter,parent,false);
            vH = new ViewHolder();
            vH.amountTxt = (TextView) convertView.findViewById(R.id.adapterAmount);
            vH.categoryTxt = (TextView) convertView.findViewById(R.id.adapterCategory);
            vH.titleTxt = (TextView) convertView.findViewById(R.id.adapterTitle);
            vH.iconIV = (ImageView) convertView.findViewById(R.id.adapterIcon);
            vH.dateTxt = (TextView) convertView.findViewById(R.id.adapterDate);
            convertView.setTag(vH);
        }else{
            vH = (ViewHolder) convertView.getTag();
        }
        vH.amountTxt.setText(String.valueOf(transaction.get(position).getAmount()) + " kr");
        vH.categoryTxt.setText(String.valueOf(transaction.get(position).getCategory()));
        vH.titleTxt.setText(String.valueOf(transaction.get(position).getTitle()));
        vH.dateTxt.setText(String.valueOf(transaction.get(position).getDate()));
        vH.iconIV.setImageResource(iconChooser(transaction.get(position).getCategory()));

        return convertView;
    }

    private int iconChooser(String category) {
        int id = 0;
        switch (category){
            case "Food":
                id = R.drawable.food;
                break;
            case "Leisure":
                id = R.drawable.leisure;
                break;
            case "Accommodation":
                id = R.drawable.accommodation;
                break;
            case "Travel":
                id = R.drawable.airplane;
                break;
            case "Salary":
                id = R.drawable.cash;
                break;
            case "Other":
                id = R.drawable.other;
                break;
            default:
                break;
        }
        return id;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);

    }

    @Override
    public int getCount() {
        return transaction.size();
    }

    class ViewHolder{


        ImageView iconIV;
        TextView titleTxt, amountTxt, categoryTxt,dateTxt;

    }
}
