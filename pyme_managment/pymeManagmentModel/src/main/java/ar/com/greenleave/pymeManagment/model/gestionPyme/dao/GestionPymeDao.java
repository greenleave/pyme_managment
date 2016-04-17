package ar.com.greenleave.pymeManagment.model.gestionPyme.dao;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;

public interface GestionPymeDao {
	
	List<Country> getCountries(Country country);
}
