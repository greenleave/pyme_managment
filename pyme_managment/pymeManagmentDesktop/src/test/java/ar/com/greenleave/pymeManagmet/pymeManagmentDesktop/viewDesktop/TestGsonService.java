package ar.com.greenleave.pymeManagmet.pymeManagmentDesktop.viewDesktop;

import org.junit.Test;

import ar.com.greenleave.pymeManagment.viewDesktop.DTO.GestionCliente.PersonDTO;
import ar.com.greenleave.pymeManagment.viewDesktop.services.JsonService;
import ar.com.greenleave.pymeManagment.viewDesktop.services.impl.JsonServiceImplDesktop;

public class TestGsonService {
	@Test
	public void testToJson(){
		PersonDTO persona = new PersonDTO();
		persona.setName("Sebastian Emanuel");
		persona.setDocument("38.256.096");
		JsonService jsonService= new JsonServiceImplDesktop();
		System.out.println( jsonService.toJson(persona));
	}
	
	
	@Test
	public void testFromJson(){
		PersonDTO persona = new PersonDTO();
		persona.setName("Sebastian Emanuel");
		persona.setDocument("38.256.096");
		JsonService jsonService= new JsonServiceImplDesktop();
		String sarasa= jsonService.toJson(persona);
		PersonDTO persona2 = (PersonDTO) jsonService.fromJson(sarasa, persona);
		persona2.setName("Emanuel");
		System.out.println(jsonService.toJson(persona2));
	}
}
