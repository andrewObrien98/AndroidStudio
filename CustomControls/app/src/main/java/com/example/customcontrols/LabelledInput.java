package com.example.customcontrols;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

public class LabelledInput extends LinearLayout {
    private AppCompatEditText field;
    public LabelledInput(Context context, String text) {
        super(context);
        setOrientation(VERTICAL);
        AppCompatTextView label = new AppCompatTextView(context);
        label.setText(text);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //params.weight = 1;
        params.setMargins(200,20,20,20);
        label.setLayoutParams(params);
        //color with int values
        label.setTextColor(Color.rgb(0,200,0));


        this.field = new AppCompatEditText(context);
        addView(label);
        addView(this.field);
        LayoutParams fieldParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //fieldParams.weight = 1;
        this.field.setLayoutParams(fieldParams);
        //color with floats that represent ratios of how much you saturate each color into it, these are floats not doubles so include the F
        this.field.setTextColor(Color.rgb(0f, 0, 1f));
    }

    public Editable getText(){
        return field.getText();
    }
}
