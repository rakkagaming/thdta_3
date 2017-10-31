package mah.thdta3.robin.android.howto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HowToActivity extends AppCompatActivity {

    private Button btnPrev;
    private Button btnNext;
    private TextView txtContent;
    private TextView txtWTD;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);
        initializeComponents();
        controller = new Controller(this);
        initializeListners();
    }

    private void initializeComponents() {
        btnPrev = (Button)findViewById(R.id.btnPrev);
        btnNext = (Button)findViewById(R.id.btnNext);
        txtContent = (TextView)findViewById(R.id.textContent);
        txtWTD = (TextView)findViewById(R.id.textWhatToDo);
    }

    private void initializeListners() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.nextClick();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.previousClick();
            }
        });
    }

    public void setContent(String content) {
        txtContent.setText(content);
    }

    public void setWhatToDo(String whatToDo) {
        txtWTD.setText(whatToDo);
    }
}
