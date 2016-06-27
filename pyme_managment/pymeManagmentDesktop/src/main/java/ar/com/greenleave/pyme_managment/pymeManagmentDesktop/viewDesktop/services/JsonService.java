package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services;



public interface JsonService {
	
	public String toJson(Object jsonElement);
	
	 public Object fromJson(String json, Object object);
}
