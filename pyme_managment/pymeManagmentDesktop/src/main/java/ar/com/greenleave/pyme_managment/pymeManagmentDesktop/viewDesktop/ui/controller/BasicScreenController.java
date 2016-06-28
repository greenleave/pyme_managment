package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.ui.controller;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils.PantallaEnum;

/**
 * 
 * @author sbogado Objetivo: Se va a crear una clase abtract que sepa dibujarse
 *         a si misma. A sí mismo, va a ser manipulada por FacadeScreen. De esta
 *         forma, las pantallas que estén instanciadas, van a comunicarse con
 *         FacadeScreen para que esta les devuelva la información para que
 *         trabajen. Se va a redifinir el comportamiento de las acciones que
 *         realice la pantalla
 */
public abstract class BasicScreenController {

	private String titulo;
	// el fxml
	private String resource;
	private PantallaEnum nextScreen;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public abstract void inicializarce(String json);
	
	public PantallaEnum getNextScreen(){
		return nextScreen;
	}
}
