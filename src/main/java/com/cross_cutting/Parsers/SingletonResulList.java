package com.cross_cutting.Parsers;

import java.util.ArrayList;

public class SingletonResulList {

    private static SingletonResulList instance;
    public static ArrayList<Double> Data;

    private SingletonResulList(ArrayList<Double> resultList){
        Data = resultList;
    }

    public static SingletonResulList getInstance(ArrayList<Double> resultList) {
        if(instance == null) {
            instance = new SingletonResulList(resultList);
        }
        return instance;
    }

}
