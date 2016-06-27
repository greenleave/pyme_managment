package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO;

import java.util.ArrayList;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils.PantallaEnum;

/**
 * 
 * @author sbogado
 *
 * Objetivo: En esta clase se almacenará información del scope(Contexto de ejecución) 
 * del usuario.
 */
public class ClientContext {

	
	private static ArrayList<PantallaEnum> pantallaEnum;
	
	public static ArrayList<PantallaEnum> getPantallaEnum() {
		return pantallaEnum;
	}

	public static void setPantallaEnum(ArrayList<PantallaEnum> pantallaEnum) {
		ClientContext.pantallaEnum = pantallaEnum;
	}
	
	public static void addPantalla(PantallaEnum pantallaEnum){
		ClientContext.pantallaEnum.add(pantallaEnum);
	}
	
}
