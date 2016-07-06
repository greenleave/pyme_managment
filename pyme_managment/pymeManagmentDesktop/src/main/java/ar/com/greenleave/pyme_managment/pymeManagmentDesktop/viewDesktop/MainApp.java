package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.eventbus.EventBus;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.controller.ScreensController;
import javafx.application.Application;
import javafx.stage.Stage;

// https://unpocodejava.wordpress.com/2012/07/05/patron-event-bus/
public class MainApp extends Application {
	private static final Logger log = LoggerFactory.getLogger(MainApp.class);
	private static final EventBus eventBus = new EventBus();
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	private ScreensController screensController;

	@Override
	public void start(Stage stage) throws Exception {
		log.info("Comienza el programa");
		screensController = (ScreensController) applicationContext.getBean("screensController");
		// Seteo el applicationContext al controller, para que sepa que mierda
		// tiene
		screensController.init(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static ApplicationContext getApplicationContext() {
		return MainApp.applicationContext;
	}

	public static EventBus getEventBus() {
		return eventBus;
	}
}
