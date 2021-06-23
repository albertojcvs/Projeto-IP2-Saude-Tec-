package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeViewController implements Initializable {

		
	   @FXML
	    private Button areaFuncionario;

	    @FXML
	    void chamarTelaFuncionario(MouseEvent event) {
	    	System.out.println("Botão clicado.");
	    	try{
	    		Parent componente = FXMLLoader.load(getClass().getResource("TelaFuncionarioView.fxml"));
	    		areaFuncionario.getScene().setRoot(componente);
	    	} catch(Exception e) {
	    		System.out.println("Erro!");
	    	}
	    	
	    } 
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}  
	

}
