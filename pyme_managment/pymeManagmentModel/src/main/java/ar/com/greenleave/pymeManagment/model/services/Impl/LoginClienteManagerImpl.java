package ar.com.greenleave.pymeManagment.model.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginDao;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginGenericDao;
import ar.com.greenleave.pymeManagment.model.service.LoginClienteManager;

@Transactional
@Service("loginManager")
public class LoginClienteManagerImpl implements LoginClienteManager{

	@Autowired 
	private LoginGenericDao genericDao;
	
	@Autowired
	private LoginDao loginDao;
	
	
	public User login(String userName, String password) {
		return loginDao.login(userName, password);
	}

	public String userRegistration(User person) {
		genericDao.save(person);
		return "Todo ok";
	}

}
