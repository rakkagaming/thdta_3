package mah.thdta3.robin.android.assignment1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Controller controller;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent intent = getIntent();
        controller.createUser(intent);
        controller.getTransactions();
    }

    public void setFragment(Fragment fragment, boolean backstack){
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.menuContainer, fragment);
        if (backstack){
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    public void removeFragment(Fragment fragment){
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        //ft.remove(fragment);
        ft.detach(fragment);
        ft.commit();
    }

}
