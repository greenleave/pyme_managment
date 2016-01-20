package ar.com.greenleave.pymeManagment.gestionCliente.model.dao.impl;

import org.jboss.logging.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.gestionCliente.model.dao.GestionClienteDao;
import ar.com.greenleave.pymeManagment.gestionCliente.model.dao.GestionClienteGenericDao;

@Repository(value = "gestionClienteDao")
public class GestionClienteDaoImpl extends JdbcDaoSupport implements GestionClienteDao {
	
	private final static Logger logger = Logger.getLogger(GestionClienteDaoImpl.class);
	
}