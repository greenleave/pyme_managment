package ar.com.greenleave.pymeManagment.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.greenleave.pymeManagment.model.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionCliente.dao.GestionClienteDao;
import ar.com.greenleave.pymeManagment.model.gestionCliente.dao.GestionClienteGenericDao;

@Service("gestionClienteManager")
public class GestionClienteManager {
	@Autowired
	private GestionClienteGenericDao gestionClienteGenericDao;
	@Autowired 
	private GestionClienteDao gestionCliente;
	
	public void saveCountry(Country country){
		gestionClienteGenericDao.save(country);
	}

	public void updateCountry(Country country) {
		gestionClienteGenericDao.update(country);
	}
	
	public Country getCountryById(Long id){
		return gestionClienteGenericDao.get(Country.class, id);
	}
	
	
}
