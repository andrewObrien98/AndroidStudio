package com.usu.minesweeperstarter;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {

    private enum State {
        PLAY,
        WIN,
        LOSE,
    }

    Cell[][] cells;
    int mineCount;
    int rows = 30;
    int cols = 16;
    double cellWidth;
    double cellHeight;
    int screenWidth;
    int screenHeight;
    State state = State.PLAY;
    ArrayList<Boolean> cellsWithMines;
    int totalToggledMines = 0;


    public Game(String gameMode, int screenWidth, int screenHeight) {
        cells = new Cell[rows][cols];
        if (gameMode.equals("expert")) {
            mineCount = 100;
        } else if (gameMode.equals("intermediate")) {
            mineCount = 50;
        } else {
            mineCount = 10;
        }
        cellHeight = (double)screenHeight / rows;
        cellWidth = (double)screenWidth / cols;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        initCells();
    }

    private void initCells() {
        cellsWithMines = new ArrayList<>();
        int currentMineCount = 0;
        for(int i = 0; i < 16*30; i++){
            //false if they wont have mines
            //true if they will have mines
            cellsWithMines.add(currentMineCount < mineCount);
            currentMineCount++;
        }
        Collections.shuffle(cellsWithMines);
        initCells(cellsWithMines);//this one will actually create the cells now
        countNeighbors(cellsWithMines);//this will go through every cell and see what cells are close to mines

       // TODO: create all cells, randomly assigning cells to be mines depending on difficulty.
        // HINT: 1. Create an ArrayList of Booleans
        //      2. set the first n (where n is number of mines you want) to be true
        //      3. set the remaining to be false (the total number of items in the list should be rows * cols)
        //      4. then shuffle the array list using Collections.shuffle()
        //      5. Then you can use this arraylist like a queue when iterating of your grid
    }

    private void initCells(ArrayList<Boolean> mineList){
        double top = 0 - cellHeight;
        double bottom = 0;
        for(int i = 0; i < cells.length; i++){
            double left = 0;
            double right = cellWidth;
            top += cellHeight;
            bottom += cellHeight;
            for(int j = 0; j < cells[i].length; j++){
                boolean mine = mineList.get(i*16 + j);
                if (mine) {
                    cells[i][j] = new Cell(left, top, right, bottom, Cell.Type.MINE );
                } else {
                    cells[i][j] = new Cell(left, top, right, bottom, Cell.Type.EMPTY );
                }
                left += cellWidth;
                right += cellWidth;
            }
        }
    }

    private void countNeighbors(ArrayList<Boolean> listOfMines){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                if(cells[i][j].getType() != Cell.Type.MINE){//make sure it doesn't add neighbors to mines
                    int numNeighbors = 0;
                    numNeighbors += countNeighbors(i + 1 , j -1, listOfMines);
                    numNeighbors += countNeighbors(i + 1 , j, listOfMines);
                    numNeighbors += countNeighbors(i + 1 , j + 1, listOfMines);
                    numNeighbors += countNeighbors(i  , j + 1, listOfMines);
                    numNeighbors += countNeighbors(i  , j -1, listOfMines);
                    numNeighbors += countNeighbors(i - 1 , j - 1, listOfMines);
                    numNeighbors += countNeighbors(i - 1 , j, listOfMines);
                    numNeighbors += countNeighbors(i - 1 , j + 1, listOfMines);

                    if(numNeighbors > 0){
                        cells[i][j].setType(Cell.Type.NUMBER);
                    }
                    cells[i][j].setNumNeighbors(numNeighbors);
                }
            }
        }
    }

    private int countNeighbors(int row, int col, ArrayList<Boolean> list) {//, Cell[][] cells
        // TODO: Count how many mines surround the cell at (row, col);
        if(row < 0 || col < 0 || row >= rows || col >= cols ) return 0;
        else if(list.get(row*16 + col)) return 1;
        return 0;
    }

    private void revealMines() {
        for(int row = 0; row < cells.length; row++){
            for(int col = 0; col < cells[row].length; col++){
                if(cells[row][col].getType() == Cell.Type.MINE){
                    cells[row][col].select();
                }
            }
        }

        // TODO: loop through the cells and select all mines
    }

    private void explodeBlankCells(int row, int col) {
        if(row < 0 || row >= cells.length)return;
        if(col < 0 || col >= cells[row].length)return;
        if(cells[row][col].isSelected())return;
        cells[row][col].select();
        if(cells[row][col].getType() == Cell.Type.NUMBER) return;
        explodeBlankCells(row - 1, col - 1);
        explodeBlankCells(row -1, col);
        explodeBlankCells(row - 1, col + 1);
        explodeBlankCells(row, col - 1);
        explodeBlankCells(row , col + 1);
        explodeBlankCells(row + 1, col - 1);
        explodeBlankCells(row + 1, col );
        explodeBlankCells(row + 1, col + 1);

        // TODO: recursively select all surrounding cells, only stopping when
        //      you reach a cell that has already been selected,
        //      or when you select a cell that is not Empty
    }


    public void handleTap(MotionEvent e) {
        if(state == State.PLAY) {
            double x = e.getX() / cellWidth;
            double y = e.getY() / cellHeight;
            int col = (int) x;
            int row = (int) y;
            if (cells[row][col].getType() == Cell.Type.MINE) {
                state = State.LOSE;
                revealMines();
            } else {
                explodeBlankCells(row, col);
            }
        }

        // TODO: find the cell the player tapped
        //      Depending on what type of cell they tapped
        //         mine: select the cell, reveal the mines, and set the game to the LOSE state
        //         empty cell: select the cell and explode the surrounding cells
        //         all others: simply select the cell
    }

    public void handleLongPress(MotionEvent e) {
        if(state == State.PLAY) {
            double x = e.getX() / cellWidth;
            double y = e.getY() / cellHeight;
            int col = (int) x;
            int row = (int) y;
            cells[row][col].toggleMark();
            if (cells[row][col].getType() == Cell.Type.MINE) {
                totalToggledMines += 1;
            }
            if (totalToggledMines == mineCount) {
                state = State.WIN;
            }
        }
        // TODO: find the cell and toggle its mark
        //       then check to see if the player won the game
    }


    public void draw(Canvas canvas, Paint paint) {
        for(int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].draw(canvas, paint);
                paint.reset();
            }
        } if(state == State.LOSE){
            paint.setTextSize(100);
            paint.setColor(Color.BLACK);
            canvas.drawText("You Lost:(:(",screenWidth/2 - 200, screenHeight /2 , paint);
        }

        if (state == State.WIN) {
            paint.setTextSize(100);
            paint.setColor(Color.BLACK);
            canvas.drawText("You Won!!!",screenWidth/2 - 200, screenHeight /2 , paint);
            // TODO draw a win screen here
        }
    }
}
