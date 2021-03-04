package com.example.customcontrols;

import android.content.Context;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

public class Header extends AppCompatTextView {
    public Header(@NonNull Context context, String text) {
        super(context);
        setText(text);
        setTextSize(24);
        setTextColor(Color.rgb(100,100,100));
    }
}
