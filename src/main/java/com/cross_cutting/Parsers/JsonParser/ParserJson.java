package com.laba_6a.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.laba_6a.car.Car;

public class ParserJson {

    private static ArrayList<Car> cars_0 = new ArrayList<>();
    private static Hashtable<Car, String> Cars = new Hashtable<Car, String>();

    public void Parse(String reader) {

        try {
            FileReader read = new FileReader(reader);
            JSONParser Parser = new JSONParser();
            JSONObject object = null;

            try {
                object = (JSONObject) Parser.parse(read);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            JSONArray array = (JSONArray) object.get("cars");
    
            var iterator = array.iterator();

            while(iterator.hasNext()){
                JSONObject temp = (JSONObject) iterator.next();
                Car car = new Car(Double.valueOf(temp.get("Position").toString()),
                                  Double.valueOf(temp.get("Velocity").toString()),
                                  temp.get("Brand").toString(),
                                  0.0d
                );
                
                cars_0.add(car);
            }
            
        } catch (FileNotFoundException exp) {
            exp.printStackTrace();
        } catch (IOException exp) { 
            exp.printStackTrace();
        } catch (NullPointerException exp){
            exp.printStackTrace();
        }

    }

    public void WriteJsonFile(String reader) throws IOException {
        
        JSONObject object_0 = new JSONObject();
        JSONObject object_1;
      
        JSONArray array = new JSONArray();

        for(var id : cars_0) {
            object_1 = new JSONObject();
            object_1.put("Brand ", id.getBrand());
            object_1.put("Time Pass", id.getRaInteger());
            object_1.put("Passing Car", Cars.get(id));
            array.add(object_1);
        }

        object_0.put("time rapid", array);
        Files.write(Paths.get(reader), object_0.toJSONString().getBytes());
        
    }

    public static void setCars(ArrayList<Car> cars) {
        ParserJson.cars_0 = cars;
    }

    public static void setCars(Hashtable<Car, String> cars) {
        ParserJson.Cars = cars;
    }

    public static ArrayList<Car> getCars() {
        return cars_0;
    }
    
}