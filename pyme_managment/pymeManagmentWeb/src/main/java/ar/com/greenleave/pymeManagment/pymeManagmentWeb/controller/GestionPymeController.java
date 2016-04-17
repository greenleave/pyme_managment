package ar.com.greenleave.pymeManagment.pymeManagmentWeb.controller;

public interface GestionPymeController {

	//Clientes
	public String getClients();
	public void getClient(String json);
	public void createClient(String json);
	public void updateCliente(String json);
	public void deleteCliente(String json);
	
	//	Person
	public String getPersonas();
	public String getPersona(String json);
	public void crearPersona(String json);
	public void modificarPersona(String json);
	public void	eliminarPersona(String json);
	
	
	//	Country
	public String getCountries();
	public String getContry(String json);
	public void createCountry(String json);
	public void updateCountry(String json);
	public void deleteCountry(String json);

	//	TypeAdress
	public String getTypesAdress();
	public String getTypeAdress();
	public void createTypeAdress(String json);
	public void updateTypeAdress(String json);
	public void deleteTypeAdress(String json);

	//  TypeDocument
	public String getTypesDocument();
	public String getTypeDocument(String json);
	public void createTypeDocument(String json);
	public void updateTypeDocument(String json);
	public void deleteTypeDocument(String json);	
}
