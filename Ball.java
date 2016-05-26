package com.arkanoid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball extends Task{
    private final static float ballSize = 20;
    static int x;
    static int y;
    static int speed_x;
    static int speed_y;
    private Paint paint = new Paint();

    public Ball(){
        x = 300;
        y = 400;
        speed_x = 2;
        speed_y = -2;
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
    }

    @Override
    public boolean onUpdate(){
        x+=speed_x;
        y+=speed_y;

        if(x > 400)
            speed_x *= -1;
        else if(x < 0)
            speed_x *= -1;

        if(y > 600)
            speed_y *= -1;
        if(y < 0)
            speed_y *= -1;

        return true;
    }

    @Override
    public void onDraw(Canvas canvas){
        canvas.drawCircle(x,y,20,paint);
    }

}
