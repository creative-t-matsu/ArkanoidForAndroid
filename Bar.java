package com.arkanoid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class Bar extends Task{

    int bar_x;
    int bar_y;
    boolean hit;
    private Paint paint = new Paint();

    public Bar(){
        bar_x = 500;
        bar_y = 1400;
        hit = false;
        paint.setColor(Color.MAGENTA);
        paint.setAntiAlias(true);
    }


    @Override
    public boolean onUpdate(){
        if(MainActivity.move)
            bar_x = MainActivity.x;

        if(Math.abs(Ball.x - bar_x) <= 120  && Math.abs(Ball.y - bar_y) <= 40){
            //---ボールが当たる領域内に侵入した---//
            //---各々の中心の絶対値が各々の半径の合計以下の場合、接触とみなせる可能性がある---//
            hit = true;
        }

        //---ヒット時の処理---//
        if(hit){
            if(Math.abs(Ball.x - bar_x) > 120 && Math.abs(Ball.y - bar_y) > 40){
                //---角の処理---//
                //---現状の位置をまず判定---//
                if(120 - Math.abs(Ball.x - bar_x) == 40 - Math.abs(Ball.y - bar_y)){
                    //---接触部分のX側とY側が等しいのなら、完全に角に接触しているとみなせる可能性がある---//
                    Ball.speed_x *= -1;
                    Ball.speed_y *= -1;
                    hit = false;
                }else if(120 - Math.abs(Ball.x - bar_x) > 40 - Math.abs(Ball.y - bar_y)){
                    //---X側の方が大きい場合、角ではあるが上下の辺に寄っているとみなせる可能性がある---//
                    Ball.speed_y *= -1;
                    hit = false;
                }else if(120 - Math.abs(Ball.x - bar_x) < 40 - Math.abs(Ball.y - bar_y)){
                    //---Y側の方が大きい場合、角ではあるが上下の辺に寄っているとみなせる可能性がある---//
                    Ball.speed_x *= -1;
                    hit = false;
                }
            }else{
                //---角以外（＝辺部分）の処理---//
                if(120 - Math.abs(Ball.x - bar_x) > 40 - Math.abs(Ball.y - bar_y)){
                    //---上辺・下辺の判定---//
                    //---X側とY側で半径合計と中心の絶対値の差分を比較、X側が大きければ上辺、下辺のどちらかに接触とみなせる可能性がある---//
                    Ball.speed_y *= -1;
                    hit = false;
                }else {
                    //---上辺・下辺以外（＝側面）の判定---//
                    Ball.speed_x *= -1;
                    hit = false;
                }
            }
        }

        return true;
    }

    @Override
    public  void onDraw(Canvas canvas) {
        canvas.drawRect(bar_x - 100,bar_y - 20,bar_x + 100,bar_y + 20,paint);
    }
}
