package mah.thdta3.robin.android.lab7d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Controller controller;
    private Poop pooptxt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller(this);
        initializeComponents();
        initializeListeners();

        Timer timer = new Timer();
        TimerTask tT = new TimerTask() {
            @Override
            public void run() {
                controller.startATask();
            }
        };
        timer.schedule(tT,50,500);
    }

    private void initializeListeners() {
    }

    private void initializeComponents() {
        pooptxt = (Poop)findViewById(R.id.t1);
        btn = (Button)findViewById(R.id.);
    }

    public void setTop(int colour) {
        pooptxt.setBackgroundColor(colour);
    }
}
