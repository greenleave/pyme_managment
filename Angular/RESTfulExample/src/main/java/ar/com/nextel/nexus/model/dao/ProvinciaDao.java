package ar.com.nextel.nexus.model.dao;

import ar.com.nextel.nexus.model.Provincia;

public interface ProvinciaDao {
	
	public void save(Provincia provincia);
	
	public void update(Provincia provincia);
	
	public void delete(Provincia provincia);
	
	public Provincia getProvinciaById(int pId);

}
