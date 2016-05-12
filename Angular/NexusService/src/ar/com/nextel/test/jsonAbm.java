package ar.com.nextel.test;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import ar.com.nextel.model.Report;
import ar.com.nextel.utils.JsonHelper;

public class jsonAbm {
	
	 private JsonObject jsonConfiguration;
	 private JsonObject jsonData;
	
		public static void main(String [] args){
			Report testChart = new Report();
			String config = "{'rows':[{'name':'Status'},{'name':'Cantidad'}]}";			
			//config = config.replaceAll("'", "\"");			
			
			testChart.setJsonConfiguration(JsonHelper.buildJsonFromString(config));
			testChart.setJsonData(JsonHelper.buildJsonFromString("{'cols':[{'id':'','label':'Estados','pattern':'','type':'string'},{'id':'','label':'Cantidad de Transacciones','pattern':'','type':'number'}],'rows':[{'c':[{'v':'Pendiente'},{'v':'201'}]},{'c':[{'v':'Finalizada parcialmente'},{'v':'332'}]},{'c':[{'v':'Encolado'},{'v':'138'}]},{'c':[{'v':'Finalizada'},{'v':'444'}]}]}"));
		
/*			System.out.println("tamaño-encabezado: "+testChart.getJsonData().getJsonArray("cols").size());
			System.out.println("encabezado: "+testChart.getJsonData().getJsonArray("cols"));
			System.out.println("encabezado: "+testChart.getJsonData().getJsonArray("cols").getJsonObject(0).getString("label"));
			System.out.println("tamaño-cuerpo: "+testChart.getJsonData().getJsonArray("rows").size());
			System.out.println("cuerpo-datos: "+testChart.getJsonData().getJsonArray("rows"));
*/			
			// CREAR UN NUEVO JSON
						
			//JsonBuilderFactory factory = Json.createBuilderFactory(null);
			JsonObjectBuilder builderJsonCompleto = Json.createObjectBuilder();
			JsonObject value;
			
			JsonArrayBuilder builderEncabezado = Json.createArrayBuilder();
			JsonArrayBuilder builderCuerpo = Json.createArrayBuilder();
			//Encabezado
			for(int i=0;i<testChart.getJsonData().getJsonArray("cols").size();i++){
				JsonObjectBuilder builderLabel = Json.createObjectBuilder();
				//se pueden agregar "id" y "pattern" 
				builderLabel.add("label", testChart.getJsonData().getJsonArray("cols").getJsonObject(i).getString("label")).add("type", testChart.getJsonData().getJsonArray("cols").getJsonObject(i).getString("type"));
				builderEncabezado.add(builderLabel);
			}

			//Cuerpo
			for(int i=0;i<testChart.getJsonData().getJsonArray("rows").size();i++){
				JsonObjectBuilder builderColumn = Json.createObjectBuilder();
				JsonArrayBuilder builderArrayValues = Json.createArrayBuilder();
				JsonObjectBuilder builderValue = Json.createObjectBuilder();
				
				for(int j=0;j<testChart.getJsonData().getJsonArray("rows").getJsonObject(i).getJsonArray("c").size();j++){
					builderValue.add("v", testChart.getJsonData().getJsonArray("rows").getJsonObject(i).getJsonArray("c").getJsonObject(j).getString("v"));
					builderArrayValues.add(builderValue);
				}
				
				builderColumn.add("c", builderArrayValues);				
				builderCuerpo.add(builderColumn);
			}
			
			builderJsonCompleto.add("cols",builderEncabezado).add("rows",builderCuerpo);
			value = builderJsonCompleto.build();			
			
		}

}
