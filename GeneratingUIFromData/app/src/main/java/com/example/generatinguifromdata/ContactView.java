package com.example.generatinguifromdata;

import android.content.Context;
import android.graphics.Color;
import android.service.autofill.FieldClassification;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatTextView;

public class ContactView extends LinearLayout {
    public ContactView(Context context, Contact contact) {
        super(context);
        setOrientation(VERTICAL);
        setBackgroundColor(Color.GRAY);
        AppCompatTextView personNameView = new AppCompatTextView(context);
        personNameView.setText(contact.getPersonName());
        personNameView.setTextSize(18);
        personNameView.setTextColor(Color.WHITE);

        AppCompatTextView phoneNumberView = new AppCompatTextView(context);
        phoneNumberView.setText(contact.getPhoneNumber());
        phoneNumberView.setTextColor(Color.WHITE);

        AppCompatTextView emailView = new AppCompatTextView(context);
        emailView.setText(contact.getEmail());
        emailView.setTextColor(Color.WHITE);

        addView(personNameView);
        addView(phoneNumberView);
        addView(emailView);

        setPadding(12, 12, 12, 12);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,24,0,24);
        setLayoutParams(params);

    }
}
