package ar.com.greenleave.pymeManagment.gestionCliente.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Adress;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Phone;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfAdress;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfDocument;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfPerson;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfPhone;
import ar.com.greenleave.pymeManagment.model.service.GestionClienteManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ar/com/greenleave/pymeManagment/gestionCliente/model/spring/ApplicationContext.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "gestionClienteTransactionManager", defaultRollback = true)

public class GestionClienteTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private GestionClienteManager gestionClienteManager;

	@Autowired
	public void setDataSource(@Qualifier("PYMEDB") DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Test
	@Rollback(false)
	public void testInsertCountry() {
		Country country = new Country();
		country.setCountry("Brasil");
		country.setCountryCode("BRZ");
		gestionClienteManager.saveCountry(country);
	}

	@Test
	public void testGetCountryById() {
		Country c = gestionClienteManager.getCountryById(1L);
		Assert.assertNotNull(c);
	}

	@Test
	@Rollback(false)
	public void testUpdateCountry() {
		Country country = gestionClienteManager.getCountryById(1L);
		country.setCodPhone("+54");
		gestionClienteManager.updateCountry(country);
	}

	@Test
	public void testGetAllCountries() {
		gestionClienteManager.getAllCountries();
	}

	@Test
	@Rollback(false)
	public void testInsertTypeDocument() {
		TypeOfDocument document = new TypeOfDocument();
		document.setCountry(gestionClienteManager.getCountryById(1L));
		document.setTypeDocument("D.N.I.");
		gestionClienteManager.saveTypeDocument(document);
	}

	@Test
	@Rollback(false)
	public void testInsertTypeDocument2() {
		TypeOfDocument document = new TypeOfDocument();
		Country c = new Country();
		c.setId(2L);
		document.setCountry(c);
		document.setTypeDocument("D.B.");
		gestionClienteManager.saveTypeDocument(document);
	}

	@Test
	public void testGetTypeDocumentById() {
		TypeOfDocument typeDocument = gestionClienteManager.getTypeDocumentById(1L);
		Assert.assertNotNull(typeDocument);
		Assert.assertNotNull(typeDocument.getCountry());
	}

	@Test
	@Rollback(false)
	public void testUpdateTypeDocument() {
		TypeOfDocument typeDocument = gestionClienteManager.getTypeDocumentById(2L);
		typeDocument.setTypeDocument("R.G.");
		gestionClienteManager.updateTypeOfDocument(typeDocument);
	}

	@Test
	@Rollback(false)
	public void testDeleteTypeDocumentById() {
		gestionClienteManager.deleteTypeDocumentById(2L);
	}

	@Test
	@Rollback(false)
	public void testInsertarTypePhone() {
		TypeOfPhone typePhone = new TypeOfPhone();
		typePhone.setTypePhone("CELULAR");
		gestionClienteManager.saveTypePhone(typePhone);
	}
	
	@Test
	@Rollback(false)
	public void testInsertarTypePhone2() {
		TypeOfPhone typePhone = new TypeOfPhone();
		typePhone.setTypePhone("LABORAL");
		gestionClienteManager.saveTypePhone(typePhone);
	}

	@Test
	@Rollback(false)
	public void testInsertarTypeAdress() {
		TypeOfAdress adress = new TypeOfAdress();
		adress.setTypeAdress("Domicilio Legal");
		gestionClienteManager.saveTypeAdress(adress);
	}

	@Test
	@Rollback(false)
	public void testInsertPhone(){
		TypeOfPhone typePhone = new TypeOfPhone();
		typePhone.setId(1L);		
//		List<Phone> phones = new ArrayList<Phone>();
		Phone phone = new Phone();
		phone.setTypePhone(typePhone);
		phone.setPhone("01162961073");
		gestionClienteManager.savePhone(phone);
//		phones.add(phone);
	
	}
	

	@Test
	@Rollback(false)
	public void testInsertarPersona() {
		Person person = new Person();

		TypeOfAdress adress = new TypeOfAdress();
		adress.setId(1L);

		List<Adress> direcciones = new ArrayList<Adress>();
		Adress direccion = new Adress();
		Country country = new Country();
		country.setId(1L);

		direccion.setApartment("4 D");
		direccion.setNumber(827L);
		direccion.setPostCode("1708");
		direccion.setStreet("Leandro N. Alem");
		direccion.setTypeAdress(adress);
		direccion.setCountry(country);
		direcciones.add(direccion);

		TypeOfPhone typePhone = new TypeOfPhone();
		typePhone.setId(1L);
		List<Phone> phones = new ArrayList<Phone>();
		Phone phone = new Phone();
		phone.setTypePhone(typePhone);
		phone.setPhone("01162961073");
		phones.add(phone);

		person.setAdress(direcciones);
		person.setPhones(phones);
		person.setTypeOfPerson(TypeOfPerson.HOMBRE);
		person.setDocument("38.256.096");
		person.setName("Sebastian Emanuel Enrique Bogado");

		TypeOfDocument typeOfDocument = new TypeOfDocument();
		typeOfDocument.setId(1L);
		person.setTypeOfDocument(typeOfDocument);

		gestionClienteManager.savePerson(person);
	}

}
