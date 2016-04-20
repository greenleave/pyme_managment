package ar.com.greenleave.pyme_managment.pymeManagmentWeb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfAdress;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfDocument;
import ar.com.greenleave.pymeManagment.model.service.GestionPymeManager;
import ar.com.greenleave.pyme_managment.pymeManagmentWeb.controller.GestionPymeController;

@Service("gestionPymeController")
//@Controller
public class GestionPymeControllerImpl implements GestionPymeController {
	@Autowired
	GestionPymeManager gestionPymeManager;
	private static Gson gson = new Gson();
	
	@Override
	public String getPersonas() {
		return	gson.toJson(gestionPymeManager.getPersons(null));
	
	}

	@Override
	public String getPersona(String json) {
		
		return gson.toJson(gestionPymeManager.getPersons(gson.fromJson(json, Person.class)));
	}

	@Override
	public void crearPersona(String json) {
		gestionPymeManager.createPerson(gson.fromJson(json, Person.class));
		
	}

	@Override
	public void modificarPersona(String json) {
		gestionPymeManager.updatePerson(gson.fromJson(json, Person.class));
		
	}

	@Override
	public void eliminarPersona(String json) {
		gestionPymeManager.deletePerson(gson.fromJson(json, Person.class));
		
	}

	@Override
	public String getCountries() {
		return gson.toJson(gestionPymeManager.getCountries());
	}

//	@Override
//	public String getContry(String json) {
//		return null;
//	}

	@Override
	public void createCountry(String json) {
		gestionPymeManager.createCountry(gson.fromJson(json, Country.class));
	}

	@Override
	public void updateCountry(String json) {
		gestionPymeManager.updateCountry(gson.fromJson(json, Country.class));
		
	}

	@Override
	public void deleteCountry(String json) {
		gestionPymeManager.deleteCountry(gson.fromJson(json, Country.class));
	}

	@Override
	public String getTypesAdress() {
		return gson.toJson(gestionPymeManager.getTypesAdress());
	}

//	@Override
//	public String getTypeAdress() {
//		return null;
//	}

	@Override
	public void createTypeAdress(String json) {
		gestionPymeManager.createTypeAdress(gson.fromJson(json, TypeOfAdress.class));
		
	}

	@Override
	public void updateTypeAdress(String json) {
		gestionPymeManager.updateTypeAdress(gson.fromJson(json, TypeOfAdress.class));
		
	}

	@Override
	public void deleteTypeAdress(String json) {
		gestionPymeManager.deleteTypeAdress(gson.fromJson(json, TypeOfAdress.class));
		
	}

	@Override
	public String getTypesDocument() {
		return gson.toJson(gestionPymeManager.getTypesOfDocuments());
	}
	
	@Override
	public void createTypeDocument(String json) {
		gestionPymeManager.createTypeDocument(gson.fromJson(json, TypeOfDocument.class));
		
	}

	@Override
	public void updateTypeDocument(String json) {
		gestionPymeManager.updateTypeDocument(gson.fromJson(json, TypeOfDocument.class));
	}

	@Override
	public void deleteTypeDocument(String json) {
		gestionPymeManager.deleteTypeDocument(gson.fromJson(json, TypeOfDocument.class));	
	}

	@Override
	public String save() {
		return "Funciona pedazo da garca";
	}
	
}