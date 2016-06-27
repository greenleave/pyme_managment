package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.controller;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils.EnumAccion;

/**
 * 
 * @author sbogado Objetivo: Se va a crear una clase abtract que sepa dibujarse
 *         a si misma. A s� mismo, va a ser manipulada por FacadeScreen. De esta
 *         forma, las pantallas que est�n instanciadas, van a comunicarse con
 *         FacadeScreen para que esta les devuelva la informaci�n para que
 *         trabajen. Se va a redifinir el comportamiento de las acciones que
 *         realice la pantalla
 */
public abstract class BasicScreenController {

	private String titulo;
	private String resource;

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

	
	/**
	 * Objetivo: 	Tengo que poder hacer que identifique la accion a realizar, levante el valor y a partir de ah�
	 * 				poder determinar que accion se debe realizar. Eso va a ir con un switch sobre un enum
	 * 
	 */
	public void accion() {
		
	}

	public abstract void inicializarce(String json);

	public abstract void capturarAccion(EnumAccion accion);

}
