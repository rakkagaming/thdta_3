package com.mah.ag0071.lab3c;

import android.content.res.Resources;

/**
 * Created by User on 2017-09-14.
 */

public class Controller {

    private WhatToDoFragment whatToDoFragment;
    private InstructionFragment instructionFragment;
    private MainActivity mainActivity;
    private Instruction[] instructions = new Instruction[3];
    private int position;


    public Controller (MainActivity mainActivity){
        this.mainActivity = mainActivity;
        instructionFragment = new InstructionFragment();
        instructionFragment.setController(this);
        whatToDoFragment = new WhatToDoFragment();
        whatToDoFragment.setController(this);
        mainActivity.setFragment(whatToDoFragment,false);
        initRes();
    }


    private void initRes() {
        Resources res = mainActivity.getResources();
        instructions[0] = new Instruction(res.getString(R.string.what_to_do),res.getString(R.string.content));
        instructions[1] = new Instruction(res.getString(R.string.what_to_do2),res.getString(R.string.content2));
        instructions[2] = new Instruction(res.getString(R.string.what_to_do3),res.getString(R.string.content3));

    }


    public void changeView(int position) {
        mainActivity.setFragment(instructionFragment,true);
        this.position = position;
    }

    public void updateView() {
        instructionFragment.updateText(instructions[position].getWhatToDO(),instructions[position].getContent());
    }
}
