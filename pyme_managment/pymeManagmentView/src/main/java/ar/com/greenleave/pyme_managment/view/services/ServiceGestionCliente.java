package ar.com.greenleave.pyme_managment.view.services;

import java.util.List;

import ar.com.greenleave.pyme_managment.view.dto.CountryDTO;

public interface ServiceGestionCliente {
	void savePais(CountryDTO country);
	List<CountryDTO> getAllContry();
	
}
