package ar.com.greenleave.pymeManagment.controller;

/**
* @since 11/03/2016
* @author Sebastian Emanuel Enrique Bogado
* @mailTo: anonymus.sheep@gmail.com
* @version v1.0
*/

public interface GestionClienteController {
	
	/**
	 * Se crea un nuevo usuario que llego por medio de un pedido en formato JSON
	 * @input 
	 * @return Estado de la creacion. Ok / Error
	 */
	public String crearCliente(String json);
	
	public String createCountry(String json);
	
	
	
	
}
