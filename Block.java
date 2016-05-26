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

    blockClass bc[][] = new blockClass[5][4];

    public Block(){
        for(int i = 0; i < 5;i++){
            for(int j = 0; j < 4;j++){
                bc[i][j] = new blockClass();
                bc[i][j].disPlay = true;

                bc[i][j].x = i * 170;
                bc[i][j].y = j * 50;
            }
        }

        paint.setColor(Color.MAGENTA);
        paint.setAntiAlias(true);
    }

    @Override
    public boolean onUpdate(){
        for(int i= 0;i < 5;i++){
            for(int j = 0; j < 4;j++){
                if(bc[i][j].disPlay && (Ball.x - bc[i][j].x) > 0 && (Ball.x - bc[i][j].x) < 150 && (Ball.y - bc[i][j].y) > 0 && (Ball.y - bc[i][j].y) < 40){
                    bc[i][j].disPlay = false;
                    Ball.speed_y *= -1;
                }
            }
        }
        return true;
    }

    @Override
    public  void onDraw(Canvas canvas) {
        for(int i= 0;i < 5;i++){
            for(int j = 0; j < 4;j++) {
                if (bc[i][j].disPlay)
                    canvas.drawRect(bc[i][j].x + 10, bc[i][j].y, bc[i][j].x + 150, bc[i][j].y + 40, paint);
            }
        }
    }

/*
    //---1次元配列---//
    blockClass bc[]= new blockClass[blockQuantity];

    public Block(){
        int counter_y = 0;
        int counter_x = 0;

        for(int i = 0; i < blockQuantity;i++){
            bc[i] = new blockClass();
            bc[i].disPlay = true;

            bc[i].x = counter_x * 150;
            bc[i].y = counter_y * 50;

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
            if(bc[i].disPlay && (Ball.x - bc[i].x) > 0 && (Ball.x - bc[i].x) < 150 && (Ball.y - bc[i].y) > 0 && (Ball.y - bc[i].y) < 40){
                bc[i].disPlay = false;
                Ball.speed_y *= -1;
            }
        }
        return true;
    }

    @Override
    public  void onDraw(Canvas canvas) {
        for(int i= 0;i < blockQuantity;i++){
            if(bc[i].disPlay)
                canvas.drawRect(bc[i].x + 10,bc[i].y,bc[i].x + 150,bc[i].y + 40,paint);
        }
    }
    */
}
