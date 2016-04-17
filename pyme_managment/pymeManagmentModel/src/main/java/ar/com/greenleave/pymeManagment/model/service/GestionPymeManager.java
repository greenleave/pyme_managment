package ar.com.greenleave.pymeManagment.model.service;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestiomEmpleados.Employee;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Client;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfAdress;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfPhone;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Vendor;

public interface GestionPymeManager {
	void createPerson(Person person);
	void updatePerson(Person person);
	void deletePerson(Person person);
	List<Person> getPersons(Person person);
	
	
	void createCountry(Country country);
	void updateCountry(Country country);
	void deleteCountry(Country country);
	List<Country> getCountries(Country country);
	
	void createTypePhone(TypeOfPhone typePhone);
	void updateTypePhone(TypeOfPhone typePhone);
	void deleteTypePhone(TypeOfPhone typePhone);
	
	void createTypeAdress(TypeOfAdress typeAdress);
	void updateTypeAdress(TypeOfAdress typeAdress);
	void deleteTypeAdress(TypeOfAdress typeAdress);
	
	void createClient(Client client);
	void createVendor(Vendor vendor);
	void createEmployee(Employee employee);
	
	
	
	
	
	
	
//	void deleteTypeDocumentById(Long l);
//	List<Country> getAllCountries();
//	Country getCountryById(Long id);
//	TypeOfDocument getTypeDocumentById(Long id);
//	
//	
//	void createCountry(Country country);
//	void createPerson(Person person);
//	void createPhone(Phone phone);
//	void createTypeAdress(TypeOfAdress adress);
//	void createTypeDocument(TypeOfDocument document);
//	void createTypePhone(TypeOfPhone typePhone);
//	
//	void updateCountry(Country country);
//	void updateTypeOfDocument(TypeOfDocument typeDocument);
//	
//	
	

	

}
