package mah.thdta3.robin.android.assignment1;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    private Controller controller;
    private EditText username,password,firstname,surname;
    private Button signupBtn;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signup, container, false);
        initializeComponents(v);
        initializeListeners();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (controller.checkFlag()){controller.restoreSignup();}
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }


    private void initializeComponents(View v) {
        username = (EditText) v.findViewById(R.id.signupName);
        password = (EditText) v.findViewById(R.id.signupPassword);
        firstname = (EditText) v.findViewById(R.id.signupFirstname);
        surname = (EditText) v.findViewById(R.id.signupSurname);
        signupBtn = (Button) v.findViewById(R.id.signupSignupBtn);
    }
    private void initializeListeners() {

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send the input data and create a new User
                String status = controller.createUser();
                Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public String getUsername() {
        return username.getText().toString();
    }

    public String getPassword() {
        return password.getText().toString();
    }

    public String getFirstname(){
        return firstname.getText().toString();
    }

    public String getSurname() {
        return surname.getText().toString();
    }

    public void setUsename(String s) {
        username.setText(s);
    }
    public void setPassword(String s){
        password.setText(s);
    }
    public void setFirstname(String s){
        firstname.setText(s);
    }
    public void setSurname(String s){
        surname.setText(s);
    }
}
