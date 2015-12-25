package ar.com.greenleave.pymeManagment.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HibernateDaoHelper {

	@Autowired
	@Qualifier("pymeManagmentSessionFactory")
	private SessionFactory pymeManagmentSessionFactory;

	public Session getSession() {
		return this.pymeManagmentSessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory nexusSessionFactory) {
		this.pymeManagmentSessionFactory = nexusSessionFactory;
	}
}
