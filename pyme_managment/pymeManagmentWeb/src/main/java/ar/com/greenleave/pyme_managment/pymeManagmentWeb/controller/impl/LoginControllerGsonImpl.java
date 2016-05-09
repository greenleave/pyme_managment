package ar.com.greenleave.pyme_managment.pymeManagmentWeb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.service.LoginClienteManager;
import ar.com.greenleave.pyme_managment.pymeManagmentWeb.controller.LoginController;

@Service("loginController")
@Controller
public class LoginControllerGsonImpl implements LoginController{

	private static Gson gson = new Gson();
	
	@Autowired
	LoginClienteManager loginClienteManager;
	
	@Override
	public String login(String json) {
		User user = gson.fromJson(json, User.class);
		return gson.toJson(loginClienteManager.login(user.getUserName(), user.getPassword()));
	}

	@Override
	public String createUser(String json) {
		System.out.println(User.class);
		User nuevoUsuario =gson.fromJson(json, User.class);
		return gson.toJson(loginClienteManager.userRegistration(nuevoUsuario));
	}

	@Override
	public String updateUser(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String json) {
		// TODO Auto-generated method stub
		return null;
	}

}
