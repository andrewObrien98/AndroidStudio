package com.example.customcontrols;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

public class Header extends AppCompatTextView {
    public Header(@NonNull Context context, String text) {
        super(context);
        setText(text);
        setTextSize(24);
        setTextColor(Color.rgb(100,100,100));
        setBackgroundColor(Color.MAGENTA);
        //says anything that is inside this element cannot be within this amount of pixels from the border
        setPadding(40,40,0,40);
        //centers text relative to the borders of the view
        setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //puts space between outside component of the border and side of its next border
        params.setMargins(40,120,40,0);
        setLayoutParams(params);

    }
}
