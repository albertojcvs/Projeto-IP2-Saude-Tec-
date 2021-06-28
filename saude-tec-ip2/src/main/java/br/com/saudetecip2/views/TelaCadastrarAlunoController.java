package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javafx.fxml.Initializable;

public class TelaCadastrarAlunoController implements Initializable {

	@FXML
    private Label lbNome;

    @FXML
    private Text txtCadastrar;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCPF;

    @FXML
    private Label lbCPF;

    @FXML
    private DatePicker campoDataNasc;

    @FXML
    private Label lbDataNasc;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnCancelar;

    @FXML
    void cadastrar(MouseEvent event) {

    }

    @FXML
    void cancelar(MouseEvent event) {
    	try {
    		Parent componente = FXMLLoader.load(getClass().getResource("TelaFuncionarioView.fxml"));
    		btnCancelar.getScene().setRoot(componente);
    	}catch(Exception e) {
    		
    	}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
