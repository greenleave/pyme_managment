package ar.com.greenleave.pymeManagment.viewDesktop.utils;

public enum DireccionesEnum {
	ROOT("localhost:8080"),
	USER_CENTER("/userCenter"),
	GESTION_CLIENTE("/gestionCliente");
	
	private String direccionFinal;
	private DireccionesEnum(String direccion){
		direccionFinal= direccion;
	}
	public String getDireccionFinal(){
		return direccionFinal;
	}
	
	
	
}
