package com.example.calculator;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

public class Expression extends AppCompatTextView {
    String expression = "";
    String lastExpression = "";
    Expression(Context context){
        super(context);
        setText("");
        setTextSize(30);
        setTextColor(getResources().getColor(R.color.white));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        setGravity(Gravity.CENTER);
        setLayoutParams(params);
    }

    public void insert(String expression){
        if(this.expression.length() == 0 && expression.equals("-")){
            this.expression += "" + "-";
        } else if(expression.equals("-") && (lastExpression.equals("*") || lastExpression.equals("-") || lastExpression.equals("/") || lastExpression.equals("+"))){
            this.expression += "-";
        } else if(expression.equals("*") || expression.equals("-") || expression.equals("/") || expression.equals("+")){
            this.expression += " " + expression + " ";
        } else {
            this.expression += expression;
        }
        setText(this.expression);
        lastExpression = expression;
    }
    public void setExpression(String E){
        this.expression = E ;
        setText(this.expression);
    }


    public String getExpression(){
        return this.expression;
    }
}
