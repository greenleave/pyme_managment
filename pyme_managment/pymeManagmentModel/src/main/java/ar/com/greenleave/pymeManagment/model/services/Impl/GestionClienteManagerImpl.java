package ar.com.greenleave.pymeManagment.model.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.greenleave.pymeManagment.model.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionCliente.Phone;
import ar.com.greenleave.pymeManagment.model.gestionCliente.TypeOfAdress;
import ar.com.greenleave.pymeManagment.model.gestionCliente.TypeOfDocument;
import ar.com.greenleave.pymeManagment.model.gestionCliente.TypeOfPhone;
import ar.com.greenleave.pymeManagment.model.gestionCliente.dao.GestionClienteGenericDao;
import ar.com.greenleave.pymeManagment.model.service.GestionClienteManager;

@Transactional
@Service("gestionClienteManager")
public class GestionClienteManagerImpl implements GestionClienteManager{
	
	@Autowired
	private GestionClienteGenericDao gestionClienteGenericDao;
	
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

	public void saveTypeAdress(TypeOfAdress adress) {
		gestionClienteGenericDao.save(adress);
	}

	public void saveTypePhone(TypeOfPhone typePhone) {
		gestionClienteGenericDao.save(typePhone);
	}

	public void savePhone(Phone phone) {
		gestionClienteGenericDao.save(phone);
		
	}

	
}
