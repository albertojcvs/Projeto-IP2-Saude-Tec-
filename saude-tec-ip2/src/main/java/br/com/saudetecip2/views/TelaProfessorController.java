package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


import javafx.fxml.Initializable;

public class TelaProfessorController implements Initializable{
	
 	ObservableList<String> treinos = FXCollections.observableArrayList("MUSCULAÇÃO", "AERÓBICA", "DANÇA", "YOGA", "HIDROGINÁSTICA");

	
	  @FXML
	    private Text txtTitulo;

	    @FXML
	    private Button btnVerAulasAgendadas;

	    @FXML
	    private Tab opAgendarAula;

	    @FXML
	    private Text txtID;

	    @FXML
	    private Label lbData;

	    @FXML
	    private ChoiceBox<String> campoTreino;

	    @FXML
	    private Label lbTreino;

	    @FXML
	    private TextField campoIDAgendarAula;

	    @FXML
	    private DatePicker campoDataAgendarAula;

	    @FXML
	    private Button btnAgendarAula;

	    @FXML
	    private Tab opRemoverAula;

	    @FXML
	    private Label lbIDRemoverAula;

	    @FXML
	    private TextField campoRemoverAula;

	    @FXML
	    private Button btnRemoverAula;

	    @FXML
	    private Tab opAddAlunoNaAula;

	    @FXML
	    private Label lbIDAluno;

	    @FXML
	    private Label lbIDAula;

	    @FXML
	    private TextField campoIDAluno;

	    @FXML
	    private TextField campoIDAula;

	    @FXML
	    private Button btnAdicionarAlunoNaAula;

	    @FXML
	    private Tab opRemoverAlunoDaAula;

	    @FXML
	    private Button btnRemoverAlunoDaAula;

	    @FXML
	    void adicionarAlunoNaAula(MouseEvent event) {
	    	
	    }

	    @FXML
	    void agendarAula(MouseEvent event) {
	        	
	    	System.out.println(campoIDAgendarAula.getText());
	    	System.out.println(campoDataAgendarAula.getValue());
	    	System.out.println(campoTreino.getValue());
	    	
	    }

	    @FXML
	    void removerAlunoDaAula(MouseEvent event) {

	    }

	    @FXML
	    void removerAula(MouseEvent event) {

	    }

	    @FXML
	    void verAulasAgendada(MouseEvent event) {

	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		campoTreino.setValue("MUSCULAÇÃO");
		campoTreino.setItems(treinos);
		
		
	}

}
