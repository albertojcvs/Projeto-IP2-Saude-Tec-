package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeViewController implements Initializable {

		
	   @FXML
	    private Button areaFuncionario;

	    @FXML
	    void chamarTelaFuncionario(MouseEvent event) {
	    	System.out.println("Botão clicado.");
	    	
	    } 
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}  
	

}
