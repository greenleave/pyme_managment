package ar.com.nextel.rest;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import ar.com.nextel.controller.GenericReportManager;
import ar.com.nextel.model.Chart;
import ar.com.nextel.model.Setting;

@Path("/")
@Component
public class Service {
	
	public static final String CHARSET_UTF8 = "; charset=utf-8";

	@Autowired
	private GenericReportManager reportManager;
	
	/**
	 * Se crea un nuevo setting para un usuario determinado
	 * @input {"settingId":"id de setting",<br>
	 * 		   "description":"descripcion del setting",<br>
	 * 		   "userId":"id de user"}
	 * @return mensaje de respuesta
	 */
	@POST
	@Path("/user/newSetting")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response createNewSetting(final Setting setting){
		
		String resultado = reportManager.createSetting(setting);		
		return Response.status(200).entity(resultado).build();
	}
	
	/**
	 * Se crea un nuevo reporte para un setting determinado
	 * @input Ejemplo:<br>
	 * 		  {
	 *			"settingId":"1",<br>
	 *			"reportDesc":"Prueba de insert",<br>
	 *			"stmt":"select sysdate Fecha from dual",<br>
	 *			"chartId":"1",<br>
	 *			"reportConfig":[{"rows":[{"name":"Fecha"}]}],<br>
	 *			"refreshTime":"15"
	 *		  }
	 * @return mensaje de respuesta
	 */
	@POST
	@Path("/user/setting/newReport")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response createNewReport(final String json){
		
		String resultado = reportManager.createReport(json);		
		return Response.status(201).entity(resultado).build();
	}
	
	@POST
	@Path("/user/setting/executeQuery")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response executeQuery(final String json){
		
		String resultado = reportManager.executeQuery(json);		
		return Response.status(201).entity(resultado).build();
	}	
	
	//Agregar nuevo grafico
	@POST
	@Path("/newChart")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response createChart(final Chart chart){
		String resultado = reportManager.createChart(chart);		
		return Response.status(200).entity(resultado).build();
	}
	
	/**
	 * Obtener todos los usuarios disponibles
	 * @return devuelve un json con usuarios para testing
	 */
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response getAllUsers(){
		String json = reportManager.getAllUsers();
		return Response.status(200).entity(json).build();
	}

	/**
	 * Obtener todos los settings (pantallas) disponibles del usuario
	 * @return devuelve un json con los settings
	 */
	@GET
	@Path("/user={userId}/settings")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response getAllSettings(@PathParam("userId") Long pUserId){
		String json = reportManager.getSettingByUser(pUserId);
		return Response.status(200).entity(json).build();
	}
	
	/**
	 * Obtener todos los reportes configurados para los distintos settings del usuario
	 * @return devuelve un json con los reportes configurados
	 */
	@GET
	@Path("/reports")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public String getAllReports(){
		return null;
	}
	
	/**
	 * Obtener todos los graficos configurados para asociar a un reporte
	 * @return devuelve un json con los graficos
	 */
	@GET
	@Path("/charts")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response getAllCharts(){
		String json = reportManager.getAllCharts();
		return Response.status(200).entity(json).build();
	}

	/**
	 * Obtener un reporte especifico para un usuario y setting determinado
	 * @return devuelve el Json utilizado en Google Charts que sera graficado
	 */
	@GET
	@Path("/user={userId}&setting={settingId}&report={reportId}&chart={chartId}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response getGenericReport(@PathParam("userId") Long pUserId,
								   @PathParam("settingId") Long pSettingId,
								   @PathParam("reportId") Long pReportId,
								   @PathParam("chartId") Long pChartId){
		String json = reportManager.getGenericReport(pUserId, pSettingId, pReportId, pChartId);
		return Response.status(200).entity(json).build();
	}

}
