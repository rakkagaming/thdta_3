package mah.thdta3.robin.android.lab7d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by robin on 25/09/2017.
 */

public class Poop extends TextView {
    private int[] colors = {Color.BLUE,Color.CYAN,Color.DKGRAY, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW};
    MainActivity ui;
    private int i = 0;

    public void party(MainActivity ui){
        this.ui = ui;
        ColourChanger cc = new ColourChanger();
        cc.start();
    }

    public Poop(Context context) {
        super(context);
    }

    public Poop(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Poop(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Poop(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void update() {
        post(new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(colors[i%7]);
        i++;
        canvas.drawPaint(paint);
        super.onDraw(canvas);
    }
    @Override
    public void setBackgroundColor(@ColorInt int color) {
        super.setBackgroundColor(color);
    }


    private class ColourChanger extends Thread{

       @Override
       public void run(){

               update();
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

       }

   }
}
