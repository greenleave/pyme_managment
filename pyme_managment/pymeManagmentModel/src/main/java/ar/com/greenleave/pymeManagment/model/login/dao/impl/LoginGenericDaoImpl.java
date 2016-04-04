package ar.com.greenleave.pymeManagment.model.login.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.com.greenleave.pymeManagment.model.gestionCliente.dao.impl.HibernateDaoHelper;
import ar.com.greenleave.pymeManagment.model.login.dao.LoginGenericDao;

@Repository(value="loginGenericDao")
public class LoginGenericDaoImpl extends HibernateDaoHelper implements LoginGenericDao {

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
