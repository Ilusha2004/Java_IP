package com.cross_cutting;

public class Main {
    public static void main(String[] args) {
        String str = "src/res/arif.json";
        String[] arr = str.split("/");
        String[] extension = arr[arr.length - 1].replace(".", " ").split(" ");
        for(var id : extension){
            System.out.println(id);
        }
//        System.out.printf(extension);
    }

}
