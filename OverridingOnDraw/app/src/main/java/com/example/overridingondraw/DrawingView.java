package com.example.overridingondraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class DrawingView extends View {
    public DrawingView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawCircle(220, 220, 200, new Paint());
        canvas.drawRect(20, 440, 420, 640, new Paint());
        canvas.drawLine(20, 660, 420, 1060, new Paint());
    }
}
