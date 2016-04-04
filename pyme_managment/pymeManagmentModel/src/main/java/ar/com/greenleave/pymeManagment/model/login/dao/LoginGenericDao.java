package ar.com.greenleave.pymeManagment.model.login.dao;

import java.util.List;

public interface LoginGenericDao {
	public void save(Object objeto);
	public void update(Object objeto);
	public void delete(Object objeto);
	public void saveOrUpdate(Object objeto);
	public <T> T get(Class<T> clase, Long id);
	public <T> List<T> findAll(Class<T> clase);
}
