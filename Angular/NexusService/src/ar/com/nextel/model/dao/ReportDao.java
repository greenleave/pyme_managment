package ar.com.nextel.model.dao;

import java.util.List;
import java.util.Map;

import ar.com.nextel.model.Chart;
import ar.com.nextel.model.Report;
import ar.com.nextel.model.Setting;

public interface ReportDao {
	
	public Report getQueryAndConfiguration(Long pUserId, Long pSettingId, Long pReportId);
	
	public List<Map<String,Object>> getDataFromQuery(String queryStmt);
	
	public void updateJsonDataInDB (String jsonData, Long pReportId, Long pChartId);
	
	public String createReport(Report reporte, Setting setting, Chart chart);
	
	public void updateReport(String json);
	
	public void deleteReport(String json);
	
	public List<Map<String,Object>> executeQuery (String query);

}
