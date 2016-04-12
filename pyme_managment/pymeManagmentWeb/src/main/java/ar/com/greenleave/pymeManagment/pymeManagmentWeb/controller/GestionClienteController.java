package ar.com.greenleave.pymeManagment.pymeManagmentWeb.controller;

public interface GestionClienteController {

	//Clientes
	public String getClientes();
	public void getCliente(String json);
	public void crearCliente(String json);
	public void modificarCliente(String json);
	public void eliminarCliente(String json);
	
	//	Person
	public String getPersonas();
	public String getPersona(String json);
	public void crearPersona(String json);
	public void modificarPersona(String json);
	public void	eliminarPersona(String json);
	
	
	//Country
	public String getCountries();
	public String getContry(String json);
	public void createCountry(String json);
	public void updateCountry(String json);
	public void deleteCountry(String json);

	
	
	
}
