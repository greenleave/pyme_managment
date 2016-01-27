package ar.com.greenleave.pymeManagment.gestionCliente.model.dao;


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

import ar.com.greenleave.pymeManagment.model.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.service.GestionClienteManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ar/com/greenleave/pymeManagment/gestionCliente/model/spring/ApplicationContext.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "gestionClienteTransactionManager", defaultRollback = true)

public class GestionClienteTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private GestionClienteManager gestionClienteManager;
	
	@Autowired
	public void setDataSource(@Qualifier("PYMEDB") DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	

	@Test
	@Rollback(false)
	public void testInsertCountry(){
		Country country = new Country();
		country.setCountry("Brasil");
		country.setCountryCode("BRZ");	
		gestionClienteManager.saveCountry(country);
	}
	
	@Test
	public void testGetCountryById(){
		Country c=gestionClienteManager.getCountryById(1L);
		Assert.assertNotNull(c);
	}
	
	@Test
	@Rollback(false)
	public void testUpdateCountry(){
		Country country = new Country();
		country.setCountry("Brasil");
		country.setCountryCode("BRZ");	
		gestionClienteManager.updateCountry(country);
	}
	
}
