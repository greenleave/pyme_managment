package ar.com.greenleave.pymeManagment.model.services.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.greenleave.pymeManagment.model.gestionPyme.dao.GestionPymeDao;
import ar.com.greenleave.pymeManagment.model.gestionPyme.dao.GestionPymeGenericDao;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Client;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfAdress;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfDocument;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfPhone;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Vendor;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados.Employee;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados.TypeOfEmployee;
import ar.com.greenleave.pymeManagment.model.service.GestionPymeManager;
@Transactional
@Service("gestionPymeManager")
public class GestionPymeManagerImpl implements GestionPymeManager{
	
	private static Log log = LogFactory.getLog(GestionPymeManagerImpl.class);
	
	@Autowired(required=true)
	private GestionPymeGenericDao gestionPymeGenericDao;
	
	@Autowired(required=true)
	private GestionPymeDao gestionPymeDao;

	public void createPerson(Person person) {
		gestionPymeGenericDao.save(person);		
	}

	public void updatePerson(Person person) {
		gestionPymeGenericDao.update(person);
	}

	public void deletePerson(Person person) {
		gestionPymeGenericDao.delete(person);
	}

	public List<Person> getPersons(Person person) {
		return gestionPymeDao.getPersons(person);
	}

	public void createCountry(Country country) {
		gestionPymeGenericDao.save(country);
		
	}

	public void updateCountry(Country country) {
		gestionPymeGenericDao.update(country);
		
	}

	public void deleteCountry(Country country) {
		gestionPymeGenericDao.delete(country);
		
	}
	
	public List<Country> getCountries() {
		return gestionPymeGenericDao.findAll(Country.class);
	}

	public void createTypePhone(TypeOfPhone typePhone) {
		gestionPymeGenericDao.save(typePhone);
	}

	public void updateTypePhone(TypeOfPhone typePhone) {
		gestionPymeGenericDao.update(typePhone);
		
	}

	public void deleteTypePhone(TypeOfPhone typePhone) {
		gestionPymeGenericDao.delete(typePhone);
	}

	public void createTypeAdress(TypeOfAdress typeAdress) {
		gestionPymeGenericDao.save(typeAdress);
	}

	public void updateTypeAdress(TypeOfAdress typeAdress) {
		gestionPymeGenericDao.update(typeAdress);
		
	}

	public void deleteTypeAdress(TypeOfAdress typeAdress) {
		gestionPymeGenericDao.delete(typeAdress);
	}

	public void createClient(Client client) {
		gestionPymeGenericDao.save(client);
	}

	public void createVendor(Vendor vendor) {
		gestionPymeGenericDao.save(vendor);
	}

//	public void createEmployee(Employee employee) {
//		gestionPymeGenericDao.save(employee);
//	}

	public List<TypeOfDocument> getTypesOfDocuments() {
		return gestionPymeGenericDao.findAll(TypeOfDocument.class);
	}

	public List<TypeOfPhone> getTypesOfPhone() {
		return gestionPymeGenericDao.findAll(TypeOfPhone.class);
	}

	public void createTypeDocument(TypeOfDocument typeDocument) {
		gestionPymeGenericDao.save(typeDocument);
		
	}

	public void updateTypeDocument(TypeOfDocument typeDocument) {
		gestionPymeGenericDao.update(typeDocument);
		
	}

	public void deleteTypeDocument(TypeOfDocument typeDocument) {
		gestionPymeGenericDao.delete(typeDocument);
	}

	public List<TypeOfAdress> getTypesAdress() {
		return gestionPymeGenericDao.findAll(TypeOfAdress.class);
	}

	public Country getCountryById(Long id) {
		return gestionPymeGenericDao.get(Country.class, id);
	}

	public Person getPersonById(Long id) {
		return gestionPymeGenericDao.get(Person.class, id);
	}

	public TypeOfPhone getTypeOfPhoneById(Long id) {
		return gestionPymeGenericDao.get(TypeOfPhone.class, id);
	}

	public TypeOfDocument getTypeOfDocumentById(Long id) {
		return gestionPymeGenericDao.get(TypeOfDocument.class, id);
	}

	public TypeOfAdress getTypeOfAdressById(Long id) {
		return gestionPymeGenericDao.get(TypeOfAdress.class, id);
	}

	public List<Employee> getEmployees() {
		return gestionPymeGenericDao.findAll(Employee.class);
	}

	public List<Employee> getEmployeesByTypeEmployee(String typeEmployee) {
		return gestionPymeDao.getEmployeesByTypeEmployee(typeEmployee);
	}

	public List<Employee> getEmployeesByTypeEmployeeId(Long id) {		
		return gestionPymeDao.getEmployeesByTypeEmployeeId(id);
	}

	public Employee getEmployee(Long id) {
		return gestionPymeGenericDao.get(Employee.class, id);
	}

	public void createEmployee(Employee employee) {
		gestionPymeGenericDao.save(employee);
	}

	public void updateEmployee(Employee employee) {
		gestionPymeGenericDao.update(employee);
	}

	public void deleteEmployee(Employee employee) {
		gestionPymeGenericDao.delete(employee);
	}

	public void createTypeEmployee(TypeOfEmployee typeOfEmployee) {
		gestionPymeGenericDao.save(typeOfEmployee);
	}
	
	public void updateTypeEmployee(TypeOfEmployee typeOfEmployee) {
		gestionPymeGenericDao.update(typeOfEmployee);
	}

	public void deleteTypeEmployee(TypeOfEmployee typeOfEmployee) {
		gestionPymeGenericDao.delete(typeOfEmployee);
		
	}

	public TypeOfEmployee getTypeOfEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TypeOfEmployee> getTypeEmployeesByLikeName(String name) {
		return gestionPymeDao.getTypeEmployeesByLikeName(name);
	}

	public List<TypeOfEmployee> getTypesOfEmployees() {
		return gestionPymeGenericDao.findAll(TypeOfEmployee.class);
	}

}
