package ar.com.greenleave.pymeManagment.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;

import ar.com.greenleave.pymeManagment.gestionCliente.model.dao.GestionClienteTest;
import ar.com.greenleave.pymeManagment.model.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionCliente.TypeOfDocument;
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

	public List<Country> getAllCountries() {
		return gestionClienteGenericDao.findAll(Country.class);
	}

	public void saveTypeDocument(TypeOfDocument document) {
		gestionClienteGenericDao.save(document);
	}

	public TypeOfDocument getTypeDocumentById(Long id) {
		return gestionClienteGenericDao.get(TypeOfDocument.class, id);
	}

	public void updateTypeOfDocument(TypeOfDocument typeDocument) {
		gestionClienteGenericDao.update(typeDocument);
	}

	public void deleteTypeDocumentById(Long id) {
		TypeOfDocument typeOfDocument= new TypeOfDocument();
		gestionClienteGenericDao.delete(typeOfDocument);
	}

	public void savePerson(Person person) {
		gestionClienteGenericDao.save(person);
		
	}	
	
}
