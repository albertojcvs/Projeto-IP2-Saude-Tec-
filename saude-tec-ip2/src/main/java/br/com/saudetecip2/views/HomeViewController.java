package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class HomeViewController implements Initializable {

		
	   @FXML
	    private Button areaFuncionario;

	   @FXML
	    private Button botaoAreaAluno;
	    @FXML
	    void chamarTelaFuncionario(MouseEvent event) {
	    	System.out.println("Botão clicado.");
	    	
	    } 
	    
	    private void irParaLoginAluno() {	    	
	    	try {
	    		Parent novaTela = FXMLLoader.load(getClass().getResource("LoginAluno.fxml"));
	    		botaoAreaAluno.getScene().setRoot(novaTela);
	    	}catch(Exception e) {
	    		System.out.println("Erro!!!\n"+e);
	    	}
	    }
	    @SuppressWarnings("restriction")
		@FXML
	    void onBotaoAreaAlunoClicked(MouseEvent event) {
	    		irParaLoginAluno();
	    }
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}  
	

}
