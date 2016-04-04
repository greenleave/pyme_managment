package ar.com.greenleave.pymeManagment.model.service;

import ar.com.greenleave.pymeManagment.model.login.User;

public interface LoginClienteManager {
	public String login(String userName, String password);
	public String userRegistration(User persona);
}
