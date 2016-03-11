package ar.com.greenleave.pymeManagment.controller.rest.config;

import java.util.logging.Logger;


import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import ar.com.greenleave.pymeManagment.controller.rest.service.GestionClienteWService;


/**
* @since 11/03/2016
* @author Sebastian Emanuel Enrique Bogado
* @mailTo: anonymus.sheep@gmail.com
* @version v1.0
* 
*/

public class ServiceConfig extends ResourceConfig{
	
	
	public ServiceConfig(){
		register(RequestContextFilter.class);
		register(JacksonFeature.class);
		//Registro el servicio web		
		register(GestionClienteWService.class);
		//Agrego el paquete en el que esta la clase que registre anteriormente		
		packages("ar.com.greenleave.pymeManagment.controller.rest.service","org.glassfish.jersey.examples.jackson");
		//Logging
		registerInstances(new LoggingFilter(Logger.getLogger(ServiceConfig.class.getName()), true));
		//Trace
        property(ServerProperties.TRACING, "ALL");
	}
	
}
