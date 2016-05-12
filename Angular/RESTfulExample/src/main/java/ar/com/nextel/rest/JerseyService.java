package ar.com.nextel.rest;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import ar.com.nextel.nexus.business.ProvinciaBO;
import ar.com.nextel.nexus.model.Provincia;

@Path("/service")
@Component
public class JerseyService {
	
	public static final String CHARSET_UTF8 = "; charset=utf-8";
	
	//@Autowired
	private ProvinciaBO provinciaBo;
	
	private void initialize(){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("BeanLocations.xml");
				
		provinciaBo = (ProvinciaBO)appContext.getBean("provinciaBo");
	}
	
	@GET
	@Path("/provincia/{param}")
	@Produces(MediaType.TEXT_PLAIN + CHARSET_UTF8)
	public String getProvince(@PathParam("param") Integer pParam) {
		
		if(provinciaBo == null){
			initialize();
		}		

		return provinciaBo.getProvinciaById(pParam).getProvincia(); 
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.TEXT_PLAIN + CHARSET_UTF8)
	public Provincia setProvince(@PathParam("param") Integer pParam) {
 
		if(provinciaBo == null){
			initialize();
		}
		
		Provincia provincia = new Provincia();
		provincia.setID(provinciaBo.getProvinciaById(pParam).getID());
		provincia.setProvincia(provinciaBo.getProvinciaById(pParam).getProvincia());		

		return provincia; 
	}		
	
	@GET
	@Path("/json/get/{param}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Provincia getJsonProvince(@PathParam("param") Integer pParam) {
 
		if(provinciaBo == null){
			initialize();
		}
		
		Provincia provincia = new Provincia();
		provincia.setID(provinciaBo.getProvinciaById(pParam).getID());
		provincia.setProvincia(provinciaBo.getProvinciaById(pParam).getProvincia());		

		return provincia; 
	}
 
}