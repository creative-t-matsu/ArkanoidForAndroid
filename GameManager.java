package com.arkanoid;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.LinkedList;

public class GameManager {
    private LinkedList<Task> _taskList = new LinkedList<Task>();

    GameManager(){
        _taskList.add(new Fps());
        _taskList.add(new Ball());
        _taskList.add(new Block());
    }

    public boolean onUpdate(){
        for(int i = 0; i < _taskList.size(); i++){
            if(!_taskList.get(i).onUpdate()){
                _taskList.remove(i);
                i--;
            }
        }
        return true;
    }

    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);

        for(int i = 0; i < _taskList.size(); i++){
            _taskList.get(i).onDraw(canvas);
        }
    }
}
