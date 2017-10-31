package mah.thdta3.robin.android.lab7c;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by robin on 25/09/2017.
 */

public class TextExtender extends TextView {

    MainActivity ui;

    public void party(MainActivity ui){
        this.ui = ui;
        ColourChanger cc = new ColourChanger();
        cc.execute(0);
    }

    public TextExtender(Context context) {
        super(context);
    }

    public TextExtender(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextExtender(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TextExtender(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setBackgroundColor(@ColorInt int color) {
        super.setBackgroundColor(color);
    }

    public class ColourChanger extends AsyncTask<Integer,Void,Void> {
        private int[] colors = {Color.BLUE,Color.CYAN,Color.DKGRAY, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW};
        int pos;

        @Override
        protected Void doInBackground(Integer... params) {
            pos = params[0];
            for (int i = 0; i < 40; i++) {
                try {
                    Thread.sleep(50);
                }catch (InterruptedException e){}

                publishProgress();
                pos++;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ui.setTop(Color.TRANSPARENT);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            ui.setTop(colors[pos%7]);
            ui.setBotColour(colors[pos+3%7]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

    }
}
