package ar.com.greenleave.pymeManagment.model.gestionCliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.greenleave.pymeManagment.model.gestionCliente.dao.GestionClienteGenericDao;

@Service("gestionClienteManager")
public class GestionClienteManager {
	@Autowired
	GestionClienteGenericDao gestionClienteGenericDao;
	
	public String getAllCoutries(){
		return null;
	}
	
	
}
