package com.cross_cutting.Parsers.TXTParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.processing.FilerException;

import com.cross_cutting.Arifmetic.AriphmeticParser;

public class TxtParser {
   
    private String path;
    private String outPath;
    
    private static ArrayList<Integer> rezuList = new ArrayList<>();

    public TxtParser(String path, String outPath) {
        this.path = path;
        this.outPath = outPath;
    }

    public TxtParser(String path) {
        this.path = path;
    }

    public void ReadFile() {
        try(BufferedReader buffer = new BufferedReader(new FileReader(path))){

            while(buffer.ready()) {
                String temp = buffer.readLine().toString();
                AriphmeticParser parser = new AriphmeticParser(temp);
                rezuList.add(parser.getResult());
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }

    public void WriteFile() throws IOException {
        try(BufferedWriter buffer = new BufferedWriter(new FileWriter(outPath));) {

            for(var id : rezuList) {
                buffer.write(id.toString() + "\n");
            }

        } catch(FilerException e){
            System.out.println("Error");
            e.getStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TxtParser Main = new TxtParser("src/res/arifmetics.PLAIN", "src/res/orderout.txt");
        Main.ReadFile();
        Main.WriteFile();
    }
}