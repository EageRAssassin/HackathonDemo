package MainDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JsonReader {
	public void readJsonFromFile(String fileName) throws Exception {
		Object obj = new JSONParser().parse(new FileReader(fileName));
		JSONObject jo = (JSONObject) obj;
		String timestamp = (String) jo.get("timestamp");
		System.out.println(timestamp);
	}

//	  private static String readAll(Reader rd) throws IOException {
//		    StringBuilder sb = new StringBuilder();
//		    int cp;
//		    while ((cp = rd.read()) != -1) {
//		      sb.append((char) cp);
//		    }
//		    return sb.toString();
//		  }
//	  
//	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
//		InputStream is = new URL(url).openStream();
//		try {
//			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//			String jsonText = readAll(rd);
//			JSONObject json = new JSONObject(jsonText);
//			return json;
//		} finally {
//			is.close();
//		}
//	}

}
