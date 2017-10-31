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
public class LoginFragment extends Fragment {

    private Controller controller;
    private Button loginBtn;
    private Button signupBtn;
    private EditText usernameET;
    private EditText passwordET;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        initializeComponents(v);
        initializeListners();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.setLogin();
        if (controller.checkFlag()){controller.restoreLogin();}
    }

    private void initializeListners() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send inserted data to check if it is a User
                Boolean status = controller.login();
                if (status) {
                    Toast.makeText(getActivity(), "Logged In", Toast.LENGTH_SHORT).show();
                    controller.startMainActivity();
                }else Toast.makeText(getActivity(), "Wrong User Information", Toast.LENGTH_SHORT).show();
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send the user to the signup page
                controller.goToSignup();
            }
        });
    }

    private void initializeComponents(View v) {
        loginBtn = (Button)v.findViewById(R.id.loginLogin);
        signupBtn = (Button)v.findViewById(R.id.loginSignup);
        usernameET = (EditText)v.findViewById(R.id.loginName);
        passwordET = (EditText)v.findViewById(R.id.loginPassword);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public String getUsername(){
        return usernameET.getText().toString();
    }

    public String getPassword(){
        return passwordET.getText().toString();
    }

    public void setPassword(String s) {
        passwordET.setText(s);
    }

    public void setUsername(String s){
        usernameET.setText(s);
    }

}
