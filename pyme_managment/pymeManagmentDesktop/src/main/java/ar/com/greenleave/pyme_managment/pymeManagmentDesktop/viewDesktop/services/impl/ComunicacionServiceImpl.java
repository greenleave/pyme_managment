package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.impl;



import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.ComunicacionService;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils.DireccionesEnum;


@Service("comunicacionService")
public class ComunicacionServiceImpl implements ComunicacionService {

	@Override
	public void loguearPersona(Gson json) {
		String direccion = DireccionesEnum.ROOT.getDireccion()+DireccionesEnum.USER_CENTER.getDireccion()+ DireccionesEnum.LOGIN.getDireccion();
		
	}

}
