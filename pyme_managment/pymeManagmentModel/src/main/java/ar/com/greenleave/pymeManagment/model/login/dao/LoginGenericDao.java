package ar.com.greenleave.pymeManagment.model.login.dao;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.login.exception.GenerarUsuarioException;

public interface LoginGenericDao {
	public void save(Object objeto) throws GenerarUsuarioException;
	public void update(Object objeto);
	public void delete(Object objeto);
	public void saveOrUpdate(Object objeto);
	public <T> T get(Class<T> clase, Long id);
	public <T> List<T> findAll(Class<T> clase);
}
