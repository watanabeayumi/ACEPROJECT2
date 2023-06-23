package community.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * URLを開いてAPIからテキストを読み込み、それをJsonNode型に変換するためのクラス
 * @author 渡辺友里
 * @version 1.0
 */
public class UseJson {
	public JsonNode getJson(String urlString) {
		String result = "";
		JsonNode root = null;
		try {
			//1.urlを接続する
			URL url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.connect();
			
			//2.APIからレスポンスをもらう
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
			String tmp = "";
			
			//3.in.readLine()がnullになるまで繰り返す
			while ((tmp = in.readLine()) != null) {
				result += tmp;
			}
			
			//4.JavaオブジェクトとJSON文字列の相互変換ができる
			ObjectMapper mapper = new ObjectMapper();
			
			//5.JsonNode 型のオブジェクトとして読み込む
			root = mapper.readTree(result);
			
			in.close();
			con.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return root;
	}
}
