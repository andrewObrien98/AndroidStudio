package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(6);

        for(int row = 0; row < 6; row++){
            for (int col = 0; col < 6; col++){
                AppCompatTextView textView = new AppCompatTextView(this);
                textView.setText("View " + row + col);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(row, 1, 1f);
                params.columnSpec = GridLayout.spec(col, 1, 1f);
                params.setMargins(10,10,10,10);
                textView.setLayoutParams(params);
                textView.setBackgroundColor(Color.MAGENTA);
                textView.setGravity(Gravity.CENTER);
                gridLayout.addView(textView);
        }}

        setContentView(gridLayout);
    }
}