package ar.com.nextel.nexus.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.com.nextel.nexus.model.Provincia;
import ar.com.nextel.nexus.model.dao.ProvinciaDao;
import ar.com.nextel.nexus.utils.CustomHibernateDaoSupport;

@Repository("provinciaDao")
public class ProvinciaDaoImpl extends CustomHibernateDaoSupport implements ProvinciaDao {

	@Override
	public void save(Provincia provincia) {
		getHibernateTemplate().save(provincia);
	}

	@Override
	public void update(Provincia provincia) {
		getHibernateTemplate().update(provincia);
	}

	@Override
	public void delete(Provincia provincia) {
		getHibernateTemplate().delete(provincia);
	}

	@Override
	public Provincia getProvinciaById(int pId) {
		List lista = getHibernateTemplate().find("from Provincia where id=?", pId);
		return (Provincia)lista.get(0);
	}

}
