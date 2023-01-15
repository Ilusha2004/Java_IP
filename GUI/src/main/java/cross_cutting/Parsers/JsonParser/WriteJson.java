package cross_cutting.Parsers.JsonParser;

import cross_cutting.Parsers.SingletonResulList;
import cross_cutting.Parsers.Writer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteJson extends Writer {

    public WriteJson(String outPath) {
        super(outPath);
    }

    @Override
    public void write() throws IOException {

        JSONObject object_0 = new JSONObject();
        JSONObject object_1;

        JSONArray array = new JSONArray();

        for (var id : SingletonResulList.Data) {
            object_1 = new JSONObject();
            object_1.put("Result ", id);
            array.add(object_1);
        }

        object_0.put("Results", array);
        Files.write(Paths.get(getOutPath()), object_0.toJSONString().getBytes());

    }
}
