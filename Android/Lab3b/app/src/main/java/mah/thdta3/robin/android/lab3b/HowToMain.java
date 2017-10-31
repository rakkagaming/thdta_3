package mah.thdta3.robin.android.lab3b;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HowToMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_main);
        initializeSystem();
    }

    private void initializeSystem() {
        FragmentManager fm = getFragmentManager();
        ViewerFragment viewer = (ViewerFragment)fm.findFragmentById(R.id.viewerFragment);
        InputFragment input = (InputFragment)fm.findFragmentById(R.id.inputFragment);
        Controller controller = new Controller(viewer,this);
        input.setController(controller);
    }

}
