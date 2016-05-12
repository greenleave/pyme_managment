package ar.com.nextel.nexus.business;

import ar.com.nextel.nexus.model.Provincia;
import ar.com.nextel.nexus.model.dao.ProvinciaDao;

public interface ProvinciaBO {
	
	public void save(Provincia provincia);
	
	public void update(Provincia provincia);
	
	public void delete(Provincia provincia);
	
	public Provincia getProvinciaById(int pId);

}
