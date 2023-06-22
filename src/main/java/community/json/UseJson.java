package community.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UseJson {
	public JsonNode getJson(String urlString) {
		String result = "";
		JsonNode root = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.connect(); // URL接続
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
			String tmp = "";
			
			//in.readLine()がnullになるまで繰り返す。
			while ((tmp = in.readLine()) != null) {
				result += tmp;
			}
			
			//StringからJsonNodeに変換してる??
			ObjectMapper mapper = new ObjectMapper();
			root = mapper.readTree(result);
			in.close();
			con.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return root;
	}
}
