package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.impl;


import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.JsonService;

/**
 * 
 * @author sbogado
 * Objetivo: 	Hacer una instancia unica de gson. Y convertirlo en un servicio.
 * 				De esta forma se ahorra toda la cantidad de memoria que requeriría
 * 			 	instanciar uno por uno los objetos gson. Va a dejar que todo dependa de spring
 */

@Service("jsonService")
public final class JsonServiceImplDesktop implements JsonService{
	private static Gson gson = new Gson();
	
	@Override
	public String toJson(Object jsonElement) {
		if(gson==null){
			gson=new Gson();
		}
		return gson.toJson(jsonElement);
	}

	@Override
	public Object fromJson(String json, Object object) {
		return gson.fromJson(json, object.getClass());
	}
}
