package mah.thdta3.robin.android.lab7b;

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
        cc.start();
    }

    private void setBot(int color) {
        ui.setBotColour(color);
    }

    private void setTop(int color) {
        ui.setTop(color);
    }



   private class ColourChanger extends Thread{
       private int index =0;
       @Override
       public void run() {
           for (int i = 0; i < 100; i++) {
               index = index % colors.length;
               ui.runOnUiThread(new SetColour(colors[index]));
               try {
                   sleep(100);
               } catch (InterruptedException e) {

               }
               index++;
               super.run();
           }

       }
   }

   private class SetColour implements Runnable{

       private int colour;
       public SetColour(int colour){
           this.colour = colour;
       }

       @Override
       public void run(){
           setTop(colour);
           setBot(colour);
       }
   }
}
