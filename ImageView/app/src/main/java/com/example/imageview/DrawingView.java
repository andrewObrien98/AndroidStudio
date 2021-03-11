package com.example.imageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {
    ArrayList<ImageBoundaries> points = new ArrayList<>();
    Paint paint = new Paint();
    public DrawingView(Context context){
        super(context);
        setOnTouchListener((view, event)->{
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                points.add(new ImageBoundaries((int)event.getX(), (int)event.getY(), (int)event.getX() + 100, (int)event.getY() + 100));
                invalidate();
            }
            return false;
        });
    }

    @Override
    protected void onDraw(Canvas canvas){
        points.forEach(point ->{
            Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher_foreground);
            drawable.setBounds(
                    point.getTopLeft().x,
                    point.getTopLeft().y,
                    point.getBottomRight().x,
                    point.getBottomRight().y);
        });
    }
}
