package com.usu.minesweeperstarter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Cell {

    // FEEL FREE TO CHANGE THESE!
    private int[] colors = {
            Color.BLUE,
            Color.GREEN,
            Color.RED,
            Color.rgb(0,0,100),
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA,
            Color.BLACK
    };

    public enum Type {
        MINE,
        NUMBER,
        EMPTY
    }

    private boolean isMarked = false;
    private boolean isSelected = false;
    private Type type;
    private double xPos;
    private double yPos;
    private double width;
    private double height;
    private int numNeighbors = 0;
    public Cell(double xPos, double yPos, double width, double height, Type type) {
        this.type = type;
        this.yPos = yPos;
        this.xPos = xPos;
        this.width = width;
        this.height = height;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void toggleMark() {
        isMarked = !isMarked;
    }

    public void select() {
        isSelected = true;
        isMarked = false;
    }

    public void setNumNeighbors(int numNeighbors) {
        this.numNeighbors = numNeighbors;
    }

    public void draw(Canvas canvas, Paint paint) {
        if(isSelected()){
            if(type == Type.MINE ){
                paint.setColor(Color.WHITE);
                canvas.drawRect((float)xPos + 2, (float) yPos + 2, (float) width - 2, (float) height - 2, paint);
                paint.setTextSize(50);
                paint.setColor(colors[2]);
                canvas.drawText("X", (float) xPos + 25,(float) yPos + 45, paint);}
             else if (type == Type.NUMBER ){
                    paint.setColor(Color.LTGRAY);
                    canvas.drawRect((float)xPos + 2, (float) yPos + 2, (float) width - 2, (float) height - 2, paint);
                    paint.setTextSize(50);
                    paint.setColor(getColor());
                    canvas.drawText(numNeighbors + "", (float) xPos + 25,(float) yPos + 45, paint);
            } else {
                    paint.setColor(Color.LTGRAY);
                    canvas.drawRect((float)xPos + 2, (float) yPos + 2, (float) width - 2, (float) height - 2, paint);
            }
        } else if (isMarked()){
            paint.setColor(Color.RED);
            canvas.drawRect((float)xPos + 2, (float) yPos + 2, (float) width - 2, (float) height - 2, paint);
        }
        else{
            paint.setColor(Color.DKGRAY);
            canvas.drawRect((float)xPos + 2, (float) yPos + 2, (float) width - 2, (float) height - 2, paint);
        }

        // TODO: Draw the cell at its position depending on the state it is in
    }
    public int getColor(){
        if (numNeighbors < 2) return colors[0];//blue
        if(numNeighbors == 2) return colors[1];//green
        return colors[5];//cyan

    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
