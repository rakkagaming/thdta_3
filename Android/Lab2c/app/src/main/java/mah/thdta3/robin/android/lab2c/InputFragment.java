package mah.thdta3.robin.android.lab2c;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    public static final String TAG = "Input Fragment";
    private Button btnCount;
    private Controller cont;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);
        initializeComponents(v);
        initializeListener();
        return v;
    }

    public void setController(Controller controller){
        cont = controller;
    }

    private void initializeListener() {
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.btnClick();
            }
        });
    }

    private void initializeComponents(View v) {
        btnCount = (Button)v.findViewById(R.id.button);
    }

}
