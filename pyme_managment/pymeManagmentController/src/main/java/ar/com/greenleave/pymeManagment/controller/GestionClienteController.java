package ar.com.greenleave.pymeManagment.controller;

/**
* @since 11/03/2016
* @author Sebastian Emanuel Enrique Bogado
* @mailTo: anonymus.sheep@gmail.com
* @version v1.0
*/

public interface GestionClienteController {
	public String createCliente(String json);
	public String updateClient(String json);
	public String deleteClient(String json);
	public String getAllClients();
	public String createCountry(String json);
	
	
	
	
	
}
