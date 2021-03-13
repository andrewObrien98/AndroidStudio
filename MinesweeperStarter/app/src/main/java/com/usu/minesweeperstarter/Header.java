package com.usu.minesweeperstarter;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatTextView;

public class Header extends AppCompatTextView {
    public Header(Context context){
        super(context);
        setTextSize(32);
        setText("!!MineSweeper!!");
        setGravity(Gravity.CENTER);
    }
}
