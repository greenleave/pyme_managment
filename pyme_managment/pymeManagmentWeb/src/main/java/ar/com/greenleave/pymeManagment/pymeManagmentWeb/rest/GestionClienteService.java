package ar.com.greenleave.pymeManagment.pymeManagmentWeb.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.greenleave.pymeManagment.pymeManagmentWeb.controller.GestionPymeController;

@Component
@Path("/gestionCliente")
public class GestionClienteService {

	@Autowired
	private GestionPymeController gestionClienteController;
	
	public static final String CHARSET_UTF8 = "; charset=utf-8";
	
	@POST
	@Path("/getClientes")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response getClientes(){
		String result = gestionClienteController.getClients();
		return Response.status(201).entity(result).build();
	}
	
	
}
