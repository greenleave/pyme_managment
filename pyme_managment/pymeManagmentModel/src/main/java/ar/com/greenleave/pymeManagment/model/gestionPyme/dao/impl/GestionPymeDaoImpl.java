package ar.com.greenleave.pymeManagment.model.gestionPyme.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.gestionPyme.dao.GestionPymeDao;
import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Country;

@Repository(value = "gestionPymeDao")
public class GestionPymeDaoImpl extends HibernateDaoHelper implements GestionPymeDao {
	
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(GestionPymeDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Country> getCountries(Country country) {
		// Le especifico que tiene que traer la clase Country y el alias de esta es c
		Criteria c= getSession().createCriteria(Country.class, "c");
		return c.list();
	}
	
}