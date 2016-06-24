package ar.com.greenleave.pymeManagment.viewDesktop.services.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import ar.com.greenleave.pymeManagment.viewDesktop.services.JsonService;

/**
 * 
 * @author sbogado
 * Objetivo: 	Hacer una instancia unica de gson. Y convertirlo en un servicio.
 * 				De esta forma se ahorra toda la cantidad de memoria que requeriría
 * 			 	instanciar uno por uno los objetos gson
 */
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
