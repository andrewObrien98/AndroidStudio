package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<digitButtonData> calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeData();
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        GridLayout digitButtonsLayout = new GridLayout(this);
        digitButtonsLayout.setColumnCount(4);
        Expression answerText = new Expression(this);

        for(digitButtonData data : calcButton){
            CalcButton button = new CalcButton(this, data,
                    view -> {
                if(data.text.equals("=")){
                    Double answer = calculator.evaluate(answerText.getExpression());
                    String word = Double.toString(answer);
                    answerText.setExpression(word);
                }
                else if(data.text.equals("C")){
                    answerText.setExpression("");
                }
                else{
                answerText.insert(data.text);
                }
            });
            digitButtonsLayout.addView(button);
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 5;
        digitButtonsLayout.setLayoutParams(params);
        mainLayout.addView(answerText);
        mainLayout.addView(digitButtonsLayout);
        mainLayout.setBackgroundColor(getColor(R.color.black));
        setContentView(mainLayout);
    }

    private void initializeData(){
        calcButton = new ArrayList<digitButtonData>(){
            {
                add(new digitButtonData(getString(R.string.seven), 0, 0, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.eight), 0, 1, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.nine), 0, 2, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.division), 0, 3, 1, getResources().getColor(R.color.expressions, null)));
                add(new digitButtonData(getString(R.string.four), 1, 0, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.five), 1, 1, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.six), 1, 2, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.multiplication), 1, 3, 1, getResources().getColor(R.color.expressions, null)));
                add(new digitButtonData(getString(R.string.one), 2, 0, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.two), 2, 1, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.three), 2, 2, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.subtraction), 2, 3, 1, getResources().getColor(R.color.expressions, null)));
                add(new digitButtonData(getString(R.string.zero), 3, 0, 2, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.dot), 3, 2, 1, getResources().getColor(R.color.digits, null)));
                add(new digitButtonData(getString(R.string.addition), 3, 3, 1, getResources().getColor(R.color.expressions, null)));
                add(new digitButtonData(getString(R.string.equals), 4, 0, 2, getResources().getColor(R.color.expressions, null)));
                add(new digitButtonData(getString(R.string.clear), 4, 2, 2, getResources().getColor(R.color.expressions, null)));
            }
        };
    }
}