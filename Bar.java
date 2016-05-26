package com.arkanoid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class Bar extends Task{

    int bar_x;
    int bar_y;
    private Paint paint = new Paint();

    public Bar(){
        bar_x = 500;
        bar_y = 1400;

        paint.setColor(Color.MAGENTA);
        paint.setAntiAlias(true);
    }


    @Override
    public boolean onUpdate(){
        if(MainActivity.move)
            bar_x = MainActivity.x;

        if((Ball.x - bar_x) < 150 && (Ball.x - bar_x) > 0 && (Ball.y - bar_y) > 0 && (Ball.y - bar_y) < 40){
            Ball.speed_y *= -1;
        }

        return true;
    }

    @Override
    public  void onDraw(Canvas canvas) {
        canvas.drawRect(bar_x,bar_y,bar_x + 150,bar_y+ 40,paint);
    }
}
