package ar.com.greenleave.pyme_managment.pymeManagmentWeb.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.greenleave.pyme_managment.pymeManagmentWeb.service.GestionPymeService;

@Component
@Path("/payment")
public class GestionPymeRestService {

	@Autowired
	GestionPymeService gestionPymeService;
	
	@GET
	@Path("/mkyong")
	public Response savePayment() {

		String result = gestionPymeService.save();

		return Response.status(200).entity(result).build();

	}
	
}
