package mah.thdta3.robin.android.lab7a;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;

/**
 * Created by robin on 25/09/2017.
 */

public class Controller {
    private MainActivity ui;
    private int[] colors = {Color.BLUE,Color.CYAN,Color.DKGRAY, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW};

    public Controller(MainActivity ui){
        this.ui = ui;
    }

    public void startATask() {
        ColourChanger cc = new ColourChanger();
        cc.execute(0);
    }

    private void setBot(int color) {
        ui.setBotColour(color);
    }

    private void setTop(int color) {
        ui.setTop(color);
    }



    public class ColourChanger extends AsyncTask<Integer,Void,Void>{

        int pos;

        @Override
        protected Void doInBackground(Integer... params) {
            pos = params[0];
            for (int i = 0; i < 6; i++) {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){}

                publishProgress();
                pos++;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            setBot(colors[pos%7]);
            setTop(colors[pos%3]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

    }
}
