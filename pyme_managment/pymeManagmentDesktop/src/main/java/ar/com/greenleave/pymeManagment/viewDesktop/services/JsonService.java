package ar.com.greenleave.pymeManagment.viewDesktop.services;

public interface JsonService {
	
	public String toJson(Object jsonElement);
	
	 public Object fromJson(String json, Object object);
}
