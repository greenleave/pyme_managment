package ar.com.greenleave.pymeManagment.model.gestionCliente.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HibernateDaoHelper {

	@Autowired
	@Qualifier("gestionClienteSessionFactory")
	private SessionFactory gestionClienteSessionFactory;

	public Session getSession() {
		return this.gestionClienteSessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory pymeManagmentSessionFactory) {
		this.gestionClienteSessionFactory = pymeManagmentSessionFactory;
	}
}
