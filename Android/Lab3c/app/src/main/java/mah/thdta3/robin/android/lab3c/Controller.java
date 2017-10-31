package mah.thdta3.robin.android.lab3c;

import android.content.res.Resources;
import android.util.Log;

/**
 * Created by robin on 17/09/2017.
 */

public class Controller {
    private InputFragment whatToDoFragment;
    private ViewFragment instructionFragment;
    private HowToSwitch mainActivity;
    private Instructions[] instructions = new Instructions[3];
    private int position;


    public Controller (HowToSwitch mainActivity){
        this.mainActivity = mainActivity;
        instructionFragment = new ViewFragment();
        instructionFragment.setController(this);
        whatToDoFragment = new InputFragment();
        whatToDoFragment.setController(this);
        mainActivity.setFragment(whatToDoFragment,false);
        initRes();
    }


    private void initRes() {
        Resources res = mainActivity.getResources();
        instructions[0] = new Instructions(res.getString(R.string.what_to_do),res.getString(R.string.content));
        instructions[1] = new Instructions(res.getString(R.string.what_to_do2),res.getString(R.string.content2));
        instructions[2] = new Instructions(res.getString(R.string.what_to_do3),res.getString(R.string.content3));
    }


    public void changeView(int position) {
        mainActivity.setFragment(instructionFragment,true);
        this.position = position;
    }

    public void updateView() {
        instructionFragment.updateText(instructions[position].getWhatToDO(),instructions[position].getContent());
    }
}
