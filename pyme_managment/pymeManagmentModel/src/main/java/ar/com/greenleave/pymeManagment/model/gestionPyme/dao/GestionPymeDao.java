package ar.com.greenleave.pymeManagment.model.gestionPyme.dao;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;

public interface GestionPymeDao {
	
	List<Country> getCountries(Country country);

	List<Person> getPersons(Person person);
}
