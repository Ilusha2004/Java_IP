package com.cross_cutting.Parsers;

import java.util.StringTokenizer;

import com.cross_cutting.HelpfulThings.HepfulStrings;

public class AriphmeticParser {

    public AriphmeticParser(String data) {
        StringTokenizer tokenizer = new StringTokenizer(data, HepfulStrings.getAlphabetLH());
        String temp = "";

        while(tokenizer.hasMoreTokens()) {
            temp += tokenizer.nextElement();
        }

        String[] arr = temp.split("(?=([+\\-*/]))");

        int result = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            try {
                result = performCalculation(result, arr[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    
    public Integer performCalculation(Integer currentResult, String operationAndNumber) {

        String[] operationAndNumberArr = operationAndNumber.split("");
        String operation = operationAndNumberArr[0];

        Integer number = Integer.parseInt(operationAndNumber.substring(1, operationAndNumber.length()));

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
