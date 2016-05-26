package com.arkanoid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class MainActivity extends Activity {

    public static boolean move = false;
    public static int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameSurfaceView(this));
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                move = false;
                break;
            case MotionEvent.ACTION_MOVE:
                move = true;
                x = (int)e.getX();
                break;
        }
        return true;
    }
}
