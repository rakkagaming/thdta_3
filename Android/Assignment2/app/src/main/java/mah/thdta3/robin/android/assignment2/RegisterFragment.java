package mah.thdta3.robin.android.assignment2;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private Controller controller;
    private Button registerBtn;
    private EditText username, group;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        initializeComponents(v);
        initializeListeners();
        return v;
    }

    private void initializeComponents(View v) {
        registerBtn = (Button) v.findViewById(R.id.registerBtn);
        username = (EditText) v.findViewById(R.id.registerUsername);
        group = (EditText) v.findViewById(R.id.registerGroup);
    }

    private void initializeListeners(){
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = controller.register(username.getText().toString(),group.getText().toString());
                Log.d("tracking","Just came back from controller.register");
                Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
