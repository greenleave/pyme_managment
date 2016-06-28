package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.ui.events;

import java.util.ArrayList;
import java.util.List;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.ui.events.handlers.GenericEventHandler;

public abstract class GenericEvent {

	private static List<GenericEventHandler> listeners=new ArrayList<GenericEventHandler>();
	
	
	public void fireEvent(GenericEvent evento){
		
	}
}
