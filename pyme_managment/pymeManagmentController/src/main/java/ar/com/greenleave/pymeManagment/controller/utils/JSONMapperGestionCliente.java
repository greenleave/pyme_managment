package ar.com.greenleave.pymeManagment.controller.utils;

import javax.json.JsonObject;

import ar.com.greenleave.pymeManagment.model.gestionCliente.Country;

/**
 * 
 * @author sbogado
 * @since 11/03/2016
 * @mailTo: anonymus.sheep@gmail.com
 * @version v1.0
 *
 */


public class JSONMapperGestionCliente {

	/**
	 * Este metodo recibe un JsonObject
	 * Mapeandolo al correspondiente 
	 * de Java utilizado en el model
	 * 
	 * @param jsonObject
	 * @return Country
	 */
	
	public static Country mappCountry(JsonObject jsonObject){
		return new Country();
	}
	
}
