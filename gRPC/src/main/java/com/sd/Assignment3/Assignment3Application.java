package com.sd.Assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Assignment3Application extends Application {

	private FXMLLoader fxmlLoader;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
		ApplicationContext context = SpringApplication.run(Assignment3Application.class);
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(context::getBean);
	}

	@Override
	public void start(Stage stage) throws Exception {
		fxmlLoader = new FXMLLoader(
				Assignment3Application.class.getResource("/firstpage.fxml"));
		AnchorPane page = (AnchorPane) fxmlLoader.load();
		Scene scene = new Scene(page);

		stage.setTitle("First Page");
		stage.setScene(scene);

		stage.show();
	}
}