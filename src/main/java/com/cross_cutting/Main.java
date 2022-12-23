package com.cross_cutting;

public class Main {
    public static void main(String[] args) {
        String str = "2+3---1*5/2*45";
        String[] arr = str.split("(?=([+\\-*/]))");

        for(String id : arr) {
            System.out.println(id);
        }

        int result = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            try {
                result = performCalculation(result, arr[i]);
            } catch (Exception e) {
                e.getStackTrace();
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
