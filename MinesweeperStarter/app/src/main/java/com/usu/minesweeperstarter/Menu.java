package com.usu.minesweeperstarter;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.widget.AppCompatButton;

public class Menu extends AppCompatButton {
    String levelOfDifficulty;
    public Menu(Context context, String difficulty){
        super(context);
        levelOfDifficulty = difficulty;
        setTextSize(224);
        setText(levelOfDifficulty);
    }
    public String getLevelOfDifficulty(){
        return levelOfDifficulty;
    }
}
