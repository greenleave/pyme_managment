package ar.com.greenleave.pymeManagment.controller.rest.config;

import javax.ws.rs.Path;


@Path("/")
public class JSONService{
	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -8305371354724486924L;
//	private WebApplicationContext context;
//
//	public JSONService() {
//		super();
//		context= WebApplicationContextUtils.getWebApplicationContext(getServletContext());		
////		mapper = (DozerBeanMapper) context.getBean("mapperDozer");
//		gestionCliente = (GestionClienteManager)context.getBean("infoClienteService");
//	}
//	
//	
//
//	@GET
//	@Path("/get")
//	@Produces("application/json")
//	public Product getProductInJSON() {
//
//		Product product = new Product();
//		product.setName("iPad 3");
//		product.setQty(999);
//
//		return product;
//
//	}
//
//	@POST
//	@Path("/post")
//	@Consumes("application/json")
//	public Response createProductInJSON(Product product) {
//		String result = "Product created : " + product;
//		return Response.status(201).entity(result).build();
//	}
//
//	@POST
//	@Path("gestionCliente/post/SavePais")
//	@Consumes("application/json")
//	public Response saveContry(Country country) {
//		gestionCliente.saveCountry(country);
//		String result = "Product created : " + country;
//		return Response.status(201).entity(result).build();
//
//	}

}
