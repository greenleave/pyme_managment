package ar.com.greenleave.pymeManagment.model.service;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionCliente.Phone;
import ar.com.greenleave.pymeManagment.model.gestionCliente.TypeOfAdress;
import ar.com.greenleave.pymeManagment.model.gestionCliente.TypeOfDocument;
import ar.com.greenleave.pymeManagment.model.gestionCliente.TypeOfPhone;

public interface GestionClienteManager {

	

	void deleteTypeDocumentById(Long l);
	
	List<Country> getAllCountries();
	Country getCountryById(Long id);
	TypeOfDocument getTypeDocumentById(Long id);
	
	void updateCountry(Country country);
	void updateTypeOfDocument(TypeOfDocument typeDocument);
	
	void saveCountry(Country country);
	void savePerson(Person person);
	void savePhone(Phone phone);
	void saveTypeAdress(TypeOfAdress adress);
	void saveTypeDocument(TypeOfDocument document);
	void saveTypePhone(TypeOfPhone typePhone);
	
	

	

}
