package ar.com.greenleave.pyme_managment.main;

import ar.com.greenleave.pyme_managment.view.dto.CountryDTO;
import ar.com.greenleave.pyme_managment.view.services.ServiceGestionCliente;
import ar.com.greenleave.pyme_managment.view.services.impl.ServiceGestionClienteImpl;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		CountryDTO country = new CountryDTO();
		country.setCodPhone("042432");
		country.setCountry("Estados Unidos");
		country.setCountryCode("EEUU");
		ServiceGestionCliente servicio = new ServiceGestionClienteImpl();
		servicio.savePais(country);
	}
}
