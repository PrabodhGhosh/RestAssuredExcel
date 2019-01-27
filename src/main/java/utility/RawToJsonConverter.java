package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RawToJsonConverter {
	
	public static JsonPath convertRawToJson(Response res)
	
	{
		String StringResponse = res.asString();
		JsonPath json = new JsonPath(StringResponse);
		return json;
	}

}
