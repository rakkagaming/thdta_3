package mah.thdta3.robin.android.assignment1;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionAddFragment extends Fragment {

    private EditText addTitle, addAmount;
    private TextView addOverTitle;
    private Button addDate,addTransaction;
    private Spinner addCategory;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Controller controller;
    private ArrayAdapter adapter;

    public TransactionAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_transaction_add, container, false);
        initializeComponents(v);
        initializeListeners();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.updateAddTitle();
        controller.updateAddSpinner();
        if (controller.checkFlag()) {
            controller.updateAddFields();
            Log.e("WHAT","flag=" + controller.checkFlag());
        }else{controller.clearAdd();}
    }

    private void initializeListeners() {

        addTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = controller.createTransaction();
                Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
                controller.returnToLast();
            }
        });

        addDate.setOnClickListener(new View.OnClickListener() {
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
                addDate.setText(date);
            }
        };
    }

    private void initializeComponents(View v) {
        addAmount = (EditText) v.findViewById(R.id.transAddAmount);
        addDate = (Button) v.findViewById(R.id.transAddDate);
        addTitle = (EditText) v.findViewById(R.id.transaddTitle);
        addOverTitle = (TextView) v.findViewById(R.id.transAddOverTitle);
        addCategory = (Spinner) v.findViewById(R.id.transaddSpinner);
        addTransaction = (Button) v.findViewById(R.id.transactionAdd);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setOverTitle(String title){
        addOverTitle.setText(title);
    }

    public void setSpinner(int category) {
        adapter = ArrayAdapter.createFromResource(getContext(),category,android.R.layout.simple_dropdown_item_1line);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        addCategory.setAdapter(adapter);
    }

    public String getAmount(){
        return addAmount.getText().toString();
    }
    public String getCategory(){
        return addCategory.getSelectedItem().toString();
    }
    public String getTitle(){
        return addTitle.getText().toString();
    }
    public String getDate(){
        return addDate.getText().toString();
    }

    public void setAddTitle(String s) {
        this.addTitle.setText(s);
    }

    public void setAddAmount(String s) {
        this.addAmount.setText(s);
    }

    public void setAddDate(String s) {
        this.addDate.setText(s);
    }

    public void setAddCategory(int i) {
        this.addCategory.setSelection(i);
    }

    public int getSelCat() {
        return addCategory.getSelectedItemPosition();
    }
}
