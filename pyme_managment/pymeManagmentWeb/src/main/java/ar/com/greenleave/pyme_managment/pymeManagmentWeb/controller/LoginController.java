package ar.com.greenleave.pyme_managment.pymeManagmentWeb.controller;

public interface LoginController {
	String login(String json);
	String createUser(String json);
	String updateUser(String json);
	String deleteUser(String json);
}
