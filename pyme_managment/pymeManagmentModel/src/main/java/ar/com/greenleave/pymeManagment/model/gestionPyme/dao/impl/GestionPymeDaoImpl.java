package ar.com.greenleave.pymeManagment.model.gestionPyme.dao.impl;

import org.jboss.logging.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.gestionPyme.dao.GestionPymeDao;

@Repository(value = "gestionClienteDao")
public class GestionPymeDaoImpl extends JdbcDaoSupport implements GestionPymeDao {
	
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(GestionPymeDaoImpl.class);
	
}