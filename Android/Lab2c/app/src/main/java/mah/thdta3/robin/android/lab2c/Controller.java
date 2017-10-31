package mah.thdta3.robin.android.lab2c;

/**
 * Created by robin on 16/09/2017.
 */

public class Controller {
    private ViewerFragment vF;
    private int count = 0;

    public Controller(ViewerFragment vF){
        this.vF = vF;
    }

    public void btnClick(){
        vF.setText(""+ ++count);
    }
}
