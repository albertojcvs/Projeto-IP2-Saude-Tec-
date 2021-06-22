package br.com.saudetecip2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

@SpringBootApplication
public class SaudeTecIp2Application extends Application {
	
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		BorderPane root = FXMLLoader.load(getClass().getResource("views/HomeView.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		//SpringApplication.run(SaudeTecIp2Application.class, args);
		System.out.println();
		launch(args);
		
	}

	

}
