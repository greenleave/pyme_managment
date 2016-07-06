package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.impl;



import org.springframework.stereotype.Service;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.ComunicacionService;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils.DireccionesEnum;


@Service("comunicacionService")
public class ComunicacionServiceImpl implements ComunicacionService {

	@Override
	public void loguearPersona(String json) {
		System.out.println("Esta es la dirección:  " + json);
		String direccion = DireccionesEnum.ROOT.getDireccion()+DireccionesEnum.USER_CENTER.getDireccion()+ DireccionesEnum.LOGIN.getDireccion();
		System.out.println(direccion);
	}

}
