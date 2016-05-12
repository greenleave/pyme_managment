package ar.com.nextel.utils;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import ar.com.nextel.model.Chart;
import ar.com.nextel.model.Report;
import ar.com.nextel.model.Setting;

public class JsonHelper {
	
	/**
	 * Transforma una List<Map<>> en un Json String
	 * @return Json String Ej: [{"id":"1","name":"nombre1"}, {"id":"2","name":"nombre2"}] 
	 */
	public static String getGenericJsonAsJsonString(List<Map<String,Object>> data){		
		JsonArrayBuilder builderArrayJsonCompleto = Json.createArrayBuilder();
		
		for(Map row : data){
			JsonObjectBuilder builderObject = Json.createObjectBuilder();
			
			List keys = new ArrayList(row.keySet());
			for(int i=0; i<keys.size(); i++){
				String columnName = keys.get(i).toString().toLowerCase();
				builderObject.add(columnName, row.get(columnName).toString());
			}
			 
			builderArrayJsonCompleto.add(builderObject);
		}
		
		return builderArrayJsonCompleto.build().toString();
	}
	
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

	/**
	 * A partir de un JsonObject, mappear con las clases de reporte, setting y chart
	 * @return void
	 */
	public static void disassembleJson(JsonObject json, Report reporte, Setting setting, Chart chart){
		setting.setSettingId(new BigDecimal(json.getString("settingId")));
		reporte.setDescription(json.getString("reportDesc"));
		reporte.setQueryStmt(json.getString("stmt"));		
		reporte.setJsonConfiguration(json.getJsonArray("reportConfig").getJsonObject(0));
		reporte.setRefreshTime(new BigDecimal(json.getString("refreshTime")));
		chart.setId(new BigDecimal(json.getString("chartId")));
	}
	
	public static String getQueryColumnsAsJsonString(List<Map<String,Object>> columnsData){
		
		JsonObjectBuilder builderJsonCompleto = Json.createObjectBuilder();		
		JsonArrayBuilder builderColumns = Json.createArrayBuilder();
		
		List keys = new ArrayList(columnsData.get(0).keySet());
		for (int i = 0; i < keys.size(); i++){			
			JsonObjectBuilder builderColumn = Json.createObjectBuilder();
			builderColumn.add("name", keys.get(i).toString().toLowerCase());
			builderColumns.add(builderColumn);			
		}
		
		builderJsonCompleto.add("rows",builderColumns);
		
		return builderJsonCompleto.build().toString();
	}
	
	/**
	 * A partir de la configuración del reporte, vuelvo a generar el json con los datos
	 * obtenidos al re-ejecutar el query.
	 * @return devuelve el json en el formato de Google Charts. Ejemplo:
	 * <p>{
	 *	  "cols": [
	 *	        {"id":"","label":"Sucursales","pattern":"","type":"string"},<br>
	 *	        {"id":"","label":"Cantidad de Boxes","pattern":"","type":"number"},<br>
	 *	        {"id":"","label":"Cantidad de Personas en Espera","pattern":"","type":"number"}
	 *	      ],<br>
	 *	  "rows": [
	 *	        {"c":[{"v":'9 de Julio'},{"v":"70"},{"v":"0"}]},<br>      
	 *	        {"c":[{"v":'Avellaneda'},{"v":"30"},{"v":"0"}]}, <br>     
	 *	        {"c":[{"v":'Palestina'},{"v":"25"},{"v":"0"}]}, <br>    
	 *	        {"c":[{"v":'Cordoba'},{"v":"20"},{"v":"0"}]},<br>
	 *	        {"c":[{"v":'Pilar'},{"v":"20"},{"v":"1"}]},<br>
	 *	        {"c":[{"v":'Rosario'},{"v":"20"},{"v":"0"}]},<br>
	 *	        {"c":[{"v":'Corrientes'},{"v":"20"},{"v":"0"}]},<br>
	 *	        {"c":[{"v":'Mar del Plata'},{"v":"20"},{"v":"0"}]},<br>
	 *	        {"c":[{"v":'Martinez'},{"v":"20"},{"v":"0"}]},<br>
	 *	        {"c":[{"v":'Mendoza'},{"v":"16"},{"v":"0"}]}
	 *	      ]
	 *	}</p>
	 */
	public static String buildGoogleChartJson(List<Map<String,Object>> responses, Report report){
		
		JsonObjectBuilder builderJsonCompleto = Json.createObjectBuilder();
		
		JsonArrayBuilder builderEncabezado = Json.createArrayBuilder();
		JsonArrayBuilder builderCuerpo = Json.createArrayBuilder();
		
		//Encabezado - No debería cambiar
		for(int i=0;i<report.getJsonData().getJsonArray("cols").size();i++){
			JsonObjectBuilder builderLabel = Json.createObjectBuilder();
			//se pueden agregar "id" y "pattern"
			//label lo puedo obtener del JsonConfig. ¿De donde saco el type?
			//la primera vez JsonData va a estar vacio...
			builderLabel.add("label", report.getJsonData().getJsonArray("cols").getJsonObject(i).getString("label")).add("type", report.getJsonData().getJsonArray("cols").getJsonObject(i).getString("type"));
			builderEncabezado.add(builderLabel);
		}

		//Cuerpo
		for(Map row : responses){
			JsonObjectBuilder builderColumn = Json.createObjectBuilder();
			JsonArrayBuilder builderArrayValues = Json.createArrayBuilder();
			JsonObjectBuilder builderValue = Json.createObjectBuilder();
			
			for(int j=0;j<report.getJsonConfiguration().getJsonArray("rows").size();j++){
				String columnName = report.getJsonConfiguration().getJsonArray("rows").getJsonObject(j).getString("name");
				builderValue.add("v", row.get(columnName).toString());
				builderArrayValues.add(builderValue);
			}
			
			builderColumn.add("c", builderArrayValues);				
			builderCuerpo.add(builderColumn);
		}
		
		builderJsonCompleto.add("cols",builderEncabezado).add("rows",builderCuerpo);				
		
		return builderJsonCompleto.build().toString();
	}

}
