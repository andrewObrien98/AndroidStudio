package com.example.generatinguifromdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Contact> contacts = MockDatabase.getContact(10);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        ScrollView scrollView = new ScrollView(this);

        //generate UI for each contact
        for(Contact contact: contacts){
            ContactView contactView = new ContactView(this, contact);
            mainLayout.addView(contactView);
        }

        //can only take one child
        scrollView.addView(mainLayout);
        setContentView(scrollView);
    }
}