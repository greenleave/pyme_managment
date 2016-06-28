package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils;



public enum DireccionesEnum {
	ROOT("localhost:8080"),
	USER_CENTER("/userCenter"),
	GESTION_CLIENTE("/gestionCliente"),
	LOGIN("/login");
	private String direccion;
	private DireccionesEnum(String direccionAsentada){
		direccion = direccionAsentada;
	}
	public String getDireccion(){
		return direccion;
	}	
}
