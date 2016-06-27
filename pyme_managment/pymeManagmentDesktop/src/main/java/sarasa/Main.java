package sarasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.com.greenleave.pymeManagment.viewDesktop.DTO.GestionCliente.PersonDTO;
import ar.com.greenleave.pymeManagment.viewDesktop.services.JsonService;

public class Main {
	@Autowired
	private static JsonService jsonService;
	public static ClassPathXmlApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PersonDTO persona = new PersonDTO();
		persona.setName("Emanuel Bogado");
		persona.setDocument("1111111111");
		jsonService= (JsonService)applicationContext.getBean("jsonService");
		System.out.println(jsonService.toJson(persona));
	}
}
