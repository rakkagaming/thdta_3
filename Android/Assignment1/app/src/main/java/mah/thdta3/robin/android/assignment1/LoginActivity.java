package mah.thdta3.robin.android.assignment1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeSystem();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState = controller.saveBundle(outState);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            controller.restoreBundle(savedInstanceState);
        }
    }

    private void initializeSystem() {
        controller = new Controller(this);
    }

    public void setFragment(Fragment fragment,boolean backstack){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        if (backstack){
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    public void startIntent(User user){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("currentUser", user);
        startActivity(intent);
    }
}
