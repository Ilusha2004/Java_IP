package cross_cutting.Parsers.JsonParser;

import cross_cutting.Arifmetic.AriphmeticParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ParserJson {

    private static ArrayList<String> rawAriphStrings = new ArrayList<String>();
    private static ArrayList<Integer> rezuList = new ArrayList<>();

    public void Parse(String reader) throws RuntimeException {

        try {
            FileReader read = new FileReader(reader);
            JSONParser Parser = new JSONParser();
            JSONObject object = null;

            try {
                object = (JSONObject) Parser.parse(read);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            JSONArray array = (JSONArray) object.get("arifmetic");

            var iterator = array.iterator();

            while (iterator.hasNext()) {
                JSONObject temp = (JSONObject) iterator.next();
                String result = temp.get("RawString").toString();
                AriphmeticParser tAriphmeticParser = new AriphmeticParser(result);
                rezuList.add(tAriphmeticParser.getResult());
            }

        } catch (FileNotFoundException exp) {
            exp.printStackTrace();
        } catch (IOException exp) {
            exp.printStackTrace();
        } catch (NullPointerException exp) {
            exp.printStackTrace();
        }

    }

    public void WriteJsonFile(String reader) throws IOException {

        JSONObject object_0 = new JSONObject();
        JSONObject object_1;

        JSONArray array = new JSONArray();

        for (var id : rezuList) {
            object_1 = new JSONObject();
            object_1.put("Result ", id);
            array.add(object_1);
        }

        object_0.put("Results", array);
        Files.write(Paths.get(reader), object_0.toJSONString().getBytes());

    }

    public static ArrayList<String> getRawAriphStrings() {
        return rawAriphStrings;
    }

    public static ArrayList<Integer> getRezuList() {
        return rezuList;
    }

}