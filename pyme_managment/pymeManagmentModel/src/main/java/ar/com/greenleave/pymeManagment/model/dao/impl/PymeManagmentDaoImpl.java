package ar.com.greenleave.pymeManagment.model.dao.impl;

import org.jboss.logging.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.dao.PymeManagmentDao;

@Repository(value = "pymeManagmentDao")
public class PymeManagmentDaoImpl extends JdbcDaoSupport implements PymeManagmentDao {
	
	private final static Logger logger = Logger.getLogger(PymeManagmentDaoImpl.class);
	
}