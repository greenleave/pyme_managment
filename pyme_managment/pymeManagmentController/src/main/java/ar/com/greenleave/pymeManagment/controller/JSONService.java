package ar.com.greenleave.pymeManagment.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.web.context.WebApplicationContext;

import ar.com.greenleave.pymeManagment.model.gestionCliente.Country;
import ar.com.greenleave.pymeManagment.model.gestionCliente.dao.impl.GestionClienteDaoImpl;
import ar.com.greenleave.pymeManagment.model.service.GestionClienteManager;

@Path("/json/product")
public class JSONService {
	
	private WebApplicationContext context;
	private DozerBeanMapper mapper;
	private GestionClienteManager gestionCliente;
	
	public JSONService() {
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		mapper = (DozerBeanMapper) context.getBean("mapperDozer");
		gestionCliente = (GestionClienteManager) context.getBean("infoClienteService");
	}
	
			
			
	@GET
	@Path("/get")
	@Produces("application/json")
	public Product getProductInJSON() {

		Product product = new Product();
		product.setName("iPad 3");
		product.setQty(999);

		return product;

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product) {
		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();

	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response saveContry(Country contry) {
		
//		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();

	}

}