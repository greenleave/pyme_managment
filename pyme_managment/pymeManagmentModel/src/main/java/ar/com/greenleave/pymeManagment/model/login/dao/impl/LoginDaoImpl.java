package ar.com.greenleave.pymeManagment.model.login.dao.impl;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.gestionCliente.dao.impl.GestionClienteDaoImpl;
import ar.com.greenleave.pymeManagment.model.login.User;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginDao;

@Repository(value = "loginDao")
public class LoginDaoImpl extends LoginHibernateDaoHelper implements LoginDao {

	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(GestionClienteDaoImpl.class);
	
	public User login(String userName, String password) {
		
		return null;
	}

}
