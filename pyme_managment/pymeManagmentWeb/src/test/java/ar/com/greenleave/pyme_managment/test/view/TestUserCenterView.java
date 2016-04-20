package ar.com.greenleave.pyme_managment.test.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ar.com.greenleave.pyme_managment.pymeManagmentWeb.controller.LoginController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../../../../../../applicationContext.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "loginTransactionManager", defaultRollback = true)
public class TestUserCenterView {

	
	@Autowired
	LoginController loginController;
	
	
	@Test
	@Rollback(false)
	public void testLogin(){
		String json = "User:{userName:'seeb', password:'seeb143'}";
		loginController.login(json);
	}
	
}