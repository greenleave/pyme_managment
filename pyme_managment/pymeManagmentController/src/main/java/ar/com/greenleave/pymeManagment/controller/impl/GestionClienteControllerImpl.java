package ar.com.greenleave.pymeManagment.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import ar.com.greenleave.pymeManagment.controller.GestionClienteController;
import ar.com.greenleave.pymeManagment.model.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.service.GestionClienteManager;

/**
 * @since 11/03/2016
 * @author Sebastian Emanuel Enrique Bogado
 * @mailTo: anonymus.sheep@yahoo.com
 * @version v1.0
 */

public class GestionClienteControllerImpl implements GestionClienteController {
	@Autowired
	GestionClienteManager gestionClienteManager;

	private Gson gson = new Gson();

	/**
	 * Se crea un nuevo usuario que llego por medio de un pedido en formato JSON
	 * 
	 * @input
	 * @return Estado de la creacion. Ok / Error
	 */
	@Override
	public String createCliente(String json) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String updateClient(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteClient(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createCountry(String json){
		Country country = gson.fromJson(json, Country.class);
		gestionClienteManager.saveCountry(country);
		return "Todo ok";
	}
}
