package ar.com.greenleave.pymeManagment.controller.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.greenleave.pymeManagment.controller.LoginController;

@Path("/login")
@Component
public class LoginWebService {
	
	@Autowired
	LoginController loginController;
	
	public static final String CHARSET_UTF8 = "; charset=utf-8";
	
	@POST
	@Path("/gestionCliente/createNewCountry")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response loginUser(final String json){
		String resultado = loginController.login(json); 	
		return Response.status(201).entity(resultado).build();
	}
}