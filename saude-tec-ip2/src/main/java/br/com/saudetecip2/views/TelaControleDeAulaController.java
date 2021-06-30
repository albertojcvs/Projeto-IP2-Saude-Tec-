package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

public class TelaControleDeAulaController implements Initializable{

    @FXML
    private Tab opAgendarAula;

    @FXML
    private Text txtID;

    @FXML
    private Label lbData;

    @FXML
    private ChoiceBox<?> campoTreino;

    @FXML
    private Label lbTreino;

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
    private Label lblCpfAluno;

    @FXML
    private Label lbIDAula;

    @FXML
    private TextField campCpfAluno;

    @FXML
    private TextField campoIDAula;

    @FXML
    private Button btnAdicionarAlunoNaAula;

    @FXML
    private Label lbIDAluno;

    @FXML
    private Label lbIDAula1;

    @FXML
    private TextField campoIDAluno;

    @FXML
    private TextField campoIDAula1;

    @FXML
    private Button btnRemoverAlunoDaAula;

    @FXML
    void adicionarAlunoNaAula(MouseEvent event) {

    }

    @FXML
    void agendarAula(MouseEvent event) {

    }

    @FXML
    void removerAlunoDaAula(MouseEvent event) {

    }

    @FXML
    void removerAula(MouseEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
