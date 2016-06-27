package ar.com.greenleave.pymeManagment.viewDesktop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		log.info("Starting Hello JavaFX and Maven demonstration application");

		String fxmlFile = "/fxml/hello.fxml";
		log.debug("Loading FXML for main view from: {}", fxmlFile);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(Main.class.getResource("/fxml/hello.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Bluerift Timeline");
			primaryStage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
