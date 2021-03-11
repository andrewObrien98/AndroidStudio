package com.example.imageview;

import android.graphics.Point;
import android.provider.ContactsContract;

public class ImageBoundaries {
    private int x;
    private int y;
    private int x2;
    private int y2;

    public ImageBoundaries(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }
    public Point getTopLeft(){
        return new Point(x, y);
    }
    public Point getBottomRight(){
        return new Point(x2, y2);
    }
}
