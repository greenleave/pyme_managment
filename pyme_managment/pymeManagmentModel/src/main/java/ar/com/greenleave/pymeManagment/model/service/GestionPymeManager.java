package ar.com.greenleave.pymeManagment.model.service;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfAdress;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfDocument;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfPhone;

public interface GestionPymeManager {
	
	
	List<Person> getPersons(Person person);
	void createPerson(Person person);
	void updatePerson(Person person);
	void deletePerson(Person person);
	
	
	
	List<Country> getCountries();
	Country getCountryById(Long id);
	void createCountry(Country country);
	void updateCountry(Country country);
	void deleteCountry(Country country);
	
	
	
	List<TypeOfPhone> getTypesOfPhone();
	void createTypePhone(TypeOfPhone typePhone);
	void updateTypePhone(TypeOfPhone typePhone);
	void deleteTypePhone(TypeOfPhone typePhone);
	
	
	List<TypeOfDocument> getTypesOfDocuments();
	void createTypeDocument(TypeOfDocument typeDocument);
	void updateTypeDocument(TypeOfDocument typeDocument);
	void deleteTypeDocument(TypeOfDocument typeDocument);
	
	
	List<TypeOfAdress> getTypesAdress();
	void createTypeAdress(TypeOfAdress typeAdress);
	void updateTypeAdress(TypeOfAdress typeAdress);
	void deleteTypeAdress(TypeOfAdress typeAdress);
	
	
	
	

/**
 * 
 * 
 * Estos tres modulos necesitan que primero funcione bien el anterior
 * 
 * 	
 */
	
//	List<Employee> getEmployees();
//	List<Employee> getEmployeesByArea(Area area);
//	Employee getEmployee(Employee employee);
//	void createEmployee(Employee employee);
//	void updateEmployee(Employee employee);
//	void deleteEmployee(Employee employee);
	
	
	
//	Client getClient(Client client);
//	List<Client> getClients();
//	void createClient(Client client);
//	void updateClient(Client client);
//	void deleteClient(Client client);
//	
//	
//	
//	List<Vendor> getVendors();
//	List<Vendor> getVendorsByRubro(Rubro rubro);
//	List<Vendor> getVendorsByProducto(Product producto);
//	Vendor getVendor(Vendor vendor);
//	void createVendor(Vendor vendor);
//	void updateVendor(Vendor vendor);
//	void deleteVendor(Vendor vendor);

}
