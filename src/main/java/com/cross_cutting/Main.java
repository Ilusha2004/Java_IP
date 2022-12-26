package com.cross_cutting;

import java.util.StringTokenizer;

import com.cross_cutting.HelpfulThings.HepfulStrings;

public class Main {
    public static void main(String[] args) {
        String str = "298798+379879-hkfasjhkhsfmkiac-acag-adh1vca*gh5/atgax2srgfb*4sgag5";

        StringTokenizer tokenizer = new StringTokenizer(str, HepfulStrings.getAlphabetLH());
        String temp = "";

        while(tokenizer.hasMoreTokens()) {
            temp += tokenizer.nextElement();
        }
        
        System.out.println(temp);

        String[] arr = temp.split("(?=([+\\-*/]))");

        for(String id : arr) {
            System.out.println(id);
        }

        int result = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            try {
                result = performCalculation(result, arr[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(result);
    }
 
    public static int performCalculation(int currentResult, String operationAndNumber) {
        String[] operationAndNumberArr = operationAndNumber.split("");
        String operation = operationAndNumberArr[0];

        int number = Integer.parseInt(operationAndNumber.substring(1, operationAndNumber.length()));

        switch (operation) {
            case "+":
                return currentResult + number;
            case "-":
                return currentResult - number;
            case "*":
                return currentResult * number;
            case "/":
                return currentResult / number;
            default:
                throw new UnsupportedOperationException("Unsupported operation!");
        }

    }

}
