package com.example.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawingView extends View {
    private Paint paint = new Paint();
    public DrawingView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        canvas.drawCircle(220, 220, 200, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawRect(20, 440, 420, 640, paint);
        canvas.drawLine(20, 660, 420, 1060, paint);
    }

}
