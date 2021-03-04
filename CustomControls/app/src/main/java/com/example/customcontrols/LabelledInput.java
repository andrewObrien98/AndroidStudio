package com.example.customcontrols;

import android.content.Context;
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
        this.field = new AppCompatEditText(context);
        addView(label);
        addView(this.field);
    }

    public Editable getText(){
        return field.getText();
    }
}
