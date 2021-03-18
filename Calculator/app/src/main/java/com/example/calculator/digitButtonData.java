package com.example.calculator;

public class digitButtonData {
    public String text;
    public int row;
    public int col;
    public int colSpan;
    public int color;

    public digitButtonData(String text, int row, int col, int colSpan, int color){
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
        this.color = color;
    }
}
