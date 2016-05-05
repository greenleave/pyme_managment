package ar.com.greenleave.pyme_managment.test.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import ar.com.greenleave.pymeManagment.model.login.User;
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
		Gson gson = new Gson();
		User u = new User();
		u.setUserName("seeb");
		u.setPassword("seeb143");
		String json =  gson.toJson(u); //"User:{userName:'seeb', password:'seeb143'}";
		System.out.println(json);
		System.out.println(loginController.login(json));
	}
	
	
	@Test
	@Rollback(false)
	public void testCreateUser(){
		String json = "{\"name\":\"Sebastian Emanuel Enrique Bogado\", \"phone\":\"1162961073\", \"email\":\"seebogado@gmail.com\" ,\"userName\":\"seeb\", \"password\":\"seeb143\"}";
		loginController.createUser(json);
	}
	
	
	
	
}