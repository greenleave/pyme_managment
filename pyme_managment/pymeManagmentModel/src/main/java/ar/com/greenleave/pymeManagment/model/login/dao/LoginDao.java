package ar.com.greenleave.pymeManagment.model.login.dao;

import ar.com.greenleave.pymeManagment.model.login.User;

public interface LoginDao {
	public User login(String userName, String password);
}
