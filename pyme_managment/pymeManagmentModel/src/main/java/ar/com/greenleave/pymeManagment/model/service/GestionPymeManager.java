package ar.com.greenleave.pymeManagment.model.service;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfAdress;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfDocument;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfPhone;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados.Employee;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados.TypeOfEmployee;

public interface GestionPymeManager {
	
	Person getPersonById(Long id);
	List<Person> getPersons(Person person);
	void createPerson(Person person);
	void updatePerson(Person person);
	void deletePerson(Person person);
	
	
	Country getCountryById(Long id);
	List<Country> getCountries();
	void createCountry(Country country);
	void updateCountry(Country country);
	void deleteCountry(Country country);
	
	
	TypeOfPhone getTypeOfPhoneById(Long id);
	List<TypeOfPhone> getTypesOfPhone();
	void createTypePhone(TypeOfPhone typePhone);
	void updateTypePhone(TypeOfPhone typePhone);
	void deleteTypePhone(TypeOfPhone typePhone);
	
	TypeOfDocument getTypeOfDocumentById(Long id);
	List<TypeOfDocument> getTypesOfDocuments();
	void createTypeDocument(TypeOfDocument typeDocument);
	void updateTypeDocument(TypeOfDocument typeDocument);
	void deleteTypeDocument(TypeOfDocument typeDocument);
	
	
	TypeOfAdress getTypeOfAdressById(Long id);
	List<TypeOfAdress> getTypesAdress();
	void createTypeAdress(TypeOfAdress typeAdress);
	void updateTypeAdress(TypeOfAdress typeAdress);
	void deleteTypeAdress(TypeOfAdress typeAdress);
	
	List<Employee> getEmployeesByTypeEmployeeId(Long id);
	List<Employee> getEmployeesByTypeEmployee(String typeEmployee);
	Employee getEmployee(Long id);
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	
	
	
	TypeOfEmployee getTypeOfEmployeeById(Long id);
	List<TypeOfEmployee> getTypeEmployeesByLikeName(String name);
	List<TypeOfEmployee> getTypesOfEmployees();
	void createTypeEmployee(TypeOfEmployee typeOfEmployee);
	void updateTypeEmployee(TypeOfEmployee typeOfEmployee);
	void deleteTypeEmployee(TypeOfEmployee typeOfEmployee);
	
	

/**
 * 
 * 
 * Estos tres modulos necesitan que primero funcione bien el anterior
 * 
 * 	
 */
	

	
	
	
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
