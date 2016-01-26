package ar.com.greenleave.pyme_managment.view.dto;

import java.util.List;

import ar.com.greenleave.pyme_managment.dto.PermisoDTO;

public class UserDTO {

	private String userName;
	private List<PermisoDTO> permisos;
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<PermisoDTO> getPermisos() {
		return permisos;
	}
	public void setPermisos(List<PermisoDTO> permisos) {
		this.permisos = permisos;
	}
	
	
	
}
