package cross_cutting.Parsers.JsonParser;

import cross_cutting.Arifmetic.AriphmeticParser;
import cross_cutting.BuilderAriphmeticParser.Parser;
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

public class ParserJson extends Parser {

    private static ArrayList<String> rawAriphStrings = new ArrayList<String>();
    private static ArrayList<Double> rezuList = new ArrayList<>();

    public ParserJson(String inPath, String outPath) {
        super(inPath, outPath);
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

        } catch (FileNotFoundException exp) {
            System.out.println(exp.getMessage());
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        } catch (NullPointerException exp) {
            System.out.println(exp.getMessage());
        }

    }

    @Override
    public void write() throws IOException {

        JSONObject object_0 = new JSONObject();
        JSONObject object_1;

        JSONArray array = new JSONArray();

        for (var id : rezuList) {
            object_1 = new JSONObject();
            object_1.put("Result ", id);
            array.add(object_1);
        }

        object_0.put("Results", array);
        Files.write(Paths.get(getOutPath()), object_0.toJSONString().getBytes());

    }

}