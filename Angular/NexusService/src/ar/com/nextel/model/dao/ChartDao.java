package ar.com.nextel.model.dao;

import java.util.List;
import java.util.Map;

import ar.com.nextel.model.Chart;

public interface ChartDao {
	
	public String createChart(Chart chart);
	
	public void updateChart(Chart chart);
	
	public void deleteChart(Chart chart);
	
	public List<Map<String,Object>> getCharts();

}
