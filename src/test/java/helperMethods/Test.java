package helperMethods;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {
	static String json = "C:\\Users\\Admin\\workspace\\Plumb5\\Test_Data\\Mail\\TC_10_Duplicate_Scheduled_Campaign.json";

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		Object obj = new JSONParser().parse(new FileReader(json));

		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;

		JSONArray ja = (JSONArray) jo.get("Send To");

		System.out.println("value "+ja);
		
		
//		Iterator<String> itr2 = ja.iterator();
//
//		while (itr2.hasNext())
//			System.out.println("values are : ");
//		System.out.println(itr2.next());
	}
}
