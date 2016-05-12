package ar.com.nextel.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import ar.com.nextel.model.Chart;
import ar.com.nextel.model.dao.ChartDao;

public class ChartDaoImpl extends JdbcDaoSupport implements ChartDao{

	@Override
	public List<Map<String, Object>> getCharts() {
		List<Map<String,Object>> respuesta = null;
		String sql = "SELECT chart_id id, chart_description description FROM Z_charts";
		
		try{								
			respuesta = getJdbcTemplate().queryForList(sql);		
		}catch(Exception e){			
			e.printStackTrace();
		}
		
		return respuesta;
	}

	@SuppressWarnings("finally")
	@Override
	public String createChart(Chart chart) {
		String response = null;
		
		try{
			getJdbcTemplate().
			update("INSERT INTO Z_charts (chart_id,chart_description) VALUES (?,?)", 
					chart.getId(),
					chart.getDescription());
			response = "Creado";
		}catch(Exception e){
			e.printStackTrace();
			response = "Error";
		}finally{
			return response;
		}
	}

	@Override
	public void updateChart(Chart chart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteChart(Chart chart) {
		// TODO Auto-generated method stub
		
	}

}
