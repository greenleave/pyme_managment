package ar.com.greenleave.pymeManagment.controller;

import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.greenleave.pymeManagment.controller.utils.JSONHelper;
import ar.com.greenleave.pymeManagment.controller.utils.JSONMapperGestionCliente;
import ar.com.greenleave.pymeManagment.model.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.service.GestionClienteManager;

/**
* @since 11/03/2016
* @author Sebastian Emanuel Enrique Bogado
* @mailTo: anonymus.sheep@gmail.com
* @version v1.0
*/

public class GestionClienteController {
	@Autowired
	GestionClienteManager gestionClienteManager;
	
	
	/**
	 * Se crea un nuevo usuario que llego por medio de un pedido en formato JSON
	 * @input 
	 * @return Estado de la creacion. Ok / Error
	 */
	public String crearCliente(String json){
		JsonObject jsonObject = JSONHelper.buildJsonFromString(json);
		return null;
	}
	
	public String createCountry(String json){
		JsonObject jsonObject = JSONHelper.buildJsonFromString(json);
//		Country country= JSONMapperGestionCliente.mappCountry(jsonObject);
		return "Todo ok";
	}
	
	
	
	
}
