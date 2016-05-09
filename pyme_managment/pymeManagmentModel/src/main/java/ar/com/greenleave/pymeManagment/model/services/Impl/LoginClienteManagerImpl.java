package ar.com.greenleave.pymeManagment.model.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginDao;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginGenericDao;
import ar.com.greenleave.pymeManagment.model.service.LoginClienteManager;

@Transactional
@Service("loginClienteManager")
public class LoginClienteManagerImpl implements LoginClienteManager {

	@Autowired(required=true)
	private LoginGenericDao genericDao;

	@Autowired(required=true)
	private LoginDao loginDao;

	public User login(String userName, String password) {
		return loginDao.login(userName, password);
	}

	public User userRegistration(User person) {
		try{
			genericDao.save(person);
			//Pude generar el usuario y no me puteo la base de datos
			return person;
		}catch(Exception e){
			// me puteo la base de datos y probablemente este repetido el usuario
			return null;
		}
	}

}
