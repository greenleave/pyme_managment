package ar.com.greenleave.pymeManagment.controller;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.Permiso;

public interface LoginController {
	public void Login();
	public List<Permiso> getPermisos();
}