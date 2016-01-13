package ar.com.greenleave.pymeManagment.model.dao;

import java.util.ArrayList;

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

import ar.com.greenleave.pymeManagment.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.gestionCliente.TypeClient;
import ar.com.greenleave.pymeManagment.gestionCliente.TypeDocument;
import ar.com.greenleave.pymeManagment.gestionCliente.TypePhone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ar/com/greenleave/pymeManagment/model/spring/ApplicationContext.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "pymeManagmentTransactionManager", defaultRollback = true)

public class GenericDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private PymeManagmentGenericDao genericDao;
	
	@Autowired
	public void setDataSource(@Qualifier("PYMEDB") DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	
	@Test
	@Rollback(false)
	public void testSaveTipoCliente(){
		TypeClient tipoCliente = new TypeClient();
		tipoCliente.setTypeClient("Chamullero");
		genericDao.save(tipoCliente);
	}
	
	
	@Test
	public void testTipoTelefono(){
		TypePhone tipoTelefono=genericDao.get(TypePhone.class, 1L);
		Assert.assertNotNull(tipoTelefono);
	}
	
	@Test
	@Rollback(false)
	public void insertTipoTelefono(){
		TypePhone tipoTel= new TypePhone();
		tipoTel.setTypePhone("Casa");
		genericDao.save(tipoTel);
	}
	
	@Test
	@Rollback(false)
	public void insertTypeDocument(){
		TypeDocument typeDocument= new TypeDocument();
		typeDocument.setTypeDocument("D.N.I");
		Country country = new Country();
		country.setId(1L);
		typeDocument.setCountry(country);
		genericDao.saveOrUpdate(typeDocument);
	}
	
	@Test
	@Rollback(false)
	public void insertCountry(){
		Country country = new Country();
		country.setTypeDocuments(new ArrayList<TypeDocument>());
		country.setName("Argentina");
		genericDao.save(country);
	}
	
	
	
	
}
