package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.ui.events;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO.UserDTO;

public class LoginEvent extends GenericEvent {
	private UserDTO userDTO;
	
	public LoginEvent(UserDTO user){
		userDTO=user;
	}
	
	public UserDTO getUserDTO(){
		return this.userDTO;
	}
	
}
