package ar.com.greenleave.pymeManagment.model.gestionPyme.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HibernateDaoHelper {

	@Autowired
	@Qualifier("gestionPymeSessionFactory")
	private SessionFactory gestionPymeSessionFactory;

	public Session getSession() {
		return this.gestionPymeSessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory pymeManagmentSessionFactory) {
		this.gestionPymeSessionFactory = pymeManagmentSessionFactory;
	}
}
