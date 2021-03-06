package ar.com.greenleave.pymeManagment.model.gestionPyme.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.gestionPyme.dao.GestionPymeGenericDao;

@Repository(value="gestionClienteGenericDao")
public class GestionClienteGenericDaoImpl extends HibernateDaoHelper implements GestionPymeGenericDao {

	public void save(Object objeto) {
		getSession().save(objeto);
	}

	public void update(Object objeto) {
		getSession().update(objeto);
	}

	public void delete(Object objeto) {
		getSession().delete(objeto);
	}

	public void saveOrUpdate(Object objeto) {
		getSession().saveOrUpdate(objeto);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clase, Long id) {
		return (T)getSession().get(clase, id);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clase) {
		return getSession().createCriteria(clase).list();
	}	

}
