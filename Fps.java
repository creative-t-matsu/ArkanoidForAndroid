package com.arkanoid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Fps extends Task{

    private long startTime = 0;
    private int count = 0;
    private Paint paint = new Paint();
    private float fps;
    private final static int sampleFps = 60;
    private final static int fontSize = 20;

    public Fps(){
        paint.setColor(Color.BLUE);
        paint.setTextSize(fontSize);
    }

    @Override
    public boolean onUpdate(){
        if(count == 0)
            startTime = System.currentTimeMillis();

        if(count == sampleFps){
            long t = System.currentTimeMillis();
            fps = 1000.f/((t-startTime)/(float)sampleFps);
            count = 0;
            startTime = t;
        }

        count++;
        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawText(String.format("%.1f", fps), 0, fontSize - 2, paint);
    }
}
