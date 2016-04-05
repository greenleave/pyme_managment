package ar.com.greenleave.pymeManagment.model.login.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LoginHibernateDaoHelper {
	@Autowired
	@Qualifier("loginSessionFactory")
	private SessionFactory loginSessionFactory;

	public Session getSession() {
		return this.loginSessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory pymeManagmentSessionFactory) {
		this.loginSessionFactory = pymeManagmentSessionFactory;
	}
}
