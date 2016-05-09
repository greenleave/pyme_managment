package ar.com.greenleave.pyme_managment.pymeManagmentWeb.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.greenleave.pyme_managment.pymeManagmentWeb.controller.GestionPymeController;

@Component
@Path("/payment")
public class GestionPymeRestService {

	@Autowired
	GestionPymeController gestionPymeController;
	public static final String CHARSET_UTF8 = "; charset=utf-8";
	
	
	@GET
	@Path("/mkyong")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response savePayment() {

		String result = gestionPymeController.getCountries();
		return Response.status(200).entity(result).build();

	}
	
}
