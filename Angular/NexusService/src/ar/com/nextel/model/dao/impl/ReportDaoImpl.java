package ar.com.nextel.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ar.com.nextel.model.Chart;
import ar.com.nextel.model.Report;
import ar.com.nextel.model.Setting;
import ar.com.nextel.model.dao.ReportDao;
import ar.com.nextel.utils.GenericStoredProcedure;
import ar.com.nextel.utils.JsonHelper;
import ar.com.nextel.utils.StoredProcedureParamsIn;
import ar.com.nextel.utils.StoredProcedureParamsOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * <p>
 * <b>Name:</b> ChartDaoImpl
 * </p>
 * <p>
 * <b>Description:</b> DAO generico para obtener datos 
 * y configuraciones.
 * </p>
 *
 * @since 08/2015
 * @author Fernando N. Tobares García
 * @version v1.0
 * 
 */
@Repository("reportDao")
public class ReportDaoImpl extends JdbcDaoSupport implements ReportDao{

	/**
	 * Obtiene la configuración y datos guardados del reporte // Guardo query en BD?
	 * @return devuelve el chart con los datos
	 */
	public Report getQueryAndConfiguration(Long pUserId, Long pSettingId, Long pReportId){

		List<Report> reports = null;
		
		try{			
		
			String sql = "select r.statement, rrc.report_configuration, rrc.report_data, rrc.last_time_executed, rrc.refresh_time "+
						  "from Z_User_Settings s, Z_Reference_Setting_Report rsr, Z_reports r, Z_Reference_Report_Chart rrc "+
						  "where s.setting_id = ? "+
						  "and s.user_id = ? "+
						  "and r.report_id = ? "+
						  "and s.ref_report_id = rsr.setting_id "+
						  "and rsr.report_id = r.report_id "+
						  "and r.report_id = rrc.report_id";
			
			reports = getJdbcTemplate().query(sql, new RowMapper<Report>(){
					public Report mapRow(ResultSet rs, int rowNum) throws SQLException{
						Report report = new Report();
						report.setQueryStmt(rs.getString("statement"));
						report.setJsonConfiguration(JsonHelper.buildJsonFromString(rs.getString("report_configuration")));
						report.setJsonData(JsonHelper.buildJsonFromString(rs.getString("report_data")));
						report.setLastTimeExecuted(rs.getTimestamp("last_time_executed"));
						report.setRefreshTime(rs.getBigDecimal("refresh_time"));
						return report;
					}
			},pSettingId,pUserId,pReportId);
		
		}catch(Exception e){			
			e.printStackTrace();
		}
		
		return reports.get(0);
	}

	/**
	 * Obtiene los datos tras ejecutar el query guardado en la configuración.
	 * Es decir el query del reporte concretamente.
	 * @return Lista de datos del tipo Map<String, Object>
	 */
	@Override
	public List<Map<String,Object>> getDataFromQuery(String queryStmt) {
		
		List<Map<String,Object>> respuesta = null;
		
		try{
			respuesta = getJdbcTemplate().queryForList(queryStmt);
		}catch(Exception e){
			e.printStackTrace();
		}
		return respuesta;
	}
	
	/**
	 * Actualiza el Json Data en la base de datos, de modo de poder contar con el mismo
	 * en caso de una nueva request.	 
	 */
	public void updateJsonDataInDB (String jsonData, Long pReportId, Long pChartId){
		try{
			getJdbcTemplate().
			update("update Z_Reference_Report_Chart set report_data = ?, last_time_executed = sysdate where report_id = ? and chart_id = ?", 
					jsonData,
					pReportId,
					pChartId);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Map<String,Object>> executeQuery (String query){
		
		List<Map<String,Object>> respuesta = null;
		
		try{		
			String sql = "SELECT * FROM ("+query+") WHERE ROWNUM = 1";			
			respuesta = getJdbcTemplate().queryForList(sql);		
		}catch(Exception e){			
			e.printStackTrace();
		}
		
		return respuesta;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public String createReport(Report reporte, Setting setting, Chart chart) {
		
		String procedureName = "NXS_DASHBOARD_PKG.create_report_sp";
		List procedureParams = new ArrayList();
		
		procedureParams.add(new StoredProcedureParamsIn(setting.getSettingId(),Types.NUMERIC, "settingId"));
		procedureParams.add(new StoredProcedureParamsIn(reporte.getDescription(),Types.VARCHAR, "description"));
		procedureParams.add(new StoredProcedureParamsIn(reporte.getQueryStmt(),Types.VARCHAR, "queryStmt"));
		procedureParams.add(new StoredProcedureParamsIn(chart.getId(),Types.NUMERIC, "chartId"));
		procedureParams.add(new StoredProcedureParamsIn(reporte.getJsonConfiguration().toString(),Types.VARCHAR, "jsonConfig"));
		procedureParams.add(new StoredProcedureParamsIn(reporte.getRefreshTime(),Types.NUMERIC, "refreshTime"));
		
		procedureParams.add(new StoredProcedureParamsOut(Types.VARCHAR,"mensaje"));
		
		GenericStoredProcedure procedure = new GenericStoredProcedure(procedureName,procedureParams,getJdbcTemplate());
		Map respuesta = null;
		String mensaje = null;
		
		try{
			respuesta = procedure.executeSp();
			mensaje = (String)respuesta.get("mensaje");			
		}catch(Exception e){
			e.printStackTrace();
			mensaje = "Error"+respuesta.get("mensaje").toString();
		}
		
		return mensaje;
	}

	@Override
	public void updateReport(String json) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReport(String json) {
		// TODO Auto-generated method stub
		
	};

}
