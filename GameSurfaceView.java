package com.arkanoid;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable{
    private GameManager _gameManager = new GameManager();
    private Thread _thread;

    public GameSurfaceView(Context context){
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,int format,int width,int heidht){}

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        _thread = new Thread(this);
        _thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        _thread = null;
    }

    @Override
    public void run(){
        while (_thread!=null){
            _gameManager.onUpdate();
            onDrawMain(getHolder());
        }
    }

    private void onDrawMain(SurfaceHolder holder){
        Canvas canvas = holder.lockCanvas();

        if(canvas == null)
            return;

        _gameManager.onDraw(canvas);
        holder.unlockCanvasAndPost(canvas);
    }
}
