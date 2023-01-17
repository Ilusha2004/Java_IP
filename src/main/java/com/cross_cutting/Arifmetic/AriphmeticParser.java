package com.cross_cutting.Arifmetic;


import com.cross_cutting.HelpfulThings.HepfulStrings;

import java.util.StringTokenizer;

public class AriphmeticParser {

    private String data;

    public AriphmeticParser(String data) {
        this.data = data;
    }

    private String DeleteLatine() {
        StringTokenizer tokenizer = new StringTokenizer(data, HepfulStrings.getAlphabetLH());
        String temp = new String("");

        while (tokenizer.hasMoreTokens()) {
            temp += tokenizer.nextElement();
        }

        return temp;
    }

    public Double getResult() {

        String[] arr = DeleteLatine().split("(?=([+\\-*/]))");

        Double result = Double.parseDouble(arr[0]);

        for (Integer i = 1; i < arr.length; i++) {

            try {
                String[] temp = arr[i].split("[.]{2,}");

                for(var id : temp) {
                    System.out.println(id);
                    result = performCalculation(result, id);
                }

            } catch (Exception e) {
                e.getMessage();
            }

        }

        return result;
    }

    private Double performCalculation(Double currentResult, String operationAndNumber) {

        String[] operationAndNumberArr = operationAndNumber.split("");

        String operation = operationAndNumberArr[0];

        Double number = Double.parseDouble(operationAndNumber.substring(1, operationAndNumber.length()));

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

    public static void main(String[] args) {
        AriphmeticParser ariphmeticParser = new AriphmeticParser("khgh9.9+*ghghjgvj75++89");
        System.out.println(ariphmeticParser.getResult());

    }

}
