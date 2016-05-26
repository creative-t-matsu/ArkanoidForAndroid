package com.arkanoid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Block extends Task{
    private Paint paint = new Paint();
    int blockQuantity = 20;

    private class blockClass{
        int x;
        int y;
        boolean disPlay;
    }

    blockClass bc[]= new blockClass[blockQuantity];

    public Block(){
        int counter_y = 0;
        int counter_x = 0;

        for(int i = 0; i < blockQuantity;i++){
            bc[i] = new blockClass();
            bc[i].disPlay = true;

            bc[i].x = counter_x * 60;
            bc[i].y = counter_y * 20;

            counter_x++;

            if(i == 4 || i == 9 || i == 14){
                counter_x = 0;
                counter_y++;
            }
        }

        paint.setColor(Color.MAGENTA);
        paint.setAntiAlias(true);
    }

    @Override
    public boolean onUpdate(){
        for(int i= 0;i < blockQuantity;i++){
            if((Ball.x - bc[i].x) < 30 && (Ball.y - bc[i].y) < 10)
                bc[i].disPlay = false;
                Ball.speed_x *= -1;
                Ball.speed_y *= -1;
        }
        return true;
    }

    @Override
    public  void onDraw(Canvas canvas) {
        for(int i= 0;i < blockQuantity;i++){
            if(bc[i].disPlay)
                canvas.drawRect(bc[i].x + 10,bc[i].y,bc[i].x + 60,bc[i].y + 15,paint);
        }
    }
}
