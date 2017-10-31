package mah.thdta3.robin.android.assignment1;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionHistoryFragment extends Fragment {


    private ListView transhistoryLV;
    private TextView transhistoryTxt;
    private Controller controller;
    private FloatingActionButton transactionhistoryFAB;
    private TransactionHistoryAdapter adapter;
    private ArrayList<Transaction> transList;
    private Button fromBtn, toBtn,searchBtn;
    private DatePickerDialog.OnDateSetListener dateSetListener,dateSet2;

    public TransactionHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_transaction_history, container, false);
        initializeComponents(v);
        initializeListeners();
        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
        controller.updateTHTitle();
        transList = controller.fetchTransactions();
        adapter = new TransactionHistoryAdapter(getActivity(), transList);
        transhistoryLV.setAdapter(adapter);
    }

    private void initializeListeners() {
        transactionhistoryFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.goToAddTransaction();
            }
        });

        toBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getContext(),
                        dateSet2,
                        year, month, day);

                dialog.show();
            }
        });

        dateSet2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = year + "-";
                if (month<10){date += "0" + month+"-";}
                else date +=month+"-";

                if (day<10){date+="0"+day;}
                else date +=day;
                toBtn.setText(date);
            }
        };

        fromBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getContext(),
                        dateSetListener,
                        year, month, day);

                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = year + "-";
                if (month<10){date += "0" + month+"-";}
                else date +=month+"-";

                if (day<10){date+="0"+day;}
                else date +=day;
                fromBtn.setText(date);
            }
        };

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.customSearch();
            }
        });

        transhistoryLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                controller.showDetailedInformation(position);
            }
        });
    }


    private void initializeComponents(View v) {
        transhistoryLV = (ListView) v.findViewById(R.id.transactionhistoryList);
        transhistoryTxt = (TextView) v.findViewById(R.id.transactionhistoryTitle);
        transactionhistoryFAB = (FloatingActionButton) v.findViewById(R.id.fabAdd);
        fromBtn = (Button)v.findViewById(R.id.fromChooser);
        toBtn = (Button)v.findViewById(R.id.toChooser);
        searchBtn = (Button)v.findViewById(R.id.searchaway);

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setTitle(String title){
        transhistoryTxt.setText(title);
    }

    public String getTo() {
        return toBtn.getText().toString();
    }
    public String getFrom() {
        return fromBtn.getText().toString();
    }
    public void updateList(ArrayList<Transaction> list){
        adapter = new TransactionHistoryAdapter(getActivity(), list);
        transhistoryLV.setAdapter(adapter);
    }
}
