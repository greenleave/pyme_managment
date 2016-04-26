package ar.com.greenleave.pyme_managment.pymeManagmentWeb.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.greenleave.pyme_managment.pymeManagmentWeb.controller.LoginController;

@Component
@Path("/userCenter")
public class LoginPymeRestService {
	
	@Autowired
	LoginController loginController;
	
	public static final String CHARSET_UTF8 = "; charset=utf-8";
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response login(final String json){
		String resultado = loginController.login(json);
		return Response.status(201).entity(resultado).build();
	}
	
	
	@GET
	@Path("/login2")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response loginGet(final String json){
		String resultado = loginController.login("{userName:'seeb', password:'seeb143'}");
		return Response.status(201).entity(resultado).build();
	}
	
}
