package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils;

public enum PantallaEnum {
	LOGIN("loginController", "/fxml/login.fxml"),
	MENU_PRINCIPAL("mainMenuController", "/fxml/main_menu.fxml");
	private String nameBeanSpring;
	private String fxmlFile;
	
	private PantallaEnum(String bean, String fxmlFile){
		this.nameBeanSpring = bean;
		this.fxmlFile=fxmlFile;
	}
	
	public String getNameBeanSpring(){
		return nameBeanSpring;
	}

	public String getFxmlFile() {
		return fxmlFile;
	}
}
