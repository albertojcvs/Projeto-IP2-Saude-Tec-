package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class TelaFuncionarioController implements Initializable{

	  @FXML
	    private Text txtTitulo;

	    @FXML
	    private Button btnCadastrar;

	    @FXML
	    private Button btnLogin;

	    @FXML
	    private Button btnVoltarParaHome;

	    @FXML
	    void cadastrar(MouseEvent event) {
	    	System.out.println("Cadastrar");
	    	try {
	    		Parent componente = FXMLLoader.load(getClass().getResource("TelaCadastrarAlunoView.fxml"));
	    		btnCadastrar.getScene().setRoot(componente);
	    	}catch(Exception e) {
	    		
	    	}
	    }

	    @FXML
	    void logar(MouseEvent event) {
	    	System.out.println("Login");

	    }

	    @FXML
	    void voltarParaHome(MouseEvent event) {
	    	System.out.println("Voltar");
	    	try {
	    		Parent componente = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
	    		btnVoltarParaHome.getScene().setRoot(componente);
	    	}catch(Exception e) {
	    		
	    	}

	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
