package br.com.saudetecip2.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class TelaGerenteController implements Initializable {
	 
	 	ObservableList<String> cargos = FXCollections.observableArrayList("Professor", "Gerente", "Atendente", "OutroCargo");
	
	    @FXML
	    private Text txtTitulo;

	    @FXML
	    private Label lbCadastrarFuncionario;

	    @FXML
	    private Label lbNome;

	    @FXML
	    private Label lbCPF;

	    @FXML
	    private Label lbNascimento;

	    @FXML
	    private Label lbCargo;

	    @FXML
	    private TextField campoNome;

	    @FXML
	    private TextField campoCPF;

	    @FXML
	    private DatePicker campoDataNasc;

	    @FXML
	    private ChoiceBox<String> campoCargo;

	    @FXML
	    private Button btCadastrarFuncionario;
	    
	    @FXML
	    private Button btnDemitir;

	    @FXML
	    private Button btnagendarAula;

	    @FXML
	    private Button btnRemoverAula;

	    @FXML
	    private Button btnAddAlunoNaAula;

	    @FXML
	    private Button btnRemoverAlunoDaAula;

	    @FXML
	    private Button btnMatricularAluno;

	    @FXML
	    private Button btnRemoverAluno;
	    
	    @FXML
	    private Button btnVoltar;
	    
	    @FXML
	    void voltarParaTelaFuncionario(MouseEvent event) {
	    	try {
	    		Parent componente = FXMLLoader.load(getClass().getResource("TelaFuncionarioView.fxml"));
	    		btnVoltar.getScene().setRoot(componente);
	    	}catch(Exception e) {
	    		
	    	}

	    }


	    @FXML
	    void AddAlunoNaAula(MouseEvent event) {
	    	System.out.println("Adicionar aluno na aula");
	    }

	    @FXML
	    void RemoverAlunoDaAula(MouseEvent event) {
	    	System.out.println("Remover aluno da aula");
	    }

	    @FXML
	    void agendarAula(MouseEvent event) {
	    	System.out.println("Agendar aula");
	    }

	    @FXML
	    void demitirFuncionario(MouseEvent event) {
	    	System.out.println("Demitir funcionário");
	    }

	    @FXML
	    void matricularAluno(MouseEvent event) {
	    	System.out.println("Matricular aluno");
	    }

	    @FXML
	    void removerAluno(MouseEvent event) {
	    	System.out.println("remover aluno");
	    }

	    @FXML
	    void removerAula(MouseEvent event) {
	    	System.out.println("remover aula");
	    }
	    
	    @FXML
	    void cadastrarFuncionario(MouseEvent event) {
	    	System.out.println(campoNome.getText());
	    	System.out.println(campoCPF.getText());
	    	System.out.println(campoDataNasc.getValue());
	    	System.out.println(campoCargo.getValue());
	    	
	    }
	    
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		campoCargo.setValue("Professor");
		campoCargo.setItems(cargos);
		
	}

}
