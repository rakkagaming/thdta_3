package mah.thdta3.robin.android.lab7c;

/**
 * Created by robin on 25/09/2017.
 */

public class Controller{
    private MainActivity ui;
    private TextExtender view;

    public Controller(MainActivity ui){
        this.ui = ui;
        view = new TextExtender(ui);

    }

    public void startATask() {
        view.party(ui);
    }

    private void setBot(int color) {
        ui.setBotColour(color);
    }

    private void setTop(int color) {
        ui.setTop(color);
    }

}
