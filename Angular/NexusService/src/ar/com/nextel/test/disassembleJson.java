package ar.com.nextel.test;

import java.math.BigDecimal;

import javax.json.*;

import ar.com.nextel.model.Chart;
import ar.com.nextel.model.Report;
import ar.com.nextel.model.Setting;
import ar.com.nextel.utils.JsonHelper;

public class disassembleJson {
	
	/**
	 * @param args
	 */
	public static void main(String [] args){
		
		String json = "{"+
				"\"settingId\":\"1\","+
				"\"reportDesc\":\"Cantidad de transacciones mensuales\","+
				"\"stmt\":\"select status_tx Status, count(1) Cantidad from vw_soporte_transacciones where fecha > sysdate  -365 group by status_tx\","+
				"\"chartId\":\"1\","+
				"\"reportConfig\":[{"+
									"\"rows\":[{\"name\":\"Status\"},{\"name\":\"Cantidad\"}]"+
									"}],"+
					"\"refreshTime\":\"10\""+
				"}";
		
		JsonObject jsonCompleto = JsonHelper.buildJsonFromString(json);
		Report reporte = new Report();
		Setting setting = new Setting();
		Chart chart = new Chart();
		
		// CARGA DE DATOS
		setting.setSettingId(new BigDecimal(jsonCompleto.getString("settingId")));
		reporte.setDescription(jsonCompleto.getString("reportDesc"));
		reporte.setQueryStmt(jsonCompleto.getString("stmt"));		
		reporte.setJsonConfiguration(jsonCompleto.getJsonArray("reportConfig").getJsonObject(0));
		reporte.setRefreshTime(new BigDecimal(jsonCompleto.getString("refreshTime")));
		chart.setId(new BigDecimal(jsonCompleto.getString("chartId")));
		
		//OBTENER LOS DATOS CARGADOS Y VALIDAR POR PANTALLA QUE SE CARGARON BIEN
		String datos = null;

		datos = "setting id > "+ setting.getSettingId().toString()+" | ";
		datos = datos + "query > "+ reporte.getQueryStmt()+" | ";
		datos = datos +"Json Config > "+ reporte.getJsonConfiguration().toString()+" | ";
		datos = datos +"chart id > "+ chart.getId().toString();
		
		System.out.println(datos);
		
	}
	
	
}
