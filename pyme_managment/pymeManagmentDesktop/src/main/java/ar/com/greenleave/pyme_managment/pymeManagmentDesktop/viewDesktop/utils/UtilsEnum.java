package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils;

public enum UtilsEnum {
	LOCALIZACION_APP_CONTEXT("");
	
	
	private String text;
	
	private UtilsEnum(String texto){
		this.text = texto;
	}
	
	public String getText(){
		return this.text;
	}
}
