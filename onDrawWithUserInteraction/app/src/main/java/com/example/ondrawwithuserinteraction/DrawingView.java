package com.example.ondrawwithuserinteraction;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {
    ArrayList<Circle> circles = new ArrayList<>();
    private Paint paint = new Paint();

    public DrawingView(Context context){
        super(context);
        setOnTouchListener((view, event) -> {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                circles.add(new Circle(event.getX(), event.getY(), 25));
                invalidate();//tells it to redraw everything, must add it
            }
            return false;
        });//tells you that they clicked and where
    }

    @Override
    protected void onDraw(Canvas canvas){
        circles.forEach(circle -> {
            canvas.drawCircle(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), paint);
        });
    }
}
