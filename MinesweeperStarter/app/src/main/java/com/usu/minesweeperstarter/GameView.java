package com.usu.minesweeperstarter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;

public class GameView extends View {
    Game game;
    Paint paint = new Paint();
    String gameMode;
    GestureDetectorCompat gesture;
    public GameView(Context context, String gameMode) {
        super(context);
        this.gameMode = gameMode;
        gesture = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {//used to indicate that the player pressed a cell
                //use event to determine where they pressed
                game.handleTap(e);
                invalidate();
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {//used to indicate that the player flagged a cell
                game.handleLongPress(e);
                invalidate();
            }
        });

        // TODO: Define a GestureDetectorCompat with an onSingleTapUp method
        //      and and onLongPress method.
        //      For each method, notify the game while action was performed with the motion Event.
        //      Don't forget to call invalidate()


        setOnTouchListener((view, e) -> {
            // TODO: use your gesture detector here.
            return gesture.onTouchEvent(e);
        });
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        game = new Game(gameMode, getWidth(), getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        game.draw(canvas, paint);
    }
}
