package com.cross_cutting.Parsers.TXTParser;

import com.cross_cutting.Arifmetic.AriphmeticParser;
import com.cross_cutting.Parsers.Parser;
import com.cross_cutting.Parsers.SingletonResulList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TxtParser extends Parser {

    private ArrayList<Double> rezuList = new ArrayList<>();

    public TxtParser(String inPath) {
        super(inPath);
    }

    @Override
    public void parse() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(getInPath()))) {

            while (buffer.ready()) {
                String temp = buffer.readLine().toString();
                AriphmeticParser parser = new AriphmeticParser(temp);
                rezuList.add(parser.getResult());
            }

            SingletonResulList.getInstance(rezuList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}