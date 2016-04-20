package ar.com.greenleave.pymeManagment.login.model.dao;

import javax.sql.DataSource;

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
import org.springframework.util.Assert;

import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.service.LoginClienteManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ar/com/greenleave/pymeManagment/gestionCliente/model/spring/ApplicationContext.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "loginTransactionManager", defaultRollback = true)
public class UserCenterTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	LoginClienteManager loginClienteManager;

	@Autowired
	public void setDataSource(@Qualifier("LOGINDB") DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Test
	@Rollback(false)
	public void login(){
		Assert.notNull( loginClienteManager.login("as", "12345678a") );
	}
	
	
	@Test
	@Rollback(false)
	public void createUser(){
		User user = new User();
		user.setEmail("tuvieja@tuvieja.com");
		user.setIsLocked(false);
		user.setName("Ernesto Albarez");
		user.setPassword("12345678a");
		user.setPhone("1122334455");
		user.setUserName("ealbarez");
		loginClienteManager.userRegistration(user);
	}
}
