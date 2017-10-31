package mah.thdta3.robin.android.lab2b;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HowTo extends Fragment {

    private Button btnPrev;
    private Button btnNext;
    private TextView txtContent;
    private TextView txtWTD;
    private Controller controller;

    public HowTo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_how_to, container, false);
        controller = new Controller(this);
        initializeComponents(view);
        initializeListners();
        return view;
    }

    private void initializeComponents(View v) {
        btnPrev = (Button)v.findViewById(R.id.btnPrev);
        btnNext = (Button)v.findViewById(R.id.btnNext);
        txtContent = (TextView)v.findViewById(R.id.textContent);
        txtWTD = (TextView)v.findViewById(R.id.textWhatToDo);
    }

    private void initializeListners() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.nextClick();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.previousClick();
            }
        });
    }

    public void setContent(String content) {
        txtContent.setText(content);
    }

    public void setWhatToDo(String whatToDo) {
        txtWTD.setText(whatToDo);
    }
}
