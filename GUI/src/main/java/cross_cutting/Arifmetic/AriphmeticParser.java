package cross_cutting.Arifmetic;


import cross_cutting.HelpfulThings.HepfulStrings;

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

    public Integer getResult() {

        String[] arr = DeleteLatine().split("(?=([+\\-*/]))");

        Integer result = Integer.parseInt(arr[0]);

        for (Integer i = 1; i < arr.length; i++) {
            try {
                result = performCalculation(result, arr[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }

    private Integer performCalculation(Integer currentResult, String operationAndNumber) {

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
