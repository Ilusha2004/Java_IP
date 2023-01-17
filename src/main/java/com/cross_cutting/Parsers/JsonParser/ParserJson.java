package com.cross_cutting.Parsers.JsonParser;

import com.cross_cutting.Arifmetic.AriphmeticParser;
import com.cross_cutting.Parsers.Parser;
import com.cross_cutting.Parsers.SingletonResulList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserJson extends Parser {
    private ArrayList<Double> rezuList = new ArrayList<>();

    public ParserJson(String inPath) {
        super(inPath);
    }

    @Override
    public void parse() {

        try {
            FileReader read = new FileReader(getInPath());
            JSONParser Parser = new JSONParser();
            JSONObject object = null;

            try {
                object = (JSONObject) Parser.parse(read);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            JSONArray array = (JSONArray) object.get("arithmetic");

            var iterator = array.iterator();

            while (iterator.hasNext()) {
                JSONObject temp = (JSONObject) iterator.next();
                String result = temp.get("RawString").toString();
                AriphmeticParser tAriphmeticParser = new AriphmeticParser(result);
                rezuList.add(tAriphmeticParser.getResult());
            }

            SingletonResulList.getInstance(rezuList);

        } catch (FileNotFoundException exp) {
            System.out.println(exp.getMessage());
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        } catch (NullPointerException exp) {
            System.out.println(exp.getMessage());
        }

    }

}