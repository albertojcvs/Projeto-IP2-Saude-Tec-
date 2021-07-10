package br.com.saudetecip2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.saudetecip2.controller.AlunoController;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SaudeTecIp2Application extends Application {
	
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		
		Parent root = FXMLLoader.load(getClass().getResource("views/HomeView.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		AlunoController alunoController = new AlunoController();
		try {
			Aluno a  = alunoController.buscarAluno("111111");
			System.out.println(a.getNome());
		} catch (AlunoNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args);
		
	}

}