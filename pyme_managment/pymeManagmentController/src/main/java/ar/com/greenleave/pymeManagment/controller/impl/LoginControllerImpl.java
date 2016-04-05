package ar.com.greenleave.pymeManagment.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import ar.com.greenleave.pymeManagment.controller.LoginController;
import ar.com.greenleave.pymeManagment.model.Permiso;
import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.service.LoginClienteManager;

public class LoginControllerImpl implements LoginController {

	@Autowired
	LoginClienteManager loginManager;
	
	private Gson gson = new Gson();
	
	@Override
	public String login(String json) {
		User user=gson.fromJson(json, User.class);
		return gson.toJson(loginManager.login(user.getUserName(), user.getPassword())); 
	}

	@Override
	public List<Permiso> getPermisos() {
		return null;
	}

}
