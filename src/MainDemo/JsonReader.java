package MainDemo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JsonReader {
	public void readJsonFromFile(String fileName) throws Exception {
        Object obj = new JSONParser().parse(new FileReader(fileName));
        JSONObject jo = (JSONObject) obj;
        String timestamp = (String) jo.get("timestamp");
        System.out.println(timestamp);
	}
}
