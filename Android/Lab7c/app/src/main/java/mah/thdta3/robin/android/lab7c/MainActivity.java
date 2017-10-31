package mah.thdta3.robin.android.lab7c;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Controller controller;
    private TextExtender pooptxt;
    private TextView txtBot;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller(this);
        initializeComponents();
        initializeListeners();
    }

    private void initializeListeners() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.startATask();
            }
        });
    }

    private void initializeComponents() {
        txtBot = (TextView)findViewById(R.id.botTxt);
        pooptxt = (TextExtender)findViewById(R.id.topTxt);
        btn = (Button)findViewById(R.id.button);
    }

    public void setBotColour(int colour) {
        txtBot.setBackgroundColor(colour);
    }

    public void setTop(int colour) {
        pooptxt.setBackgroundColor(colour);
    }
}
