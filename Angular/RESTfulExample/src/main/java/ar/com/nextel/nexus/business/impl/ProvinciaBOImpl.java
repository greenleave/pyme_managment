package ar.com.nextel.nexus.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.nextel.nexus.business.ProvinciaBO;
import ar.com.nextel.nexus.model.Provincia;
import ar.com.nextel.nexus.model.dao.ProvinciaDao;

@Service("provinciaBo")
public class ProvinciaBOImpl implements ProvinciaBO {
	
	@Autowired
	ProvinciaDao provinciaDao;
	
	public void setProvinciaDao(ProvinciaDao provinciaDao){
		this.provinciaDao = provinciaDao;
	}

	@Override
	public void save(Provincia provincia) {
		provinciaDao.save(provincia);
	}

	@Override
	public void update(Provincia provincia) {
		provinciaDao.update(provincia);
	}

	@Override
	public void delete(Provincia provincia) {
		provinciaDao.delete(provincia);
	}
	
	@Override
	public Provincia getProvinciaById(int pId) {		
		return provinciaDao.getProvinciaById(pId);
	}	

}
