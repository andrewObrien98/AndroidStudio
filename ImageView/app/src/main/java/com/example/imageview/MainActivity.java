package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatImageView imageView = new AppCompatImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);//this is in the drawable folder
        imageView.setBackgroundColor(Color.RED);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setContentView(imageView);
    }
}