package ar.com.greenleave.pymeManagment.gestionCliente.model.dao.impl;

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

	public void setSessionFactory(SessionFactory nexusSessionFactory) {
		this.gestionClienteSessionFactory = nexusSessionFactory;
	}
}
