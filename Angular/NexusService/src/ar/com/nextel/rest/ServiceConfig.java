package ar.com.nextel.rest;

import java.util.logging.Logger;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * <p>
 * <b>Name:</b> EntidadDao
 * </p>
 * <p>
 * <b>System:</b> TDL
 * </p>
 * <p>
 * <b>Description:</b> Interface that extends GenericDao and declare
 * findEntityByID method
 * </p>
 *
 * @since 07/10/2014
 * @author Fernando N. Tobares García
 * @version v1.0
 * 
 */
public class ServiceConfig extends ResourceConfig {	

	/**
	 * Obtener un reporte en especial - Generico
	 * @return true si el cliente es Consumidor Final, false en caso contrario.
	 */
	public ServiceConfig() {
		
		register(RequestContextFilter.class);
		register(JacksonFeature.class);
		register(Service.class);
		packages("ar.com.nextel.rest","org.glassfish.jersey.examples.jackson");
		//Logging
		registerInstances(new LoggingFilter(Logger.getLogger(ServiceConfig.class.getName()), true));
		//Trace
        property(ServerProperties.TRACING, "ALL");
	}
}
