package mah.thdta3.robin.android.lab7e;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Controller controller;
    private Poop t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller(this);
        initializeComponents();

        Timer timer = new Timer();
        TimerTask tT1 = new TimerTask() {
            @Override
            public void run() {
                controller.startATask1();
            }
        };
        TimerTask tT2 = new TimerTask() {
            @Override
            public void run() {
                controller.startATask2();
            }
        };
        TimerTask tT3 = new TimerTask() {
            @Override
            public void run() {
                controller.startATask3();
            }
        };
        TimerTask tT4 = new TimerTask() {
            @Override
            public void run() {
                controller.startATask4();
            }
        };
        TimerTask tT5 = new TimerTask() {
            @Override
            public void run() {
                controller.startATask5();
            }
        };

        timer.schedule(tT1, 5, 25);
        timer.schedule(tT2, 20, 25);
        timer.schedule(tT3, 15, 25);
        timer.schedule(tT4, 10, 25);
        timer.schedule(tT5, 25, 25);
    }

    private void initializeComponents() {
        t1 = (Poop) findViewById(R.id.t1);
        t2 = (Poop) findViewById(R.id.t2);
        t3 = (Poop) findViewById(R.id.t3);
        t4 = (Poop) findViewById(R.id.t4);
        t5 = (Poop) findViewById(R.id.t5);
        t6 = (Poop) findViewById(R.id.t6);
        t7 = (Poop) findViewById(R.id.t7);
        t8 = (Poop) findViewById(R.id.t8);
        t9 = (Poop) findViewById(R.id.t9);
        t10 = (Poop) findViewById(R.id.t10);
        t11 = (Poop) findViewById(R.id.t11);
        t12 = (Poop) findViewById(R.id.t12);
        t13 = (Poop) findViewById(R.id.t13);
        t14 = (Poop) findViewById(R.id.t14);
        t15 = (Poop) findViewById(R.id.t15);

    }
}
