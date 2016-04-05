package ar.com.greenleave.pymeManagment.model.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginDao;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginGenericDao;
import ar.com.greenleave.pymeManagment.model.service.LoginClienteManager;

public class LoginClienteManagerImpl implements LoginClienteManager{

	@Autowired 
	private LoginGenericDao genericDao;
	
	@Autowired
	private LoginDao loginDao;
	
	
	public String login(String userName, String password) {
		loginDao.login(userName, password);
		return null;
	}

	public String userRegistration(User person) {
		genericDao.save(person);
		return null;
	}

}
