package ar.com.nextel.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ar.com.nextel.model.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{

	@Override
	public List<Map<String,Object>> getUsers() {
		List<Map<String,Object>> respuesta = null;
		String sql = "SELECT user_id id, user_name name FROM Z_Users";
		
		try{								
			respuesta = getJdbcTemplate().queryForList(sql);		
		}catch(Exception e){			
			e.printStackTrace();
		}
		
		return respuesta;	
	}

}
