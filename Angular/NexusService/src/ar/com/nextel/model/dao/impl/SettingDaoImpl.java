package ar.com.nextel.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ar.com.nextel.model.Setting;
import ar.com.nextel.model.dao.SettingDao;

@Repository("settingDao")
public class SettingDaoImpl extends JdbcDaoSupport implements SettingDao{

	@SuppressWarnings("finally")
	@Override
	public String createSetting(Setting setting) {
		
		String response = null;
		
		try{
			getJdbcTemplate().
			update("insert into Z_User_Settings (setting_id,setting_description,user_id) values (?,?,?)", 
			setting.getSettingId(),
			setting.getDescription(),
			setting.getUserId());
			response = "Creado";
		}catch(Exception e){
			e.printStackTrace();
			response = "Error";
		}finally{
			return response;
		}
		
	}

	@Override
	public void updateSetting(Setting setting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSetting(Setting setting) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Map<String,Object>> getSettingsByUser(Long pUserId){
		List<Map<String,Object>> respuesta = null;
		String sql = "SELECT setting_id id, setting_description description FROM Z_User_Settings WHERE user_id = ?";
		
		try{								
			respuesta = getJdbcTemplate().queryForList(sql,pUserId);
		}catch(Exception e){			
			e.printStackTrace();
		}
		
		return respuesta;
	}

}
