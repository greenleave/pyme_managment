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

import ar.com.greenleave.pymeManagment.model.login.Perfil;
import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginGenericDao;
import ar.com.greenleave.pymeManagment.model.login.exception.GenerarUsuarioException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ar/com/greenleave/pymeManagment/gestionCliente/model/spring/ApplicationContext.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "loginTransactionManager", defaultRollback = true)
public class GenericDaoLoginTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private LoginGenericDao genericDao;
	
	@Autowired
	public void setDataSource(@Qualifier("LOGINDB") DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Test
	@Rollback(false)
	public void testInsertPerfil(){
		Perfil perfil = new Perfil();
		perfil.setName("Ventas");
		try {
			genericDao.save(perfil);
		} catch (GenerarUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Rollback(false)
	public void testInsertUser(){
		User usuario = new User();
		usuario.setEmail("anonymus.sheep@yahoo.com");
		usuario.setIsLocked(false);
		usuario.setName("Anonymus Sheep");
		usuario.setUserName("as");
		usuario.setPassword("12345678a");
		try {
			genericDao.save(usuario);
		} catch (GenerarUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
