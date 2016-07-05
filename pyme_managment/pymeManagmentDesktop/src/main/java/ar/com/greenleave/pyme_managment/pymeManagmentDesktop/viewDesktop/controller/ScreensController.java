package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO.UserDTO;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.JsonService;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.ui.controller.BasicScreenController;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils.PantallaEnum;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Service("screensController")
public class ScreensController implements ApplicationContextAware{
	
	@Autowired (required=true)
	private JsonService jsonService;
	private static final Logger log = LoggerFactory.getLogger(ScreensController.class);
	private HashMap<PantallaEnum, BasicScreenController> controlladoresDePantalla= new HashMap<PantallaEnum, BasicScreenController>();
	private BasicScreenController currentScreen;
	private Stack<BasicScreenController> pilaDeLlamadoDePantallas = new Stack<BasicScreenController>();
	private ApplicationContext applicationContext;
	private Stage stage;
	
	public void init(Stage stage) {
		UserDTO usuario=new UserDTO();
		usuario.setEmail("seebogado@hotmail.com");
		usuario.setPassword("xplotion");
		System.out.println(jsonService.toJson(usuario));
		this.stage= stage;
		//Cargo el controlador del login con el stage.
		this.controlladoresDePantalla.put(PantallaEnum.LOGIN, (BasicScreenController) applicationContext.getBean("loginController"));
		loadScreen(PantallaEnum.LOGIN);
		this.stage.show();
	}
	
	/**
	 * 
	 * @param pantallaEnum
	 * @param pantalla
	 * Objetivo: Se utiliza para agregar los controladores al Hash
	 * al cual se puede acceder mediante los diferentes Enum 
	 */
	public void addPantalla(PantallaEnum pantallaEnum, BasicScreenController pantalla){
		this.controlladoresDePantalla.put(pantallaEnum, pantalla);
	}
	
	public  BasicScreenController getBasicScreenController(PantallaEnum key){
		return controlladoresDePantalla.get(key);
	}
	
	public void loadScreen(String fxmlFile){
		pilaDeLlamadoDePantallas.push(currentScreen);
	}
	
	
	/**
	 * 
	 * @param pantallaEnum
	 * Objetivo: Cargo la pantalla mediante el enum
	 */
	public void loadScreen(PantallaEnum pantallaEnum){
		this.pilaDeLlamadoDePantallas.push(this.currentScreen);
		this.currentScreen = (BasicScreenController)this.applicationContext.getBean(pantallaEnum.getNameBeanSpring());
		FXMLLoader loader = new FXMLLoader();
		try {
			Parent rootNode = (Parent)loader.load(getClass().getResourceAsStream(pantallaEnum.getFxmlFile()));
			loader.setController(this.controlladoresDePantalla.get(pantallaEnum));
			Scene scene = new Scene(rootNode, 400, 200);
			scene.getStylesheets().add("/styles/styles.css");
			
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			log.error("Error 01: Error al cargar la pantalla en el controlador");
			e.printStackTrace();
		}		
//		log.info("Starting Hello JavaFX and Maven demonstration application");
//		String fxmlFile = "/fxml/hello.fxml";
//		log.debug("Loading FXML for main view from: {}", fxmlFile);
//		FXMLLoader loader = new FXMLLoader();
//		Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
//
//		log.debug("Showing JFX scene");
//		Scene scene = new Scene(rootNode, 400, 200);
//		scene.getStylesheets().add("/styles/styles.css");
//
//		stage.setTitle("Login");
//		stage.setScene(scene);
//		stage.show();

	}
	
	public void loadPreviousScreen(){
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext= applicationContext;
	}

		
}
