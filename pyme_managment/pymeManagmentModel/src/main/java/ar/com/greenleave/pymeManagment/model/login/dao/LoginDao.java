package ar.com.greenleave.pymeManagment.model.login.dao;

import ar.com.greenleave.pymeManagment.model.login.User;

public interface LoginDao {
	public User login(String userName, String password);
	
	public User getUserByUserName(String userName);
	public User getUserByEmail(String email);
	
	
	//Bloque de los exists user
	
	public Boolean existUserByUserName(String userName);
	public Boolean existUserByEmail(String email);
	public Boolean existUserByName(String name);
}
