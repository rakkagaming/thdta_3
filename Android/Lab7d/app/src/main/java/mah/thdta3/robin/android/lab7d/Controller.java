package mah.thdta3.robin.android.lab7d;

/**
 * Created by robin on 25/09/2017.
 */

public class Controller{
    private MainActivity ui;
    private Poop view;

    public Controller(MainActivity ui){
        this.ui = ui;
        view = (Poop)ui.findViewById(R.id.topTxt);

    }

    public void startATask() {
        view.party(ui);
    }

}
