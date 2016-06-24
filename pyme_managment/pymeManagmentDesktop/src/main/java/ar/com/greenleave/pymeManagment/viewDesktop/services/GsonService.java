package ar.com.greenleave.pymeManagment.viewDesktop.services;

import com.google.gson.JsonElement;

public interface GsonService {
	String toGson(JsonElement jsonElement);
	<T> fromGson (JsonElement jsonElement, Class<T> classOfT);
	
}
