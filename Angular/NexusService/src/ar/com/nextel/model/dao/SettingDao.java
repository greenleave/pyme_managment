package ar.com.nextel.model.dao;

import java.util.List;
import java.util.Map;

import ar.com.nextel.model.Setting;

public interface SettingDao {
	
	public String createSetting(Setting setting);
	
	public void updateSetting(Setting setting);
	
	public void deleteSetting(Setting setting);
	
	public List<Map<String,Object>> getSettingsByUser(Long pUserId);

}
