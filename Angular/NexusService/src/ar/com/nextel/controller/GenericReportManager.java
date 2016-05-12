package ar.com.nextel.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.nextel.model.Chart;
import ar.com.nextel.model.Report;
import ar.com.nextel.model.Setting;
import ar.com.nextel.model.dao.ChartDao;
import ar.com.nextel.model.dao.ReportDao;
import ar.com.nextel.model.dao.SettingDao;
import ar.com.nextel.model.dao.UserDao;
import ar.com.nextel.utils.JsonHelper;

/**
 * <p>
 * <b>Name:</b> GenericReportManager
 * </p>
 * <p>
 * <b>Description:</b> Clase encargada de solicitar datos, configuración
 * y armar el reporte que sera envíado al Servicio
 * </p>
 *
 * @since 08/2015
 * @author Fernando N. Tobares García
 * @version v1.0
 * 
 */
@Service("reportManager")
public class GenericReportManager {
	
	/* A mejorar:
	 * en los Dao Impl podría simplemente definir el query y llamar una clase que invoque los queries
	 */
	
	@Autowired
	ReportDao reportDao;	
	@Autowired
	SettingDao settingDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ChartDao chartDao;
	
	/**
	 * Obtener todos los usuarios
	 * @return Json del tipo Ej: [{"id":"1","name":"nombre1"}, {"id":"2","name":"nombre2"}] 
	 */
	public String getAllUsers(){
		List<Map<String,Object>> daoResponses = userDao.getUsers();
		return JsonHelper.getGenericJsonAsJsonString(daoResponses);
	}
	
	/**
	 * Obtener todos los settings para un usuario en especial
	 * @return Json del tipo Ej: [{"id":"1","description":"description1"}, {"id":"2","description":"description2"}] 
	 */
	public String getSettingByUser(Long pUserId){
		List<Map<String,Object>> daoResponses = settingDao.getSettingsByUser(pUserId);
		return JsonHelper.getGenericJsonAsJsonString(daoResponses);
	}
	
	/**
	 * Obtener todos los graficos
	 * @return Json del tipo Ej: [{"id":"1","description":"description1"}, {"id":"2","description":"description2"}]  
	 */
	public String getAllCharts(){
		List<Map<String,Object>> daoResponses = chartDao.getCharts();
		return JsonHelper.getGenericJsonAsJsonString(daoResponses);
	}	

	/**
	 * Se crea un nuevo setting para un usuario determinado
	 * @return Estado de la creación. "Creado" / "Error"
	 */
	public String createSetting(Setting setting){
		return settingDao.createSetting(setting);
	}
	
	/**
	 * Se crea un nuevo setting para un usuario determinado
	 * @return Estado de la creación. "Creado" / "Error"
	 */
	public String createChart(Chart chart){
		return chartDao.createChart(chart);
	}	
	
	/**
	 * Se crea un nuevo reporte para un setting determinado
	 * @return Estado de la creación. "Reporte creado Ok" / "Error"
	 */
	public String createReport(String json){
		
		Report reporte = new Report();
		Setting setting = new Setting();
		Chart chart = new Chart();
		JsonObject jsonCompleto = JsonHelper.buildJsonFromString(json);
		JsonHelper.disassembleJson(jsonCompleto,reporte,setting,chart);
		
		return reportDao.createReport(reporte,setting,chart);
	}
	
	public String executeQuery(String json){
		
		JsonObject jsonQuery = JsonHelper.buildJsonFromString(json);
		String query  = jsonQuery.getJsonString("stmt").toString().replace("\"","");
		
		List<Map<String,Object>> respuesta = reportDao.executeQuery(query);		
		return JsonHelper.getQueryColumnsAsJsonString(respuesta);
	}	

	/**
	 * Obtengo la configuración, query del reporte y datos guardados
	 * @return Obtengo un chart con los datos
	 */
	public Report getQueryAndConfiguration(Long pUserId, Long pSettingId, Long pReportId){
		return reportDao.getQueryAndConfiguration(pUserId, pSettingId, pReportId);
	}	
	
	/**
	 * Obtengo un reporte solicitado por el servicio. 
	 * @return Si el tiempo de actualización de los datos esta dentro del rango permitido, 
	 * se devuelve el json con los datos precargados. En caso contrario vuelve a generar el json
	 * con datos actualizados.
	 */
	public String getGenericReport(Long pUserId, Long pSettingId, Long pReportId, Long pChartId){
		
		String response;
		Report report = this.getQueryAndConfiguration(pUserId, pSettingId, pReportId);
		Boolean isJsonUsable = this.checkJsonDate(report.getLastTimeExecuted(), report.getRefreshTime());
		
		if(isJsonUsable){
			response = report.getJsonData().toString();
		}else{
			List<Map<String,Object>> daoResponse = reportDao.getDataFromQuery(report.getQueryStmt());			
			response = JsonHelper.buildGoogleChartJson(daoResponse, report);
			reportDao.updateJsonDataInDB(response, pReportId, pChartId);
		}
		
		return response;
	}
	
	/**
	 * Valida que la fecha actual sea menor a la ultima fecha de ejecución mas el tiempo
	 * de actualización configurado (en minutos)
	 * @return true: usar json guardado, false: recargar json nuevamente
	 */
	public Boolean checkJsonDate (Timestamp lastTimeExecuted, BigDecimal refreshTime){
		
		Boolean resp;
		BigDecimal fechaProceso = new BigDecimal(lastTimeExecuted.getTime());
		BigDecimal fechaActual = new BigDecimal(new java.util.Date().getTime());		
		
		if( (fechaProceso.add(refreshTime)).compareTo(fechaActual) > 0){
			resp = true;
		}else{
			resp = false;
		}
		
		return resp;
	}

}
