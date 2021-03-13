package com.example.drawingthingswithrotation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class DrawingView extends View {
    Paint paint = new Paint();
    public DrawingView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);// how to change where the origin is
        canvas.rotate(45);//rotates it around the origin
        canvas.drawRect(
                -50,
                -50,
                50,
                50,
                paint
        );// where ever you set the origin is 0,0
        canvas.restore();//sets the origin back to the top left of the screen

        canvas.drawRect(0, 10, 150, 150, paint);
    }
}
