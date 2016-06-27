package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	private static final Logger log = LoggerFactory.getLogger(MainApp.class);
	private static ApplicationContext applicationContext= new ClassPathXmlApplicationContext("ApplicationContext.xml");
	
	
	@Override
	public void start(Stage stage) throws Exception {
		log.info("Starting Hello JavaFX and Maven demonstration application");

		String fxmlFile = "/fxml/hello.fxml";
		log.debug("Loading FXML for main view from: {}", fxmlFile);
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

		log.debug("Showing JFX scene");
		Scene scene = new Scene(rootNode, 400, 200);
		scene.getStylesheets().add("/styles/styles.css");

		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
