package mah.thdta3.robin.android.lab3a;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewerFragment extends Fragment {

    public static final String TAG = "View Fragment";
    private TextView txtView;

    public ViewerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_viewer, container, false);
        initializeComponents(v);
        return v;
    }

    private void initializeComponents(View v) {
        txtView = (TextView)v.findViewById(R.id.txtColour);
    }

    public void setBackgroundColour(String colour){
        txtView.setBackgroundColor(Color.parseColor(colour));
    }

}
