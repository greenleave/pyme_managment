package ar.com.greenleave.pymeManagment.pymeManagmentWeb.controller;

public interface UserCenterController {

	public String login(String json);
	public void createUser(String json);
	public void updatePassword(String json);	
	
}
