package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.facade;

import java.util.HashMap;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.controller.BasicScreenController;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils.PantallaEnum;

public abstract class FacadeScreens {
	
	private static HashMap<PantallaEnum, BasicScreenController> controlladoresDePantalla= new HashMap<PantallaEnum, BasicScreenController>();
	
	public static void addPantalla(PantallaEnum pantallaEnum, BasicScreenController pantalla){
		controlladoresDePantalla.put(pantallaEnum, pantalla);
	}
	
	public static BasicScreenController getBasicScreenController(PantallaEnum key){
		return controlladoresDePantalla.get(key);
	}
	
	
	
}
