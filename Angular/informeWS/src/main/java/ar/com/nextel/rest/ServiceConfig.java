package ar.com.nextel.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class ServiceConfig extends ResourceConfig{

	public ServiceConfig(){
		
		register(RequestContextFilter.class);
		register(JerseyService.class);		

	}

}
