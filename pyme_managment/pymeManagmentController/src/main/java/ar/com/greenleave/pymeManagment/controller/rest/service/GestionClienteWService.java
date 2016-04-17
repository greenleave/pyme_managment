package ar.com.greenleave.pymeManagment.controller.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.greenleave.pymeManagment.controller.GestionClienteController;

/**
* @since 11/03/2016
* @author Sebastian Emanuel Enrique Bogado
* @mailTo: anonymus.sheep@gmail.com
* @version v1.0
*/

@Path("/pymeManagment")
@Component
public class GestionClienteWService {
	
	@Autowired
	GestionClienteController gestionCliente;
	
	public static final String CHARSET_UTF8 = "; charset=utf-8";
	
	@GET
	@Path("/index")
	public Response getIndex(){
		
		return null;
	}
	
	@POST
	@Path("/gestionCliente/createNewCountry")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response createNewClient(final String json){
		String resultado = gestionCliente.createCountry(json);		
		return Response.status(201).entity(resultado).build();
	}
	
}
