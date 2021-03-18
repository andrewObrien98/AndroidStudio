package com.example.calculator;

import java.util.Scanner;

public class calculator {
    public static double evaluate(String expression){
        String[] tokens = expression.split(" ");
        if (tokens.length == 0){
            return Double.NaN;
        }
        if (tokens.length == 1){
            return Double.parseDouble(tokens[0]);
        }
        if(tokens.length == 2){
            return Double.NaN;
        }

        double currentValue = Double.parseDouble(tokens[0]);
        String operation = tokens[1];
        String mode = "value";
        for (int i = 2; i < tokens.length; i++){
            if(mode.equals("value")){
                double foundValue = Double.parseDouble(tokens[i]);
                if(operation.equals("+")){
                    currentValue = currentValue + foundValue;
                }
                if(operation.equals("-")){
                    currentValue = currentValue - foundValue;
                }
                if(operation.equals("/")){
                    currentValue = currentValue / foundValue;
                }
                if(operation.equals("*")){
                    currentValue = currentValue * foundValue;
                }
                mode = "operator";
            } else{
                operation = tokens[i];
                mode = "value";
            }
        }
        return currentValue;
    }

    public static void main(String[] args) {
        String expression = "";
        Scanner scanner = new Scanner(System.in);
        while(!expression.equals("stop")){
            expression = scanner.nextLine().trim();
            if(!expression.equals("stop")){
                double result = calculator.evaluate(expression);
                System.out.println("" + result);
            }
        }
    }
}
