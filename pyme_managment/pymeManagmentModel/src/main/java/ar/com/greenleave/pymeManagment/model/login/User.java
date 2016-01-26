package ar.com.greenleave.pymeManagment.model.login;

import java.util.HashMap;

import ar.com.greenleave.pymeManagment.model.Permiso;

public class User {

	private String userName;
	private HashMap<Permiso, Boolean> permisos;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public HashMap<Permiso, Boolean> getPermisos() {
		return permisos;
	}
	public void setPermisos(HashMap<Permiso, Boolean> permisos) {
		this.permisos = permisos;
	}
	
}
