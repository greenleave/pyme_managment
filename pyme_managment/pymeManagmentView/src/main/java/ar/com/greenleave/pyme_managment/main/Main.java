package ar.com.greenleave.pyme_managment.main;

import ar.com.greenleave.pyme_managment.view.dto.UserDTO;
import ar.com.greenleave.pyme_managment.view.services.ServiceGestionCliente;
import ar.com.greenleave.pyme_managment.view.services.impl.ServiceGestionClienteImpl;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

//		CountryDTO country = new CountryDTO();
//		country.setCodPhone("+0554");
//		country.setCountry("Brasil");
//		country.setCountryCode("BRZ");
//		ServiceGestionCliente servicio = new ServiceGestionClienteImpl();
//		servicio.savePais(country);
		UserDTO usuario = new UserDTO();
		usuario.setUserName("as");
		usuario.setPassword("12345678a");
		ServiceGestionCliente servicio = new ServiceGestionClienteImpl();
		servicio.login(usuario);
		
	}
}
