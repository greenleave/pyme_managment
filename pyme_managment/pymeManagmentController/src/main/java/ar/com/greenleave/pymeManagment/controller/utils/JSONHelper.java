package ar.com.greenleave.pymeManagment.controller.utils;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JSONHelper {

	
	/**
	 * Transforma un json en formato String a un json en formato JsonObject
	 * @return JsonObject
	 */
	public static JsonObject buildJsonFromString (String json){
		json = json.replaceAll("'", "\"");
		JsonReader jsonReader = Json.createReader(new StringReader(json));
		JsonObject jsonObj = jsonReader.readObject();
		jsonReader.close();
		return jsonObj;
	}
	
}
