package mah.thdta3.robin.android.lab3a;

/**
 * Created by robin on 16/09/2017.
 */

public class Controller {
    private ViewerFragment vF;
    private InputFragment iF;
    private String[] colours = {"RED", "BLUE", "YELLOW", "GREEN"};

    public Controller(ViewerFragment vF, InputFragment iF){
        this.vF = vF;
        this.iF = iF;
    }

    public void btnClick(int i){
        vF.setBackgroundColour(colours[i]);
    }


    public void lvClick(String s){
        iF.setText(s);
    }
}
