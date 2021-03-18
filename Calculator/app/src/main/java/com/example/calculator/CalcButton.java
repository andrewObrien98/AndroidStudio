package com.example.calculator;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;

public class CalcButton extends AppCompatButton {
    public CalcButton(Context context, digitButtonData data, OnClickListener click){
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.row, 1, 1);
        params.columnSpec = GridLayout.spec(data.col, data.colSpan, 1);
        params.setMargins(7,7,7,7);
        setLayoutParams(params);
        setText(data.text);
        setTextSize(30);
        //create a color in digitbutton class
        setBackgroundColor(data.color);
        setOnClickListener(click);
    }
}
