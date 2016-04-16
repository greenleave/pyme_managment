package ar.com.greenleave.pymeManagment.model.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.greenleave.pymeManagment.model.gestionPyme.dao.GestionPymeGenericDao;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestiomEmpleados.Employee;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Client;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfAdress;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfPhone;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Vendor;
import ar.com.greenleave.pymeManagment.model.service.GestionPymeManager;

@Transactional
@Service("gestionPymeManager")
public class GestionPymeManagerImpl implements GestionPymeManager{
	
	@Autowired
	private GestionPymeGenericDao gestionPymeGenericDao;

	public void createPerson(Person person) {
		gestionPymeGenericDao.save(person);		
	}

	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public List<Person> getPersons(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveCountry(Country country) {
		// TODO Auto-generated method stub
		
	}

	public void updateCountry(Country country) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCountry(Country country) {
		// TODO Auto-generated method stub
		
	}

	public List<Country> getCountries(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveTypePhone(TypeOfPhone typePhone) {
		// TODO Auto-generated method stub
		
	}

	public void updateTypePhone(TypeOfPhone typePhone) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTypePhone(TypeOfPhone typePhone) {
		// TODO Auto-generated method stub
		
	}

	public void saveTypeAdress(TypeOfAdress typeAdress) {
		// TODO Auto-generated method stub
		
	}

	public void updateTypeAdress(TypeOfAdress typeAdress) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTypeAdress(TypeOfAdress typeAdress) {
		// TODO Auto-generated method stub
		
	}

	public void createClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	public void createVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		
	}

	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
