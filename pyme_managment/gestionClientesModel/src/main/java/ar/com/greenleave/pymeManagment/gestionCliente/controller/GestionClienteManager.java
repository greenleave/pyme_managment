package ar.com.greenleave.pymeManagment.gestionCliente.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.greenleave.pymeManagment.gestionCliente.model.Country;
import ar.com.greenleave.pymeManagment.gestionCliente.model.dao.GestionClienteGenericDao;

@Service("gestionClienteManager")
public class GestionClienteManager {
	@Autowired
	GestionClienteGenericDao gestionClienteGenericDao;
	
	public String getAllCoutries(){
		List<Map<String,Object>> daoResponses = this.gestionClienteGenericDao.findAll(Country.class);
		
	}
	
	
}
