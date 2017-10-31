package mah.thdta3.robin.android.lab3b;

import android.content.res.Resources;

/**
 * Created by robin on 17/09/2017.
 */

public class Controller {
    private Instructions[] instructions = new Instructions[3];
    private ViewerFragment vF;
    private HowToMain ui;
    private String[] colours = {"RED", "BLUE", "YELLOW", "GREEN"};

    public Controller(ViewerFragment vF, HowToMain ui){
        this.vF = vF;
        this.ui = ui;
        initializeResources();
    }

    private void initializeResources() {
        Resources res = ui.getResources();
        String whatToDo = res.getString(R.string.what_to_do);
        String content = res.getString(R.string.content);
        instructions[0] = new Instructions(whatToDo,content);
        instructions[1] = new Instructions(res.getString(R.string.what_to_do2),res.getString(R.string.content2));
        instructions[2] = new Instructions(res.getString(R.string.what_to_do3),res.getString(R.string.content3));
    }


    public void lvClick(int i){
        vF.setWTD(instructions[i].getWhatToDo());
        vF.setContent(instructions[i].getContent());

    }
}
