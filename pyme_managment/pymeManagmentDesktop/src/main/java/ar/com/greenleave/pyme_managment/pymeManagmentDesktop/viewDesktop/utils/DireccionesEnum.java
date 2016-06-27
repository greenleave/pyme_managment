package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils;



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
