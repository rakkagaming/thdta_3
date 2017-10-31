package mah.thdta3.robin.android.lab3c;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HowToSwitch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_switch);

        Controller controller = new Controller(this);
    }


    public void setFragment(Fragment fragment,boolean backStack){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameFragment,fragment);
        if(backStack){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
